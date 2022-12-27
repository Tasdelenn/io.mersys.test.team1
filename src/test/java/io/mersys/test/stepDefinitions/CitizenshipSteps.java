package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;

public class CitizenshipSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenShip");
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "vatandas");
        dc.findAndSend("shortName", "vd");
        dc.findAndClick("saveButton");
    }

    @When("User Create Again Citizenship name as {string} short name as {string}")
    public void userCreateAgainCitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("shortName",shortName);
        dc.findAndClick("saveButton");
    }

    @And("User should be update the citizenship name as {string} code as {string}")
    public void userShouldUpdateTheCitizanshipNameAsStringCodeAsString(String citizenshipName, String shortName) {
        dc.findAndClick("editButton3");
        dc.findAndSend("nameInput", citizenshipName);
        dc.findAndSend("shortName", shortName);
        dc.findAndClick("saveButton");
    }

}
