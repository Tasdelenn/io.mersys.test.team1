package io.mersys.test.runners;


import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(

        features = {"src/test/resources/featureFiles/Campus15_Citizenship/",
                "src/test/resources/featureFiles/_Samples_/"
        },
        glue = {"classpath:io/mersys/test/stepDefinitions"},
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
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class BelirliFeaturelariCalistir extends AbstractTestNGCucumberTests {   // abstract class a extend etmezsek çalışmaz

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus_SomeFeatures");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Samples ve Citizenships Test Sonucu");
    }

}
