package io.mersys.test.stepDefinitions.StateSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.pages.StatesContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.interactions.Actions;

public class ExtraDeleteSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    StatesContent sk= new StatesContent();
    Actions actions=new Actions(BaseDriver.getDriver());
    @Then("Navigate to country page and delete the Country name as{string}")
    public void navigateToCountryPageAndDeleteTheCountryNameAs(String Country) {
        //burasi country page e gitmiyor
        actions.dragAndDropBy(sk.scroll, 0,-200).build().perform();
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
        dc.findAndSend("searchInput",Country);
        dc.findAndClick("searchButton");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @And("User Should not be able to delete successfully")
    public void userShouldNotBeAbleToDeleteSuccessfully() {
       // unsuccess loketoru bulamadim
        dc.findAndContainsText("successMessage", "Could not delete");
    }

}
