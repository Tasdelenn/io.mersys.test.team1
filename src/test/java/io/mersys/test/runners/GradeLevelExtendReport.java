package io.mersys.test.runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
        tags = "@GradeLevel",
        features = {"src/test/resources/featureFiles/_Campus4_GradeLevels"},
        glue = {"classpath:io/mersys/test/stepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})
public class GradeLevelExtendReport extends AbstractTestNGCucumberTests{

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Team Name", "Team-1@TechnoStudy : Grade Levels Tests");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus_RestAssured");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Tested By", "Hakan Taşdelen");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "GradeLevels Test Sonucu");
    }
}
