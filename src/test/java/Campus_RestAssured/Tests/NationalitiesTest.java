package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.GradeLevels;
import Campus_RestAssured.Models.Nationalities;
import com.aventstack.extentreports.service.ExtentService;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NationalitiesTest extends Hooks {

    String nationalityID;
    String nationalityName;

    @Test
    public void createNationality() {

        nationalityName = getRandomName();

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName);

        nationalityID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(nationalities)

                        .when()
                        .post("school-service/api/nationality")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "createNationality")
    public void createNationalityNegative() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName);
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .post("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "createNationalityNegative")
    public void updateNationality() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName+"Düzenlendi");
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .put("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(nationalityName+"Düzenlendi"))
        ;
    }

    @Test(dependsOnMethods = "updateNationality")
    public void deleteNationalityByID() {

        given()
                .cookies(cookies)
                .pathParam("nationalityID", nationalityID)

                .when()
                .delete("school-service/api/nationality/{nationalityID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "deleteNationalityByID")
    public void deleteNationalityByIDNegative() {

        given()
                .cookies(cookies)
                .pathParam("nationalityID", nationalityID)

                .when()
                .delete("school-service/api/nationality/{nationalityID}")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Nationality not  found"))
        ;
    }

    @Test(dependsOnMethods = "deleteNationalityByIDNegative")
    public void updateNationalityNegative() {

        Nationalities nationalities = new Nationalities();
        nationalities.setName(nationalityName+"Düzenlendi(Başarısız güncelleme.)");
        nationalities.setId(nationalityID);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(nationalities)

                .when()
                .put("school-service/api/nationality")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Can't find Nationality"))
        ;
    }

    public String getRandomName() {
        String rdm = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        return rdm + "->TEAM1<-" + rdm;
    }

    public Boolean getRandomTrueFalse() {
//        Random rd = new Random();
//        return rd.nextBoolean();
        return new Random().nextBoolean();
    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(NationalitiesTest.class.getName(), "Sema Nur Arslan, Muharrem Karapazar");
    }

}
