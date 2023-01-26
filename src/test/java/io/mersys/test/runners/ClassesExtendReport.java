package io.mersys.test.runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
        tags = "@Classes",
        features = {"src/test/resources/featureFiles/Campus_Classes"},
        glue = {"classpath:io/mersys/test/stepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class ClassesExtendReport extends AbstractTestNGCucumberTests{

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy : Campus Classes Tests");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus UI");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Tested By", "Hakan Taşdelen");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Classes Test Sonucu");
    }
}
