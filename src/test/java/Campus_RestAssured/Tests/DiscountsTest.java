package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Discounts;
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

public class DiscountsTest {
    Cookies cookies;
    Faker faker = new Faker();

    @BeforeClass
    public void loginCampus() {
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
    String discountsDescription;
    String discountsCode;
    int discountsPriority;
    String discountsID;

    @Test
    public void createDiscount() {

        discountsDescription =faker.commerce().color()+" "+ String.valueOf(faker.random().nextInt(1000));
        discountsCode = "sd "+String.valueOf(faker.random().nextInt(1000));
        discountsPriority = faker.number().numberBetween(1,500);

        Discounts discounts = new Discounts();
        discounts.setDescription(discountsDescription);
        discounts.setCode(discountsCode);
        discounts.setPriority(discountsPriority);

        discountsID
                =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(discounts)

                        .when()
                        .post("school-service/api/discounts")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }

    @Test(dependsOnMethods = "createDiscount")
    public void createDiscountNegative() {

        Discounts discounts = new Discounts();
        discounts.setDescription(discountsDescription);
        discounts.setCode(discountsCode);
        discounts.setPriority(discountsPriority);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(discounts)

                .when()
                .post("school-service/api/discounts")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("The Discount with Description \""+ discountsDescription +"\" already exists."))
        ;
    }

    @Test(dependsOnMethods = "createDiscount")
    public void updateDiscount() {
        discountsDescription = faker.commerce().productName()+String.valueOf(faker.random().nextInt(1000));

        Discounts discounts = new Discounts();
        discounts.setId(discountsID);
        discounts.setDescription(discountsDescription);
        discounts.setCode(discountsCode);
        discounts.setPriority(discountsPriority);

        given()
                .cookies(cookies)
                .body(discounts)
                .contentType(ContentType.JSON)
                .when()
                .put("/school-service/api/discounts")
                .then()
                .statusCode(200)
                .log().body()
                .body("description", equalTo(discountsDescription))
        ;

    }

    @Test(dependsOnMethods = "updateDiscount")
    public void deleteDiscountById() {

        given()
                .cookies(cookies)
                .pathParam("discountsId", discountsID)

                .when()
                .delete("/school-service/api/discounts/{discountsId}")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

    @Test(dependsOnMethods = "deleteDiscountById")
    public void deleteDiscountByIdNegative() {

        given()
                .cookies(cookies)
                .pathParam("discountsId", discountsID)

                .when()
                .delete("/school-service/api/discounts/{discountsId}")

                .then()
                .statusCode(400)
                .log().body()
        ;
    }

    @Test(dependsOnMethods = "deleteDiscountById")
    public void updateDiscountNegative()
    {
        discountsDescription = faker.commerce().color()+" "+ String.valueOf(faker.random().nextInt(500));

        Discounts discounts = new Discounts();
        discounts.setId(discountsID);
        discounts.setDescription(discountsDescription);
        discounts.setCode(discountsCode);
        discounts.setPriority(discountsPriority);

        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(discounts)

                .when()
                .put("school-service/api/discounts")

                .then()
                .log().body()
                .statusCode(400)
                .body("message", equalTo("Discount not found"))
        ;
    }

}
