package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Document;
import Campus_RestAssured.Models.Nationalities;
import io.mersys.test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NationalitiesTest {

    Cookies cookies;

    @BeforeClass
    public void Login() {
        String urlValue = ConfigurationReader.getProperty("url");
        String usernameValue = ConfigurationReader.getProperty("confUsername");
        String passwordValue = ConfigurationReader.getProperty("confPassword");
        String rememberMeValue = ConfigurationReader.getProperty("confRememberMe");


        baseURI = urlValue;

        Map<String, String> account = new HashMap<>();
        account.put("username", usernameValue);
        account.put("password", passwordValue);
        account.put("rememberMe", rememberMeValue);


        cookies =
                given()
                        .contentType(ContentType.JSON)
                        .body(account)

                        .when()
                        .post("/auth/login")


                        .then()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()
        ;
    }


    String nationalityID;
    String nationalityName;

    @Test
    public void createNationality() {

        nationalityName = getRandomName();

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName);

        nationalityID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(nationalities)

                        .when()
                        .post("school-service/api/nationality")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")

        ;
    }


    @Test(dependsOnMethods = "createNationality")
    public void createNationalityNegative() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName);
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .post("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }


    @Test(dependsOnMethods = "createNationalityNegative")
    public void updateNationality() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName+"Düzenlendi");
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .put("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(nationalityName+"Düzenlendi"))

        ;
    }


    @Test(dependsOnMethods = "updateNationality")
    public void deleteNationalityByID() {

        given()
                .cookies(cookies)
                .pathParam("nationalityID", nationalityID)

                .when()
                .delete("school-service/api/nationality/{nationalityID}")

                .then()
                .log().body()
                .statusCode(200)

        ;
    }


    @Test(dependsOnMethods = "deleteNationalityByID")
    public void deleteNationalityByIDNegative() {

        given()
                .cookies(cookies)
                .pathParam("nationalityID", nationalityID)

                .when()
                .delete("school-service/api/nationality/{nationalityID}")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Nationality not  found"))
        ;
    }

    @Test(dependsOnMethods = "deleteNationalityByIDNegative")
    public void updateNationalityNegative() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName+"Düzenlendi(Başarısız güncelleme.)");
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .put("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("GENERAL.ERROR.ATTACHMENT_TYPE_NOT_FOUND"))

        ;
    }


    public String getRandomName() {
        String rdm = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        return rdm + "->TEAM1<-" + rdm;
    }

    public Boolean getRandomTrueFalse() {
//        Random rd = new Random();
//        return rd.nextBoolean();
        return new Random().nextBoolean();
    }


}
