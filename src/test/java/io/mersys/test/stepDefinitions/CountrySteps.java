package io.mersys.test.stepDefinitions;

import com.github.javafaker.Faker;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class CountrySteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    Faker fakeData = new Faker();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne"); // Setup Click
        ln.findAndClick("parameters"); // Parameters Click
        ln.findAndClick("countries"); // Countries Click
    }

    @When("Create a country")
    public void createACountry() {
        //String randomGenName= RandomStringUtils.randomAlphabetic(8);
        String randomGenName = '#' + fakeData.country().name();
        //String randomGenCode= RandomStringUtils.randomNumeric(4);
        String randomGenCode = fakeData.random().hex(4);

        System.out.println("randomGenName = " + randomGenName + "\n" +  //Kontrol amaçlı
                "randomGenCode = " + randomGenCode);

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", randomGenName);
        dc.findAndSend("codeInput", randomGenCode);
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage", "success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("saveButton");
    }

    @And("User should update the country name as {string} code as {string}")
    public void userShouldUpdateTheCountryNameAsStringCodeAsString(String countryName, String code) {
        dc.findAndClick("editButton2");
        dc.findAndSend("nameInput", countryName);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("saveButton");
    }
}
