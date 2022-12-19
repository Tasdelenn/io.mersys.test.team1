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
import org.testng.Assert;

public class StateCreateSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    Faker fakeData = new Faker();
    StatesContent sk= new StatesContent();
    Actions actions=new Actions(BaseDriver.getDriver());
    @And("Navigate to State page")
    public void navigateToStatePage() {
        ln.findAndClick("setupOne"); // Setup Click
        ln.findAndClick("parameters"); // Parameters Click
        ln.findAndClick("states"); // Countries Click

    }

    @When("Create a new State from existing Country")
    public void createANewStateFromExistingCountry() {
        dc.findAndClick("addButton");
        actions.moveToElement(sk.selectCountryinWindow).click().sendKeys("Australia").click().build().perform();
        sk.findAndSend("nameInput","melek sehir");
        dc.findAndSend("shortName","mk");
        dc.findAndClick("saveButton");


    }


    @When("Create a new country from New State window")
    public void createANewCountryFromNewStateWindow() {
        dc.findAndClick("addButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput","Kazakyeli");
        dc.findAndSend("codeInput", "KY");
        sk.findAndClick("stateExists");
        sk.findAndClick("countrySaveButton");

    }

    @And("Create a new State")
    public void createANewState() {
        actions.moveToElement(sk.selectCountryinWindow).click().sendKeys("Kazakyeli").click().build().perform();
        sk.findAndSend("nameInput","Almaty");
        dc.findAndSend("shortName","AL");
        dc.findAndClick("saveButton");
    }

    @When("Create a new country without state from New State window")
    public void createANewCountryWithoutStateFromNewStateWindow() {
        dc.findAndClick("addButton");
        sk.findAndClick("addCountry");
        sk.findAndSend("countryNameInput","Jana Khazak");
        dc.findAndSend("codeInput", "JK");
        sk.findAndClick("countrySaveButton");
    }

    @Then("The created Country not found and new state was not successfully created")
    public void theCreatedCountryNotFoundAndNewStateWasNotSuccessfullyCreated() {
        actions.moveToElement(sk.selectCountryinWindow).click().build().perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Jana Kazak".toLowerCase()));
    }
}
