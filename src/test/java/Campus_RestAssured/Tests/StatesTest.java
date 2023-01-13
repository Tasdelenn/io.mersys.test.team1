package Campus_RestAssured.Tests;


import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.States;
import Campus_RestAssured.Models.StatesCountry;
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

public class StatesTest {
    Cookies cookies;

    @BeforeClass
    public void loginCampus() {
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
                        .post("auth/login")

                        .then()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()
        ;
    }

    States state = new States();
    StatesCountry statesCountry=new StatesCountry("63a45bdbcb75ee5c2199a8cf");
    String stateID;
    String stateName;
    String stateShortName;

    Faker faker = new Faker();

    @Test
    public void Create1_CreateAnewStateFromExistingCountries() {
        stateName =faker.address().state();
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
                        //.log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }
    @Test(dependsOnMethods = "Create1_CreateAnewStateFromExistingCountries")
    public void CreateNegative_CreateTheSameState(){
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
                //.log().body()
                .statusCode(400)
                .body("name", equalTo(null))
        ;
    }
    @Test(dependsOnMethods = "CreateNegative_CreateTheSameState")
    public void Edit1_UpdateStateFromExistingCountries(){
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
                //.log().body()
                .statusCode(200)
                .body("name", equalTo(stateName))
        ;

    }

    @Test(dependsOnMethods = "Edit1_UpdateStateFromExistingCountries")
    public void Delete1_DeleteNewCreatedStateFromExistingCountries(){
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("stateID", stateID)
                .when()
                .delete("school-service/api/states/{stateID}")
                .then()
                //.log().body()
                .statusCode(200)

        ;
    }
    @Test(dependsOnMethods = "Delete1_DeleteNewCreatedStateFromExistingCountries")
    public void DeleteNegative_DeleteTheSameState(){
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("stateID", stateID)
                .when()
                .delete("school-service/api/states/{stateID}")
                .then()
                //.log().body()
                .statusCode(400)

        ;
    }
}
