package io.mersys.test.stepDefinitions;

import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;

import java.util.List;


public class GradeLevelsSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    String randomName = RandomStringUtils.randomAlphabetic(8);
    String istenenName = randomName;
    String randomShortName = RandomStringUtils.randomAlphabetic(4);
    String randomCode = RandomStringUtils.randomNumeric(2);
    String randomNewName = RandomStringUtils.randomAlphabetic(8);
    String istenenNewName = randomNewName;
    String randomNewCode = RandomStringUtils.randomNumeric(2);
    Actions actions = new Actions(BaseDriver.getDriver());


    @Then("user add Grade Levels")
    public void userAddGradeLevels() {
        BaseDriver.Bekle(2);
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", istenenName);
        dc.findAndSend("shortName", randomShortName);
        dc.findAndSend("order", randomCode);
        dc.findAndClick("active");
        dc.findAndClick("saveButton");
    }

    @Then("user edit Grade Levels")
    public void userEditGradeLevels() {


        List<WebElement> listeNames = BaseDriver.getDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"));



        for (WebElement we : listeNames)

        {
            System.out.println(we.getText());
        }

        System.out.println( listeNames.toString());


        for (WebElement e : listeNames)
            if ((e.getText()).contains(istenenName)) {
                actions.moveToElement(e).click().build().perform();

                dc.findAndSend("name", istenenNewName);
                dc.findAndSend("shortName", "rand45");
                dc.findAndSend("order", randomNewCode);
                dc.findAndClick("active");
                dc.findAndClick("saveButton");
            }
    }

    @Then("user delete Grade Levels")
    public void userDeleteGradeLevels() {
        List<WebElement> listNewNames = BaseDriver.getDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"));


        for (WebElement e : listNewNames) {
            if ((e.getText()).contains(istenenNewName)) {
                List<WebElement> listDelete = BaseDriver.getDriver().findElements(By.xpath("//ms-delete-button/button"));
                for (int i = 0; i < listDelete.size(); i++) {
                    WebElement istenenDelet = listDelete.get(listNewNames.indexOf(e));
                    actions.moveToElement(istenenDelet).click().build().perform();
                    actions.moveToElement(e.findElement(By.xpath("//span[contains(text(),'Delete')]"))).click().build().perform();
                    break;
                }
            }
        }
    }

    @And("user should see successfully message")
    public void userShouldSeeSuccessfullyMessage() {
        dc.findAndContainsText("successMessage", "successfully");
    }


}




