package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Cities;
import Campus_RestAssured.Models.Country;
import Campus_RestAssured.Models.GradeLevels;
import Campus_RestAssured.Models.States;
import com.aventstack.extentreports.service.ExtentService;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CitiesTest extends Hooks{
    Faker fakeData = new Faker();
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

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(CitiesTest.class.getName(), "Mehmet Haşir Dut, Hakan Taşdelen");
    }

}