package io.mersys.test.stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.FieldsContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FieldsSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    FieldsContent fic=new FieldsContent();
    Faker faker = new Faker();
    Actions actions = new Actions(BaseDriver.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));

        @And("Navigate to fields page")
            public void navigateToFeesPage() {
                ln.findAndClick("setupOne");
                ln.findAndClick("parameters");
                ln.findAndClick("fields");
            }

    @Then("User add a new field")
    public void userAddANewField() {
        fic.findAndClick("addFields2");
        dc.findAndSend("nameInput", "Alan121");
        dc.findAndSend("codeInput", "A12");
        fic.findAndClick("fieldType");
        fic.findAndClick("Number");
        dc.findAndClick("saveButton");
    }

    @Then("User edit field")
    public void userEditField() {
        dc.findAndSend("searchInput", "Alan121");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton3");
        dc.findAndSend("nameInput", "Bölge45");
        dc.findAndSend("codeInput", "B45");
        dc.findAndClick("saveButton");
    }

    @Then("User delete field")
    public void userDeleteField() {
        dc.findAndSend("searchInput", "Bölge45");
        dc.findAndClick("searchButton");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");

    }

    @Then("User add a exist field name")
    public void userAddAExistFieldName() {
        fic.findAndClick("addFields2");
        dc.findAndSend("nameInput", "Alan121");
        dc.findAndSend("codeInput", "A12");
        dc.findAndClick("saveButton");
    }

    @Then("The user search and delete an unavaible field")
    public void theUserSearchAndDeleteAnUnavaibleField() {
        dc.findAndSend("searchInput", "Field1001");
        dc.findAndClick("searchButton");
    }
}

