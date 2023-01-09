package Campus_RestAssured.Tests;


import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.States;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class StatesTest {
    Cookies cookies;

    @BeforeClass
    public void loginCampus() {
        baseURI = "https://test.mersys.io/";

        Map<String, String> credential = new HashMap<>();
        credential.put("username", "turkeyts");
        credential.put("password", "TechnoStudy123");
        credential.put("rememberMe", "true");

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

    States state = new States();

    String stateID;
    String stateName;
    String stateShortName;
    String countryID;

    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    public String getRandomShortName() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }
    Country country = new Country();



    @Test
    public void Create1_CreateAnewStateFromExistingCountries() {
        stateName = getRandomName();
        stateShortName = getRandomShortName();
      //  countryID=country.getId("63a45bdbcb75ee5c2199a8cf");
        state.setName(stateName);
        state.setShortName(stateShortName);
        country.setId(countryID);

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

}
