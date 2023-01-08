package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.HR_Attestations;
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

public class HR_AttestationsTest {
    Cookies cookies;

    @BeforeClass
    public void loginCampus() {
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

    String attestationsID;
    String attestationsName;

    @Test
    public void createAttestations() {
        attestationsName = getRandomName();
        HR_Attestations attestation = new HR_Attestations();
        attestation.setName(attestationsName);

        attestationsID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(attestation)

                        .when()
                        .post("school-service/api/attestation")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
        System.out.println("attestationsID = " + attestationsID);
    }

    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(6).toLowerCase();
    }


    @Test(dependsOnMethods = "createAttestations")
    public void createAttestationsNegative() {
        HR_Attestations attestation = new HR_Attestations();
        attestation.setName(attestationsName);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(attestation)

                .when()
                .post("school-service/api/attestation")

                .then()
                .log().body()
                .statusCode(400)
                //.body("message",equalTo("The Attestation with Name \"" + attestationsName + "\" already exists.")) >> Attestation ile with arasında iki boşluk var!!!
                .body("message", equalTo("The Attestation  with Name \"" + attestationsName + "\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createAttestations")
    public void updateAttestations() {
        attestationsName = getRandomName();
        HR_Attestations attestation = new HR_Attestations();
        attestation.setId(attestationsID);
        attestation.setName(attestationsName);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(attestation)

                .when()
                .put("school-service/api/attestation")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(attestationsName))
        ;
    }

    @Test
    public void deleteAttestationsById() {
        given()
                .cookies(cookies)
                .pathParam("attestationsID", attestationsID)

                .when()
                .delete("school-service/api/attestation/{attestationsID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "deleteAttestationsById")
    public void deleteAttestationsByIdNegative() {
        given()
                .cookies(cookies)
                .pathParam("attestationsID", attestationsID)
                .log().uri()
                .when()
                .delete("school-service/api/attestation/{attestationsID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "deleteAttestationsById")
    public void updateAttestationsNegative() {
        attestationsName = getRandomName();

        HR_Attestations attestation = new HR_Attestations();
        attestation.setId(attestationsID);
        attestation.setName(attestationsName);


        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(attestation)

                .when()
                .put("school-service/api/attestation")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Attestation not found"))
        ;
    }


}
