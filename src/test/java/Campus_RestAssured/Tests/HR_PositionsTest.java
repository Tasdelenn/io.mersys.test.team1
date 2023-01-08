package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.HR_Positions;
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

public class HR_PositionsTest {

    Cookies cookies;
    Faker faker = new Faker();

    @BeforeClass
    public void login() {

        // src/main/resources/configuration.properties dosyasından kullanıcı adı, şifre, url
        // gibi bilgileri okuyup, String bir değişkene atadık:
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

    String positionID;
    String positionName;
    String positionShortName;
    String tenantId = "6390ef53f697997914ec20c2";


    @Test
    public void createHRPosition() {
        //positionName=getRandomName();
        //positionShortName =getRandomShortName();
        positionName = faker.job().title() + faker.job().position();
        positionShortName = positionName.substring(0,3);

        HR_Positions position = new HR_Positions();
        position.setName(positionName);
        position.setShortName(positionShortName);
        position.setTenantId(tenantId);
        position.setActive(true);

        positionID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(position)

                        .when()
                        .post("school-service/api/employee-position")
                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;

    }


    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase();
    }

    public String getRandomShortName() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase();
    }
}
