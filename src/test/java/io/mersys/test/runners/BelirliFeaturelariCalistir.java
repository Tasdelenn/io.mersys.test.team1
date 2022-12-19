package io.mersys.test.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "timeline:target/timeline-report"
        },
        features = {"src/test/resources/featureFiles/Login.feature",
                "src/test/resources/featureFiles/Country.feature"
        },
        glue = {"io/mersys/test/stepDefinitions"},
        dryRun = false,    // true olduğunda testi çalıştırma sadece feature lara
        // ait steplerin varlığını kontrol eder.
        // false olduğunda ise testi çalıştırır.
        tags = "",
        publish = true

)
public class BelirliFeaturelariCalistir extends AbstractTestNGCucumberTests {   // abstract class a extend etmezsek çalışmaz
}
