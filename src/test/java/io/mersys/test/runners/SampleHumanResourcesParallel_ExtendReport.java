package io.mersys.test.runners;

        import com.aventstack.extentreports.service.ExtentService;
        import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;
        import io.mersys.test.utilities.BaseDriver;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Listeners;
        import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@HumanResourcesTest",
        features = {"src/test/resources/featureFiles/_Samples_/humanResources.feature"},
        glue = {"classpath:io/mersys/test/stepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class SampleHumanResourcesParallel_ExtendReport extends AbstractTestNGCucumberTests{

    @BeforeClass(alwaysRun = true) // bazı java versiyon hataları için
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        BaseDriver.threadBrowserName.set(browser);
        //  burada browser set edilecek >> [ilgili threade 'e browser'ı ata.]

    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy : HumanResources Tests");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "HumanResources Test Sonucu");
    }
}
