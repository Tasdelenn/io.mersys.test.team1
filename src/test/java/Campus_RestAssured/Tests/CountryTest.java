package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.GradeLevels;
import com.aventstack.extentreports.service.ExtentService;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CountryTest extends Hooks{

    Faker faker = new Faker();
    String countryID;
    String countryName;
    String countryCode;

    @Test
    public void createCountry() {
        countryName = faker.country().name();
        countryCode = faker.country().currencyCode();

        Country country = new Country();
        country.setName(countryName); // generateCountryName
        country.setCode(countryCode); // generateCountryCode

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


    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(6).toLowerCase();
    }

    public String getRandomCode() {
        return RandomStringUtils.randomAlphabetic(2).toLowerCase();
    }


    @Test(dependsOnMethods = "createCountry")
    public void createCountryNegative() {
        //"message": "The Country with Name \"France 375\" already exists.",

        Country country = new Country();
        country.setName(countryName);
        country.setCode(countryCode);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .post("school-service/api/countries")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("The Country with Name \"" + countryName + "\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createCountry")
    public void updateCountry() {
        //"message": "The Country with Name \"France 375\" already exists.",
        countryName = getRandomName();

        Country country = new Country();
        country.setId(countryID);
        country.setName(countryName);
        country.setCode(countryCode);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .put("school-service/api/countries")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(countryName))
        ;
    }

    @Test(dependsOnMethods = "updateCountry")
    public void deleteCountryById() {
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

    @Test(dependsOnMethods = "deleteCountryById")
    public void deleteCountryByIdNegative() {
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

    @Test(dependsOnMethods = "deleteCountryById")
    public void updateCountryNegative() {
        countryName = getRandomName();

        Country country = new Country();
        country.setId(countryID);
        country.setName(countryName);
        country.setCode(countryCode);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(country)

                .when()
                .put("school-service/api/countries")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Country not found"))
        ;
    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(CountryTest.class.getName(), "Anonymous");
    }

}











