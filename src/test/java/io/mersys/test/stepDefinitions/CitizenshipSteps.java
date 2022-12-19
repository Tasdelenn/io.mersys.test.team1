package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;

public class CitizenshipSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenShip");
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput","deneme123");
        dc.findAndSend("shortName","dnm123");
        dc.findAndClick("saveButton");
    }


    @When("User update the created Citizenship")
    public void userUpdateTheCreatedCitizenship() {
    }

    @When("User delete the updated Citizenship")
    public void userDeleteTheUpdatedCitizenship() {
    }
}
