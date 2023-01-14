package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.HR_Positions;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HR_PositionsTest extends Hooks {

    Faker faker = new Faker();
    String positionID;
    String positionName;
    String positionShortName;
    String tenantId = "6390ef53f697997914ec20c2";

    @Test
    public void createHRPosition() {
        //positionName=getRandomName();
        //positionShortName =getRandomShortName();
        positionName = faker.job().title() + faker.job().position();
        positionShortName = positionName.substring(0, 3);

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
