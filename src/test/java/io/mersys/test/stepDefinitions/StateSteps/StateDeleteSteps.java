package io.mersys.test.stepDefinitions.StateSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.pages.StatesContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class StateDeleteSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    StatesContent sk= new StatesContent();
    Actions actions=new Actions(BaseDriver.getDriver());
    @When("Delete new State from existing Country")
    public void deleteNewStateFromExistingCountry() {
        sk.findAndSend("searchNameInput","Melek Sehri");
        sk.findAndClick("searchButton");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @When("Select new created Country and new Created State delete them")
    public void selectNewCreatedCountryAndNewCreatedStateDeleteThem() {
        sk.findAndClick("selectCountryinSrearch");
        actions.moveToElement(sk.selectCountryinSrearch).sendKeys("Atlant").click().build().perform();
        sk.findAndSend("searchNameInput","Almaty1");
        sk.findAndClick("searchButton");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @When("The Country in the dropdown menu does not have State")
    public void theCountryInTheDropdownMenuDoesNotHaveState() {
        sk.findAndClick("selectCountryinSrearch");
        actions.moveToElement(sk.selectCountryinSrearch).sendKeys("Atlant").click().build().perform();
        //dc.findAndContainsText("noData"," There is no data to display ");
        actions.dragAndDropBy(sk.dropdown, 0,0).build().perform();

    }

    @And("Find and delete the Country")
    public void findAndDeleteTheCountry() {
        sk.findAndSend("searchNameInput","Atlant");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");

    }

    @And("Click on dropdown menu and the Country should not be visible")
    public void clickOnDropdownMenuAndTheCountryShouldNotBeVisible() {
        actions.moveToElement(sk.selectCountryinWindow).click().build().perform();
        for (WebElement e : sk.countryNameList)
            Assert.assertFalse(e.getText().toLowerCase().contains("Atlant".toLowerCase()));

    }
}
