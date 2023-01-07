
package io.mersys.test.runners;

        import com.aventstack.extentreports.service.ExtentService;
        import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.Listeners;

//featureFiles/Campus_8_State/MultiDelete.feature
@CucumberOptions(
        tags = "@StateNegative",
        features = {"src/test/resources/featureFiles/Campus_8_State"},
        glue = {"classpath:io/mersys/test/stepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class StatesNegativeExtendReport extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy : States Negative Tests");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Test Sorumlusu", "Raziyanur Kanatbek");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "States Negative Test Sonucu");
    }
}


