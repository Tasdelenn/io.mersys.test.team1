package io.mersys.test.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainSteps {

    DialogContent dc = new DialogContent();

    @And("click Anywhere")
    public void clickAnywhere() {
        Actions actions = new Actions(BaseDriver.getDriver());
        actions.click().build().perform();
    }
    @When("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            dc.findAndClick(listElements.get(i));
        }
    }

    @When("User delete the edited item")
    public void userDeleteTheEditedItem() {
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @And("The user search and delete the item from Dialog PAge")
    public void theUserSearchAndDeleteTheItemFromDialogPage(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        for(int i=0;i<listElement.size();i++) {
            //   System.out.println("listElement = " + listElement.get(i));
            dc.SearchAndDelete(listElement.get(i));
        }
    }

    @Then("Already Exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed()  {
        dc.findAndContainsText("alreadyExist","already exist");
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'successfully')]")));
    }

}
