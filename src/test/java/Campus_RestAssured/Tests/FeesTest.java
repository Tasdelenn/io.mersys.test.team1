package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Fees;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FeesTest extends Hooks {

    Faker faker = new Faker();
    String feesName;
    String feesCode;
    String feesIntegrationCode;
    int feesPriority;

    String feesID;

    @Test
    public void createFees() {

        feesName = "document " + String.valueOf(faker.random().nextInt(1000));
        feesCode = "doc " + String.valueOf(faker.random().nextInt(1000));
        feesIntegrationCode = String.valueOf(faker.random().nextInt(1000));
        feesPriority = faker.number().numberBetween(1, 1000);

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
                .body("message", equalTo("The Fee Type with Name \"" + feesName + "\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createFees")
    public void updateFees() {
        feesName = "document " + String.valueOf(faker.random().nextInt(1000)) + " " + faker.name().lastName();

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
                .log().body()
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
    public void updateFeesNegative() {
        feesName = "document " + String.valueOf(faker.random().nextInt(50));

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

    @Test
    public void listOfFees() {

        given()
                .cookies(cookies)
                .body("{}")
                .contentType(ContentType.JSON)

                .when()
                .post("/school-service/api/fee-types/search")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }
}
