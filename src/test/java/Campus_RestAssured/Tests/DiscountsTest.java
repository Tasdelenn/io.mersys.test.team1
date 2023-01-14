package Campus_RestAssured.Tests;

import Campus_RestAssured.Models.Discounts;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DiscountsTest extends Hooks{

    Faker faker = new Faker();
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
    @Test
    public void listOfDiscounts() {

        given()
                .cookies(cookies)
                .body("{}")
                .contentType(ContentType.JSON)

                .when()
                .post("/school-service/api/discounts/search")

                .then()
                .statusCode(200)
                .log().body()
        ;
    }

}
