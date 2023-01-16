package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.GradeLevels;
import com.aventstack.extentreports.service.ExtentService;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GradeLevelsTest extends Hooks {

    Faker faker = new Faker();
    String gradeLevelID;
    String gradeLevelName;
    String gradeLevelShortName;
    int gradeLevelOrder;

    @Test
    public void createGradeLevel() {

        gradeLevelName = faker.educator().secondarySchool();
        gradeLevelShortName = gradeLevelName.substring(0, 4);
        gradeLevelOrder = (faker.random().nextInt(10));

        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(String.valueOf(gradeLevelOrder));

        gradeLevelID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(gradeLevels)

                        .when()
                        .post("school-service/api/grade-levels")

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

    public int getRandomOrder() {
        return (int) (Math.random() * 100);
    }

    @Test(dependsOnMethods = "createGradeLevel")
    public void createGradeLevelNegative() {
        //"message": "The Grade Level with Name \"Foo Bar\" already exists.",
        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(String.valueOf(gradeLevelOrder));


        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .post("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("The Grade Level with Name \"" + gradeLevelName + "\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createGradeLevel")
    public void updateGradeLevel() {

        gradeLevelName = "Team1 " + gradeLevelName;
        gradeLevelShortName = "T1 " + gradeLevelShortName;
        gradeLevelOrder = (faker.random().nextInt(10));

        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setId(gradeLevelID);
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(String.valueOf(gradeLevelOrder));

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .put("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(gradeLevelName))
        ;
    }

    @Test(dependsOnMethods = "updateGradeLevel")
    public void deleteGradeLevelById() {
        given()
                .cookies(cookies)
                .pathParam("gradeLevelID", gradeLevelID)
                .log().uri()

                .when()
                .delete("school-service/api/grade-levels/{gradeLevelID}")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test(dependsOnMethods = "deleteGradeLevelById")
    public void deleteGradeLevelByIdNegative() {
        given()
                .cookies(cookies)
                .pathParam("gradeLevelID", gradeLevelID)

                .when()
                .delete("school-service/api/grade-levels/{gradeLevelID}")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }

    @Test(dependsOnMethods = "deleteGradeLevelById")
    public void updateGradeLevelNegative() {
        gradeLevelName = getRandomName();
        gradeLevelShortName = getRandomShortName();
        gradeLevelOrder = getRandomOrder();


        GradeLevels gradeLevels = new GradeLevels();
        gradeLevels.setId(gradeLevelID);
        gradeLevels.setName(gradeLevelName);
        gradeLevels.setShortName(gradeLevelShortName);
        gradeLevels.setOrder(String.valueOf(gradeLevelOrder));

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(gradeLevels)

                .when()
                .put("school-service/api/grade-levels")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Grade Level not found."))
        ;
    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().getStats();
        ExtentService.getInstance().setSystemInfo(GradeLevelsTest.class.getName(), "Hakan Taşdelen");
    }
}










