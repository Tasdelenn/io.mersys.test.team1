package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Citizenship;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CitizenShipsTest extends Hooks {

    public String getRandom(int value) {
        return RandomStringUtils.randomAlphabetic(value);
    }

    //Random method yerine faker class 'ı kullanabiliriz:
    //String name = getRandom(8);
    //String shortName = getRandom(4);
    Faker faker = new Faker();
    String name = faker.nation().nationality();
    String shortName = faker.nation().flag();
    String citizenShipId;

    @Test
    public void searchCitizenship() {

        given()
                .cookies(cookies)
                .body("{}")
                .contentType(ContentType.JSON)

                .when()
                .post("/school-service/api/citizenships/search")

                .then()
                .statusCode(200)
                //.log().body()
        ;

    }


    @Test
    public void createCitizenship() {
        Citizenship citizenship = new Citizenship(name, shortName);



        citizenShipId = given()
                .cookies(cookies)
                .body(citizenship)
                .contentType(ContentType.JSON)

                .when()
                .post("/school-service/api/citizenships")

                .then()
                .statusCode(201)
                .log().body()
                .body("name", equalTo(name))
                .extract().jsonPath().getString("id")
        ;
        System.out.println("name manual = " + name);
    }


    @Test(dependsOnMethods = "createCitizenship")
    public void createCitizenshipNegative() {
        Citizenship citizenship = new Citizenship(name, shortName);

        given()
                .cookies(cookies)
                .body(citizenship)
                .contentType(ContentType.JSON)

                .when()
                .post("/school-service/api/citizenships")

                .then()
                .statusCode(400)
                .body("message", equalTo("The Citizenship with Name \"" + name + "\" already exists."))

        ;
        System.out.println("name manual = " + name);
    }

    @Test(dependsOnMethods = "createCitizenship")
    public void updateCitizenship() {

        String updatedName = faker.nation().nationality();
        Citizenship citizenship = new Citizenship(updatedName, shortName);
        citizenship.setId(citizenShipId);

        given()
                .cookies(cookies)
                .body(citizenship)
                .contentType(ContentType.JSON)
                .when()
                .put("/school-service/api/citizenships")
                .then()
                .statusCode(200)
                .body("name", equalTo(updatedName))
        ;
        System.out.println("updatedName = " + updatedName);
    }

    @Test(dependsOnMethods = "updateCitizenship")
    public void deleteById() {

        given()
                .cookies(cookies)
                .pathParam("citizenShipId", citizenShipId)

                .when()
                .delete("/school-service/api/citizenships/{citizenShipId}")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test(dependsOnMethods = "deleteById")
    public void deleteByIdNegative() {

        given()
                .cookies(cookies)
                .pathParam("citizenShipId", citizenShipId)

                .when()
                .delete("/school-service/api/citizenships/{citizenShipId}")

                .then()
                .statusCode(400)
                .log().body()
        ;
    }
}