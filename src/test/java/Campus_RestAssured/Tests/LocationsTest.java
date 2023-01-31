package Campus_RestAssured.Tests;
import Campus_RestAssured.Models.Document;
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
