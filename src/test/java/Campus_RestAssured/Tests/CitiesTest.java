package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Cities;
import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.States;
import com.github.javafaker.Faker;
import io.mersys.test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CitiesTest {
    Cookies cookies;
    Faker fakeData = new Faker();

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

    String cityName = fakeData.address().cityName();
    String cityID;
    Cities city;
    Country country;

    @Test
    public void CreateCityFromExistingCountries() {

        country = new Country();
        String countryName;
        String countryID = "5baac28d91cefe05fc6e3fe6"; //USA Country Code
        country.setId(countryID);
        countryName =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(country)

                        .when()
                        .get("school-service/api/countries/5baac28d91cefe05fc6e3fe6")

                        .then()
                        .log().body()
                        .statusCode(200)
                        .extract().jsonPath().getString("name")
        ;

        //country.setName(countryName);
        city = new Cities(cityName, country); // Cities sınıfının içinde bu şekilde bi constructor tanımladık.

        cityID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(city)

                        .when()
                        .post("school-service/api/cities")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "CreateCityFromExistingCountries")
    public void CreateSameCityNegative() {
        country.setId("5baac28d91cefe05fc6e3fe6");
        city.setId(cityID);
        city.setName(cityName);

        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(city)

                .when()
                .post("school-service/api/cities")
                .then()
                .log().body()
                .statusCode(400)
                .body("name", equalTo(null))
        ;
    }

    @Test(dependsOnMethods = "CreateCityFromExistingCountries")
    public void UpdateCityFromExistingCountries() {

        country.setId("5baac28d91cefe05fc6e3fe6");
        States state = new States();
        state.setId("5fa3d5255707157308027d8f"); //Virginia State ID
        city.setId(cityID);
        String updatedCityName = cityName + "_T1";
        city.setName(updatedCityName);
        city.setState(state);

        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(city)

                .when()
                .put("school-service/api/cities")
                .then()
                //.log().body()
                .statusCode(200)
                .body("name", equalTo(updatedCityName))
        ;
    }

    @Test(dependsOnMethods = "UpdateCityFromExistingCountries")
    public void DeleteJustCreatedCityFromExistingCountries() {
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("cityID", cityID)
                .when()
                .delete("school-service/api/cities/{cityID}")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "DeleteJustCreatedCityFromExistingCountries")
    public void DeleteAgainSameNameOfCityNegative() {
        given()

                .cookies(cookies)
                .contentType(ContentType.JSON)
                .pathParam("cityID", cityID)
                .when()
                .delete("school-service/api/cities/{cityID}")
                .then()
                .log().body()
                .statusCode(400) // Silinmiş City'yi tekar silmek istediğimizde "* bulunamadı" hatası vermiyo; status 200 döndürüyo.
        ;
    }
}