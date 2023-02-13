package io.mersys.test.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.StatesContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DepartmentsStep {
    DialogContent dc = new DialogContent();
    String istenenName = "Physics-Math";
    String istenenNewName="Technology";
    Actions actions = new Actions(BaseDriver.getDriver());

    @And("User update the Department name as {string} code as {string}")
    public void userUpdateTheDepartmentNameAsCodeAs(String name, String code)  {
        waitUntilElementListed(istenenName);
        BaseDriver.Bekle(3);
        List<WebElement> listeNames = BaseDriver.getDriver().findElements(By.xpath("//tbody/tr"));

        for (WebElement e : listeNames)
            if ((e.getText()).contains(istenenName)) {
                System.out.println("e.getText() = " + e.getText());
                actions.moveToElement(e).click().build().perform();
                dc.findAndSend("nameInput", name);
                dc.findAndSend("codeInput", code);
                dc.findAndClick("saveButton");
            }
    }

    @And("User find and delete the Department")
    public void userFindAndDeleteTheDepartmentNameAs() {
        waitUntilElementListed(istenenNewName);
        BaseDriver.Bekle(3);
        List<WebElement> listNewNames = BaseDriver.getDriver().findElements(By.xpath("//tbody/tr"));
        for (WebElement e : listNewNames) {
            if ((e.getText()).contains(istenenNewName)) {
                List<WebElement> listDelete = BaseDriver.getDriver().findElements(By.xpath("//ms-delete-button/button"));
                for (int i = 0; i < listDelete.size(); i++) {
                    WebElement istenenDelet = listDelete.get(listNewNames.indexOf(e));
                    actions.moveToElement(istenenDelet).click().build().perform();
                    dc.findAndClick("deleteDialogBtn");
                    break;
                }
            }
        }
    }

            private void waitUntilElementListed (String name){
                WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath("//tbody//td[2][text()='" + name + "']"), 0));
            }


        }
