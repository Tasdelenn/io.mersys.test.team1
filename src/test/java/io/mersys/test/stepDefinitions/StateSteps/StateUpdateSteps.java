package io.mersys.test.stepDefinitions.StateSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.pages.StatesContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class StateUpdateSteps {
       DialogContent dc = new DialogContent();
      StatesContent sk= new StatesContent();
    Actions actions=new Actions(BaseDriver.getDriver());
    @When("Edit State from existing Country")
    public void editStateFromExistingCountry() {

        sk.findAndClick("selectCountryinSrearch");
        actions.moveToElement(sk.selectCountryinSrearch).sendKeys("Australia").click().build().perform();
        sk.findAndSend("searchNameInput","melek sehir");
        sk.findAndClick("searchButton");
        sk.findAndClick("editButton");
        sk.findAndSend("nameInput","Melek Sehri");
        sk.findAndSend("shortName","MK");
        sk.findAndClick("saveButton");
    }

    @When("Edit the new State by create a new country")
    public void editTheNewStateByCreateANewCountry() {
        sk.findAndSend("searchNameInput","Almaty");
        sk.findAndClick("searchButton");
        sk.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput","Atlant");
        dc.findAndSend("codeInput", "AT");
        sk.findAndClick("stateExists");
        sk.findAndClick("countrySaveButton");


    }

    @Then("Update State and save")
    public void updateStateAndSave() {
        actions.moveToElement(sk.selectCountryinWindow).click().sendKeys("Atlant").click().build().perform();
        sk.findAndSend("nameInput","Almaty1");
        sk.findAndClick("saveButton");
    }


    @When("Create a new country without state from Edit State window")
    public void createANewCountryWithoutStateFromEditStateWindow() {
        sk.findAndSend("searchNameInput","Almaty1");
        sk.findAndClick("searchButton");
        sk.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput","Kazak Yeli");
        dc.findAndSend("codeInput", "KY");
        sk.findAndClick("countrySaveButton");

    }

    @Then("The created Country not found and the state was not successfully updated")
    public void theCreatedCountryNotFoundAndTheStateWasNotSuccessfullyUpdated() {
        actions.moveToElement(sk.selectCountryinWindow).click().build().perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Kazak Yeli".toLowerCase()));

    }
}
