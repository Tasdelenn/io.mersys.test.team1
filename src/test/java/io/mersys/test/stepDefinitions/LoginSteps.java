package io.mersys.test.stepDefinitions;

import io.mersys.test.pages.DialogContent;
import io.mersys.test.utilities.BaseDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.utilities.ConfigurationReader;

public class LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to Mersys Campus")
    public void navigateToCampus() {

        System.out.println(ConfigurationReader.getProperty("url")); // kontrol amaçlı "configuration.properties" 'den okuma
        BaseDriver.getDriver().get(ConfigurationReader.getProperty("url"));
        dc.findAndClick("acceptCookies");
        BaseDriver.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        String usernameValue = ConfigurationReader.getProperty("confUsername");
        String passwordValue = ConfigurationReader.getProperty("confPassword");
        dc.findAndSend("username", usernameValue);
        dc.findAndSend("password", passwordValue);
        dc.findAndClick("loginButton");
    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {
//        dc.waitUntilVisible(dc.dashboard);
//        Assert.assertTrue(dc.dashboard.getText().contains("Dashboard"));

        dc.findAndContainsText("dashboard", "Dashboard");
    }
}
