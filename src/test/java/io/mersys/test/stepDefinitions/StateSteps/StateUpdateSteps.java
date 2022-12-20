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
    @When("Edit State name as {string} short name as {string} from existing Country")
    public void editStateFromExistingCountry(String stateName, String shortName) {

        sk.findAndClick("selectCountryinSrearch");
        actions.moveToElement(sk.selectCountryinSrearch).sendKeys("Australia").click().build().perform();
        sk.findAndSend("searchNameInput","melek sehir");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndSend("nameInput",stateName);
        dc.findAndSend("shortName",shortName);
        dc.findAndClick("saveButton");
    }

    @When("Edit the new State by create a new country name as {string}, code as {string}")
    public void editTheNewStateByCreateANewCountry(String countryName, String code) {
        sk.findAndSend("searchNameInput","Almaty");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput",countryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("stateExists");
        sk.findAndClick("countrySaveButton");


    }

    @Then("Update State and save")
    public void updateStateAndSave() {
        actions.moveToElement(sk.selectCountryinWindow).click().sendKeys("Atlant").click().build().perform();
        sk.findAndSend("nameInput","Almaty1");
        dc.findAndClick("saveButton");
    }


    @When("Create a new country name as {string} code as {string} without state from Edit State window")
    public void createANewCountryWithoutStateFromEditStateWindow(String countryName, String code) {
        sk.findAndSend("searchNameInput","Almaty1");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput",countryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("countrySaveButton");

    }

    @Then("The created Country not found and the state was not successfully updated")
    public void theCreatedCountryNotFoundAndTheStateWasNotSuccessfullyUpdated() {
        actions.moveToElement(sk.selectCountryinWindow).click().build().perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Kazak Yeli".toLowerCase()));

    }
}
