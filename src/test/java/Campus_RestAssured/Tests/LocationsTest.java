package Campus_RestAssured.Tests;
import Campus_RestAssured.Models.Locations;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LocationsTest extends Hooks{

    String LocationID;
    String LocationName;

    @Test
    public void createLocation() {

        LocationName = getRandomName();
        Boolean rndTF = getRandomTrueFalse();
        int rndKapasite= getRandomInt();

        Locations locations=new Locations();
        locations.setName(LocationName);
        locations.setShortName("T1S");
        locations.setActive(rndTF);
        locations.setCapacity(rndKapasite);
        locations.setType("LABORATORY");
        locations.setSchool("6390f3207a3bcb6a7ac977f9");


        LocationID =
                given()
                        .cookies(cookies)
                        .contentType(ContentType.JSON)
                        .body(locations)

                        .when()
                        .post("school-service/api/location")

                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().jsonPath().getString("id")
        ;
    }


    @Test(dependsOnMethods = "createLocation")
    public void createLocationNegative() {

        Boolean rndTF = getRandomTrueFalse();
        int rndKapasite= getRandomInt();

        Locations locations=new Locations();
        locations.setId(LocationID);
        locations.setName(LocationName);
        locations.setShortName("T1S");
        locations.setActive(rndTF);
        locations.setCapacity(rndKapasite);
        locations.setType("LABORATORY");
        locations.setSchool("6390f3207a3bcb6a7ac977f9");


        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(locations)

                .when()
                .post("school-service/api/location")

                .then()
                .log().body()
                .statusCode(400)
        ;
    }







    public String getRandomName() {
        String rdm = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        return rdm + "->Team1School<-" + rdm;
    }

    public int getRandomInt() {
        return new Random().nextInt(1000);
    }

//    public String getRandomType() {
//        Random rd = new Random();
//        int i=rd.nextInt(2);
//        String[] type={"LABORATORY","CLASS","OTHER"};
//        return type.get(i);
//    }

    public Boolean getRandomTrueFalse() {
//        Random rd = new Random();
//        return rd.nextBoolean();
        return new Random().nextBoolean();
    }

}