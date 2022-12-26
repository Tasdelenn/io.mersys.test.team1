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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StateUpdateSteps {
    DialogContent dc = new DialogContent();
    StatesContent sk = new StatesContent();
    Actions actions = new Actions(BaseDriver.getDriver());

    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));

    @When("Edit State name as {string} short name as {string} from existing Country {string}")
    public void editStateFromExistingCountry(String stateName, String shortName, String countryName) {
        sk.findAndSend("searchNameInput", "melek sehir");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndSend("nameInput", stateName);
        dc.findAndSend("shortName", shortName);
        dc.findAndClick("saveButton");
    }

    @When("Edit the State named {string} by create a new country name as {string}, code as {string}")
    public void editTheNewStateByCreateANewCountry(String stateName, String countryName, String code) {
        sk.findAndSend("searchNameInput", stateName);
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput", countryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("stateExists");
        sk.findAndClick("countrySaveButton");


    }

    @Then("Update State name as {string} then select country {string} and save")
    public void updateStateAndSave(String stateName, String countryName) {
        Action scrollClick = actions.moveToElement(sk.getMyElement("selectCountryinWindow")).click().sendKeys(countryName).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.getMyElement("selectCountryinWindow")));
        scrollClick.perform();
        sk.findAndSend("nameInput", stateName);
        dc.findAndClick("saveButton");
    }


    @When("Edit from State name as {string} and create a new country name as {string} code as {string} without state")
    public void createANewCountryWithoutStateFromEditStateWindow(String stateName, String countryName, String code) {
        sk.findAndSend("searchNameInput", stateName);
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput", countryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("countrySaveButton");

    }

    @Then("The created Country not found and the state was not successfully updated")
    public void theCreatedCountryNotFoundAndTheStateWasNotSuccessfullyUpdated() {

        Action scrollClick = actions.moveToElement(sk.getMyElement("selectCountryinWindow")).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.getMyElement("selectCountryinWindow")));
        scrollClick.perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Kazak Yeli".toLowerCase()));

    }
}
