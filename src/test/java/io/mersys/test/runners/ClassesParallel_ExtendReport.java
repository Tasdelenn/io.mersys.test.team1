package io.mersys.test.runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.mersys.test.utilities.BaseDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(
        tags = "@Classes",
        features = {"src/test/resources/featureFiles/Campus_Classes"},
        glue = {"classpath:io/mersys/test/stepDefinitions"}
        //, dryRun = true
        /**
        ,
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "timeline:target/timeline-report",
                "html:target//cucumber-reports.html"
        },
        dryRun = false,
        // true olduğunda testi çalıştırma sadece feature lara
        // ait steplerin varlığını kontrol eder.
        // false olduğunda ise testi çalıştırır.

        publish = true
         */
)

public class ClassesParallel_ExtendReport extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) // bazı java versiyon hataları için
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        BaseDriver.threadBrowserName.set(browser);
        //  burada browser set edilecek >> [ilgili threade 'e browser'ı ata.]

    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy : Campus Classes Tests");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus UI");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Tested By", "Hakan Taşdelen");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Classes Parallel Test Sonucu");
    }
}
