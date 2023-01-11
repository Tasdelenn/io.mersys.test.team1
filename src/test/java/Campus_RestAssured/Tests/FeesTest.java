package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Fees;
import com.github.javafaker.Faker;
import io.mersys.test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;

public class FeesTest {
    Cookies cookies;
    Faker faker = new Faker();

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
    String feesName;
    String feesCode;
    String feesIntegrationCode;
    int feesPriority;

    String feesID;

    @Test
    public void createFees() {

        feesName = "document "+ String.valueOf(faker.random().nextInt(50));
        feesCode = "doc "+String.valueOf(faker.random().nextInt(50));
        feesIntegrationCode = String.valueOf(faker.random().nextInt(100));
        feesPriority = faker.number().numberBetween(1,250);

        Fees fees = new Fees();
        fees.setName(feesName);
        fees.setCode(feesCode);
        fees.setBudgetAccountIntegrationCode(feesIntegrationCode);
        fees.setPriority(feesPriority);

        feesID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(fees)

                        .when()
                        .post("school-service/api/fee-types")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "createFees")
    public void createFeesNegative() {

        Fees fees = new Fees();

        fees.setName(feesName);
        fees.setCode(feesCode);
        fees.setBudgetAccountIntegrationCode(feesIntegrationCode);
        fees.setPriority(feesPriority);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(fees)

                .when()
                .post("school-service/api/fee-types")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("The Fee Type  with Name \""+feesName+"\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createFees")
    public void updateFees() {
        feesName = "document "+ String.valueOf(faker.random().nextInt(50));

        Fees fees = new Fees();
        fees.setId(feesID);
        fees.setName(feesName);
        fees.setCode(feesCode);
        fees.setBudgetAccountIntegrationCode(feesIntegrationCode);
        fees.setPriority(feesPriority);

        given()
                .cookies(cookies)
                .body(fees)
                .contentType(ContentType.JSON)
                .when()
                .put("/school-service/api/fee-types")
                .then()
                .statusCode(200)
                .body("name", equalTo(feesName))
        ;

    }

    @Test(dependsOnMethods = "updateFees")
    public void deleteFeesById() {

        given()
                .cookies(cookies)
                .pathParam("feesId", feesID)

                .when()
                .delete("/school-service/api/fee-types/{feesId}")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test(dependsOnMethods = "deleteFeesById")
    public void deleteFeesByIdNegative() {

        given()
                .cookies(cookies)
                .pathParam("feesId", feesID)

                .when()
                .delete("/school-service/api/fee-types/{feesId}")

                .then()
                .statusCode(400)
                .log().body()
        ;
    }

    @Test(dependsOnMethods = "deleteFeesById")
    public void updateFeesNegative()
    {
        feesName = "document "+ String.valueOf(faker.random().nextInt(50));

        Fees fees = new Fees();
        fees.setId(feesID);
        fees.setName(feesName);
        fees.setCode(feesCode);
        fees.setBudgetAccountIntegrationCode(feesIntegrationCode);
        fees.setPriority(feesPriority);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(fees)

                .when()
                .put("school-service/api/fee-types")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Fee Type not found"))
        ;
    }

}
