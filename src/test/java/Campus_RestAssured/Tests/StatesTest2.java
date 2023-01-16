package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.GradeLevels;
import Campus_RestAssured.Models.States;
import Campus_RestAssured.Models.StatesCountry;
import com.aventstack.extentreports.service.ExtentService;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StatesTest2 extends Hooks {
    States state = new States();
    String stateID;
    String stateName;
    String stateShortName;
    Faker faker = new Faker();
    String countryID;
    String countryName;
    String countryCode;

    @Test
    public void CreateAnewCountryWithState(){
        countryName = faker.country().name();
        countryCode = faker.country().currencyCode();

        Country country = new Country();
        country.setName(countryName); // generateCountryName
        country.setCode(countryCode); // generateCountryCode
        country.setHasState(true);

        countryID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(country)

                        .when()
                        .post("school-service/api/countries")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;

    }

    @Test(dependsOnMethods = "CreateAnewCountryWithState")
    public void Create2_CreateAnewStateFromNewCreatedCountry(){
        stateName =faker.address().state();
        stateShortName = faker.address().stateAbbr();
        StatesCountry stateCountry=new StatesCountry(countryID);

        state.setName(stateName);
        state.setShortName(stateShortName);
        state.setCountry(stateCountry);

        stateID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(state)

                        .when()
                        .post("school-service/api/states")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;

    }

    @Test(dependsOnMethods = "Create2_CreateAnewStateFromNewCreatedCountry")
    public void DeleteNegative_DeleteTheCountryWitchHasAState() {

        given()
                .cookies(cookies)
                .pathParam("countryID", countryID)

                .when()
                .delete("school-service/api/countries/{countryID}")

                .then()
                .log().body()
                .statusCode(500)
                .body("message", equalTo("Could not delete from the specified record. Because the record being used by another document(s) : State"))
        ;
    }

    @Test(dependsOnMethods = "DeleteNegative_DeleteTheCountryWitchHasAState")
    public void Delete2_DeleteTheStateByID() {
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("stateID", stateID)

                .when()
                .delete("school-service/api/states/{stateID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "Delete2_DeleteTheStateByID")
    public void DeleteTheNewCreatedCountryById() {
        given()
                .cookies(cookies)
                .pathParam("countryID", countryID)

                .when()
                .delete("school-service/api/countries/{countryID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "DeleteTheNewCreatedCountryById")
    public void DeleteCountryNegative_DeleteTheDeletedCountry() {
        given()
                .cookies(cookies)
                .pathParam("countryID", countryID)
                .log().uri()
                .when()
                .delete("school-service/api/countries/{countryID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(StatesTest2.class.getName(), "Raziya Nur Kanatbek");
    }
}
