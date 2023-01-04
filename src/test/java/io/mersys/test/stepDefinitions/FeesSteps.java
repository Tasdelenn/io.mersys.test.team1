package io.mersys.test.stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.pages.LeftNav;
import io.mersys.test.utilities.BaseDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeesSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    Faker faker = new Faker();
    Actions actions = new Actions(BaseDriver.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(),Duration.ofSeconds(30));

    @And("Navigate to fees page")
    public void navigateToFeesPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("fees");
    }

    @Then("User add a new fee")
    public void userSendingTheKeysInDialogContent() {
        String randomName = faker.finance().bic();
        String randomCode = faker.random().hex(5);
        String randomIntCode = faker.random().hex();
        String randomPriority = faker.random().hex(2);

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "Document8");
        dc.findAndSend("codeInput", "Doc8");
        dc.findAndSend("integrationCode", "dc88");
        dc.findAndSend("priorityCode", "8");
        dc.findAndClick("active");
        dc.findAndClick("saveButton");
    }

    @Then("User edit fee")
    public void userEditFee() {
        dc.findAndSend("searchInput", "Document8");
        dc.findAndClick("searchButton");
        dc.findAndClick("editButton3");
        dc.findAndSend("nameInput", "Document45");
        dc.findAndSend("codeInput", "Doc45");
        dc.findAndSend("integrationCode", "dc45");
        dc.findAndSend("priorityCode", "4");
        dc.findAndClick("active");
        dc.findAndClick("saveButton");
    }

    @Then("User delete fee")
    public void userDeleteFee() {
        dc.findAndSend("searchInput", "Document45");
        dc.findAndClick("searchButton");
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteDialogBtn");
    }

    @Then("User add a exist fee name")
    public void userAddAExistFeeName() {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "Document8");
        dc.findAndSend("codeInput", "Doc8");
        dc.findAndSend("integrationCode", "dc88");
        dc.findAndSend("priorityCode", "8");
        dc.findAndClick("active");
        dc.findAndClick("saveButton");
    }

    @Then("The user search and delete an unavaible fee")
    public void theUserSearchAndDeleteAnUnavaibleFee() {
        dc.findAndSend("searchInput", "School Fee");
        dc.findAndClick("searchButton");
    }

    @And("The user search and delete the item from Dialog Page {string}")
    public void theUserSearchAndDeleteTheItemFromDialogPage(String searchInput) {
        dc.SearchAndDelete(searchInput);

    }
}