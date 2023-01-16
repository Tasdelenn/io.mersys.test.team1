package Campus_RestAssured.Tests;

import com.aventstack.extentreports.service.ExtentService;
import io.mersys.test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Hooks {

    Cookies cookies;

    @BeforeClass
    public void loginCampus() {

        System.out.println("::: Starting Automation:::");
        String urlValue = ConfigurationReader.getProperty("url");
        String usernameValue = ConfigurationReader.getProperty("confUsername");
        String passwordValue = ConfigurationReader.getProperty("confPassword");
        String rememberMeValue = ConfigurationReader.getProperty("confRememberMe");

        baseURI = urlValue;

        Map<String, String> account = new HashMap<>();
        account.put("username", usernameValue);
        account.put("password", passwordValue);
        account.put("rememberMe", rememberMeValue);

        cookies =
                given()
                        .contentType(ContentType.JSON)
                        .body(account)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(200)
                        .extract().response().getDetailedCookies()
        ;
    }

    @AfterTest
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus RestAssured Automation Tests");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", baseURI);
    }
}
