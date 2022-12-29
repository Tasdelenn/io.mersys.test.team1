package io.mersys.test.stepDefinitions;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.mersys.test.utilities.BaseDriver;
import io.mersys.test.utilities.ExcelUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {


    @Before
    public void before()
    {
        System.out.println("::: Starting Automation:::");
        LoginSteps login = new LoginSteps();
        login.navigateToCampus();
        login.enterUsernameAndPasswordAndClickLoginButton();
        login.userShouldLoginSuccessfuly();
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("::: End of test execution :::");
        System.out.println("Result of Scenario = "+ scenario.getStatus());
        System.out.println("is Scenario Failed ? = "+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        ExcelUtility.writeExcel("src/main/resources/XLSFiles/ScenarioStatus.xlsx",
                scenario, BaseDriver.threadBrowserName.get(), date.format(formatter));

        if (scenario.isFailed()){
            // klasöre
            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

            //Extend Reporta ekleniyor  EXTEND report olmadığında burası kaldırılmalı !!! yoksa browserlar KAPANMAZ
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("target/FailedScreenShots/"+ scenario.getName()+date.format(formatter)+".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // senaryo hatalı ise ekran görüntüsü al
        BaseDriver.quitDriver();
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
