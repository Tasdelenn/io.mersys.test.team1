package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.GradeLevels;
import com.github.javafaker.Faker;
import io.mersys.test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GradeLevelsTest {
    Cookies cookies;
    Faker faker = new Faker();

    @BeforeClass
    public void login() {

        // src/main/resources/configuration.properties dosyasından kullanıcı adı, şifre, url
        // gibi bilgileri okuyup, String bir değişkene atadık:
        String uriValue = ConfigurationReader.getProperty("url");
        String usernameValue = ConfigurationReader.getProperty("confUsername");
        String passwordValue = ConfigurationReader.getProperty("confPassword");
        String rememberMeValue = ConfigurationReader.getProperty("confRememberMe");

        baseURI = uriValue;

        Map<String, String> credential = new HashMap<>();
        credential.put("username", usernameValue);
        credential.put("password", passwordValue);
        credential.put("rememberMe", rememberMeValue);

        cookies =
                given()
                        .contentType(ContentType.JSON)
                        .body(credential)

                        .when()
                        .post("auth/login")

                        .then()
                        //.log().cookies()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()
        ;
    }

    String gradeLevelID;
    String gradeLevelName;
    String gradeLevelShortName;
    String gradeLevelOrder;

    @Test
    public void createGradeLevel() {

        gradeLevelName = faker.educator().secondarySchool();
        gradeLevelShortName = gradeLevelName.substring(0, 4);
        gradeLevelOrder = String.valueOf(faker.random().nextInt(10));

        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(gradeLevelOrder);

        gradeLevelID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(gradeLevels)

                        .when()
                        .post("school-service/api/grade-levels")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;

    }


    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    public String getRandomShortName() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }

    public String getRandomOrder() {
        return RandomStringUtils.randomAlphanumeric(2).toLowerCase();
    }


    @Test(dependsOnMethods = "createGradeLevel")
    public void createGradeLevelNegative() {
        //"message": "The Country with Name \"France 375\" already exists.",

        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(gradeLevelOrder);


        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .post("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("The Grade Level with Name \"" + gradeLevelName + "\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createGradeLevel")
    public void updateGradeLevel() {

        gradeLevelName = "Team1 " + gradeLevelName;
        gradeLevelShortName = "T1 " + gradeLevelShortName;
        gradeLevelOrder = String.valueOf(faker.random().nextInt(10));

        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setId(gradeLevelID);
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(gradeLevelOrder);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .put("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(gradeLevelName))
        ;
    }

    @Test(dependsOnMethods = "updateGradeLevel")
    public void deleteGradeLevelById() {
        given()
                .cookies(cookies)
                .pathParam("gradeLevelID", gradeLevelID)
                .log().uri()

                .when()
                .delete("school-service/api/grade-levels/{gradeLevelID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "deleteGradeLevelById")
    public void deleteGradeLevelByIdNegative() {
        given()
                .cookies(cookies)
                .pathParam("gradeLevelID", gradeLevelID)

                .when()
                .delete("school-service/api/grade-levels/{gradeLevelID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "deleteGradeLevelById")
    public void updateGradeLevelNegative() {
        gradeLevelName = getRandomName();
        gradeLevelShortName = getRandomShortName();
        gradeLevelOrder = getRandomOrder();


        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setId(gradeLevelID);
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(gradeLevelOrder);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .put("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Grade Level  not found"))
        ;
    }


}











