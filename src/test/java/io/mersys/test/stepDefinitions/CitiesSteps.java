package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.FormContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.pages.StatesContent;

import java.awt.*;

public class CitiesSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    StatesContent sc=new StatesContent();
    FormContent fc=new FormContent();

    @When("User should be click add button")
    public void userShouldBeClickAddButton() {
        dc.findAndClick("addButton");

    }

    @Then("User should choose the country Turkey")
    public void userShouldChooseTheCountryTurkey() {
        fc.findAndAction("countryBlog");
        fc.findAndClick("Turkey");
    }

    @And("User should be write a new city {string} name of sellected country")
    public void userShouldBeWriteANewCityNameOfSellectedCountry(String cityName) {
        sc.findAndSend("nameInput",cityName);
    }

    @Then("User should be click save button")
    public void userShouldBeClickSaveButton() {
        dc.findAndClick("saveButton");
    }

    @Then("User should be see successfully added message")
    public void userShouldBeSeeSuccessfullyAddedMessage() {
        dc.findAndContainsText("successMessage","success");
    }

    @When("User should choose the country Turkey on search form")
    public void userShouldChooseTheCountryTurkeyOnSearchForm() {
        fc.findAndAction("countryBlogSearchForm");
        fc.findAndClick("Turkey");
    }

    @Then("user should write the name {string} of the city to change")
    public void userShouldWriteTheNameOfTheCityToChange(String name) {
        sc.findAndSend("searchNameInput",name);

    }

    @And("User should click the search button and should see the city name")
    public void userShouldClickTheSearchButtonAndShouldSeeTheCityName() {
        dc.findAndClick("searchButton");
    }

    @And("User should be click the edit button")
    public void userShouldBeClickTheEditButton() {
        dc.findAndClick("editButton");
    }

    @And("User should write a new name {string}")
    public void userShouldWriteANewName(String name) {
        sc.findAndSend("nameInput",name);

    }

    @Then("User click the save button and see the successfully updated message")
    public void userClickTheSaveButtonAndSeeTheSuccessfullyUpdatedMessage() {
        dc.findAndClick("saveButton");
        dc.findAndContainsText("successMessage","success");
    }

    @Then("User should write {string} the city name of country")
    public void userShouldWriteTheCityNameOfCountry(String name) {
        sc.findAndSend("searchNameInput",name);
    }

    @And("User should click the search button")
    public void userShouldClickTheSearchButton() {
        dc.findAndClick("searchButton");
    }

    @And("User should click delete button and click the delete on confirmation button")
    public void userShouldClickDeleteButtonAndClickTheDeleteOnConfirmationButton() {
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @Then("User should be see successfuly deleted message")
    public void userShouldBeSeeSuccessfulyDeletedMessage() {
        dc.findAndContainsText("successMessage","success");
    }
}
