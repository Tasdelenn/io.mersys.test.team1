package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.FormContent;
import org.testng.Assert;

public class SchoolLocationsSteps {

    FormContent fc = new FormContent();
    DialogContent dc = new DialogContent();

    @Then("User should choose the location type Laboratory")
    public void userShouldChooseTheLocationTypeLaboratory() {
        fc.findAndAction("locationType");
        fc.findAndClick("selectLaboratory");
    }

    @Then("Already exists message should be displayed")
    public void alreadyExistsMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExists", "already exists");
    }

    @Then("User should choose the location type Classroom")
    public void userShouldChooseTheLocationTypeClassroom() {
        fc.findAndAction("locationType");
        fc.findAndClick("selectClassroom");
    }

    @Then("Deleted School Location name should not exist")
    public void deletedSchoolLocationNameShouldNotExist() {

        String ilkİsim = dc.getBirinciIsimSilmeDoğrulama().getText();
        System.out.println("ilkİsim = " + ilkİsim);
        Assert.assertEquals(ilkİsim.toString(),"Team1SchoolDüzenlendi");

    }
}
