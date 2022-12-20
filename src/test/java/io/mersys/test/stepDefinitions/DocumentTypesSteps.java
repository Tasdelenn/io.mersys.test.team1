package io.mersys.test.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.FormContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DocumentTypesSteps {

    LeftNav ln=new LeftNav();

    DialogContent dc=new DialogContent();

    FormContent fc=new FormContent();

    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {
        List<String> listElement=elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++)
            ln.findAndClick(listElement.get(i));
    }

    @And("Click on the element in the Dialog content")
    public void clickOnTheElementInTheDialogContent(DataTable elements) {
        List<String> listElement=elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++)
            dc.findAndClick(listElement.get(i));
    }

    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
    }

    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {
        List<String> listElement=elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            fc.findAndClick(listElement.get(i));
        }
    }

    @And("Click the TAB key")
    public void clickTheEscKey() {
        Actions aksiyonlar = new Actions(BaseDriver.getDriver());
        aksiyonlar.click().keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            dc.SearchAndDelete(listElement.get(i));
        }
    }

    @Then("Verify that there is no data to display")
    public void verifyThatThereIsNoDataToDisplay() {
        dc.findAndContainsText("noDataMessage", "There is no data to display");
    }
}
