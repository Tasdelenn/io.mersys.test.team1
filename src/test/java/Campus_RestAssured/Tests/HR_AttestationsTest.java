package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.HR_Attestations;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HR_AttestationsTest extends Hooks {

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

    @Test(dependsOnMethods = "updateAttestations")
    public void deleteAttestationsById() {
        // HR_Attestations attestation = new HR_Attestations();
        // attestationsID = attestation.getId();
        given()
                .cookies(cookies)
                .pathParam("attestationsID", attestationsID)

                .when()
                .delete("school-service/api/attestation/{attestationsID}")

                .then()
                .log().body()
                .statusCode(204)
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
                .body("message", equalTo("Can't find Attestation"))
        ;
    }
}
