package io.mersys.test.stepDefinitions.StateSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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

public class StateCreateSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    Faker fakeData = new Faker();
    StatesContent sk = new StatesContent();
    Actions actions = new Actions(BaseDriver.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));

    @And("Navigate to State page")
    public void navigateToStatePage() {
        ln.findAndClick("setupOne"); // Setup Click
        ln.findAndClick("parameters"); // Parameters Click
        ln.findAndClick("states"); // Countries Click

    }

    @When("Create a new State name as {string} short name as {string} from existing Country {string}")
    public void createANewStateNameAsShortNameAsFromExistingCountry(String StatName, String shortName, String countryName) {

        dc.findAndClick("addButton");
        Action scrollClick = actions.moveToElement(sk.selectCountryinWindow).click().sendKeys(countryName).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.selectCountryinWindow));
        scrollClick.perform();
        sk.findAndSend("nameInput", StatName);
        dc.findAndSend("shortName", shortName);
        dc.findAndClick("saveButton");


    }


    @When("Create a new country name as {string} code as {string} from New State window")
    public void createANewCountryNameAsCodeAsFromNewStateWindow(String CountryName, String code) {
        dc.findAndClick("addButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput", CountryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("stateExists");
        sk.findAndClick("countrySaveButton");

    }

    @And("Create a new State name as{string} short name as{string} from {string}")
    public void createANewStateNameAsShortNameAs(String stateName, String shortName, String countryName) {
        Action scrollClick = actions.moveToElement(sk.selectCountryinWindow).click().sendKeys(countryName).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.selectCountryinWindow));
        scrollClick.perform();
        sk.findAndSend("nameInput", stateName);
        dc.findAndSend("shortName", shortName);
        dc.findAndClick("saveButton");
    }

    @When("Create a new country name as {string} code {string} without state from New State window")
    public void createANewCountryWithoutStateFromNewStateWindow(String countryName, String code) {
        dc.findAndClick("addButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput", countryName);
        dc.findAndSend("codeInput", code);
        sk.findAndClick("countrySaveButton");
    }

    @Then("The created Country not found and new state was not successfully created")
    public void theCreatedCountryNotFoundAndNewStateWasNotSuccessfullyCreated() {
        Action scrollClick = actions.moveToElement(sk.selectCountryinWindow).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.selectCountryinWindow));
        scrollClick.perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Jana Kazak".toLowerCase()));
    }
}
