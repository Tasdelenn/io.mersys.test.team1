package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.TopNav;

public class LogoutSteps {

    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @When("User click account button")
    public void userClickAccountButton() {
        tn.findAndClick("accountButton");
    }

    @And("User click to sign out button")
    public void userClickToSignOutButton() {
        tn.findAndClick("signOutButton");
    }

    @Then("User should be logout successfuly")
    public void userShouldBeLogoutSuccessfuly() {
        dc.findAndContainsText("loginButton", "GİRİŞ YAP");
    }
}
