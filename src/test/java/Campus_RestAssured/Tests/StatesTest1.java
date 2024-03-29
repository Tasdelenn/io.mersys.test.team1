package Campus_RestAssured.Tests;

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

public class StatesTest1 extends Hooks {

    States state = new States();
    StatesCountry statesCountry = new StatesCountry("63a45bdbcb75ee5c2199a8cf");
    String stateID;
    String stateName;
    String stateShortName;
    Faker faker = new Faker();

    @Test
    public void Create1_CreateAnewStateFromExistingCountries() {
        stateName = faker.address().state();
        stateShortName = faker.address().stateAbbr();

        state.setName(stateName);
        state.setShortName(stateShortName);
        state.setCountry(statesCountry);

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

    @Test(dependsOnMethods = "Create1_CreateAnewStateFromExistingCountries")
    public void CreateNegative_CreateTheSameState() {
        state.setId(stateID);
        state.setName(stateName);
        state.setShortName(stateShortName);
        state.setCountry(statesCountry);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(state)

                .when()
                .post("school-service/api/states")

                .then()
                .log().body()
                .statusCode(400)
                .body("name", equalTo(null))
        ;
    }

    @Test(dependsOnMethods = "CreateNegative_CreateTheSameState")
    public void Edit1_UpdateStateFromExistingCountries() {
        stateName = faker.address().state();
        stateShortName = faker.address().stateAbbr();

        state.setId(stateID);
        state.setName(stateName);
        state.setShortName(stateShortName);
        state.setCountry(statesCountry);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(state)

                .when()
                .put("school-service/api/states")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(stateName))
        ;
    }

    @Test(dependsOnMethods = "Edit1_UpdateStateFromExistingCountries")
    public void Delete1_DeleteNewCreatedStateFromExistingCountries() {
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

    @Test(dependsOnMethods = "Delete1_DeleteNewCreatedStateFromExistingCountries")
    public void DeleteNegative_DeleteTheSameState() {
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("stateID", stateID)

                .when()
                .delete("school-service/api/states/{stateID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "Delete1_DeleteNewCreatedStateFromExistingCountries")
    public void EditNegative_UpdateTheDeletedState(){
        stateName =faker.address().state();
        stateShortName = faker.address().stateAbbr();

        state.setId(stateID);
        state.setName(stateName);
        state.setShortName(stateShortName);
        state.setCountry(statesCountry);

        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(state)


                .when()
                .put("school-service/api/states")
                .then()
                .log().body()
                .statusCode(400)

        ;

    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(StatesTest1.class.getName(), "Raziya Nur Kanatbek");
    }


}
