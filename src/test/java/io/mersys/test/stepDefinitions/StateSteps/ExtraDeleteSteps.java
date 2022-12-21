package io.mersys.test.stepDefinitions.StateSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.pages.StatesContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExtraDeleteSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    StatesContent sk = new StatesContent();
    Actions actions = new Actions(BaseDriver.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));

    @Then("Navigate to country page and delete the Country name as{string}")
    public void navigateToCountryPageAndDeleteTheCountryNameAs(String Country) {
        actions.dragAndDropBy(sk.scroll, 0, -200).build().perform();
        ln.findAndClick("countries");
        BaseDriver.Bekle(2);
        dc.findAndSend("searchInput", Country);
        dc.findAndClick("searchButton");
        BaseDriver.Bekle(2);
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @And("User Should not be able to delete successfully")
    public void userShouldNotBeAbleToDeleteSuccessfully() {

        dc.findAndContainsText("notDeleteMessage", "Could not delete");
    }

    @And("Navigate to Cities page and create a new City named {string} frome Country {string} State {string}")
    public void navigateToCitiesPageAndCreateANewCityNamedStringFromeCountryStringStateString(String cityName, String countryName, String stateName) {
        actions.dragAndDropBy(sk.scroll, 0, -200).build().perform();
        ln.findAndClick("cities");
        BaseDriver.Bekle(2);
        dc.findAndClick("addButton");
        Action scrollClick = actions.moveToElement(sk.selectCountryinWindow).click().sendKeys(countryName).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.selectCountryinWindow));
        scrollClick.perform();
        Action scrollClick2 = actions.moveToElement(sk.selectStateWindow).click().sendKeys(stateName).click().build();
        wait.until(ExpectedConditions.visibilityOf(sk.selectStateWindow));
        scrollClick2.perform();
        dc.findAndSend("nameInput",cityName);
        dc.findAndClick("saveButton");

    }

    @And("Navigate to State page and delete the state {string}")
    public void navigateToStatePageAndDeleteTheStateSting(String stateName) {
        actions.dragAndDropBy(sk.scroll, 0, -200).build().perform();
        ln.findAndClick("states");
        BaseDriver.Bekle(2);
        sk.findAndSend("searchNameInput",stateName);
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }
}
