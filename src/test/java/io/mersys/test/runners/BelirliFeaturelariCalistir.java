package io.mersys.test.runners;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "timeline:target/timeline-report"
        },
        features = {"src/test/resources/featureFiles/_Public_Login/login.feature",
                "src/test/resources/featureFiles/_Samples_/country.feature"
        },
        glue = {"classpath:io/mersys/test/stepDefinitions"},
        dryRun = false,    // true olduğunda testi çalıştırma sadece feature lara
        // ait steplerin varlığını kontrol eder.
        // false olduğunda ise testi çalıştırır.
        tags = "",
        publish = true

)

@Listeners({ExtentITestListenerClassAdapter.class})
public class BelirliFeaturelariCalistir extends AbstractTestNGCucumberTests {   // abstract class a extend etmezsek çalışmaz
}
