package io.mersys.test.pages;

import com.github.javafaker.Faker;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class DialogContent extends BaseFunctions{

    Faker faker = new Faker(new Locale("en-US"));
    String yazar = faker.book().author();

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "[id^=mat-error-]")
    private WebElement requireUnamePass;

    @FindBy(xpath = "//h1[text()='Reset your password']")
    private WebElement resetPasswordHeader;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement resetPasswordBtn;

    @FindBy(css = "a.forgot-password")
    private WebElement resetPasswordLink;

    @FindBy(xpath = "//div[contains(text(),'Invalid username or password')]")
    private WebElement invalidUnamePass;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//mat-form-field[@appearance='outline']//textarea")
    private WebElement description;

    WebElement myElement;

    public void findAndSend(String strElement, String value) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "username": myElement = username; break;
            case "password": myElement = password; break;
            case "nameInput": myElement = nameInput; break;
            case "codeInput": myElement = codeInput; break;
            case "shortName": myElement = shortName; break;
            case "searchInput": myElement = searchInput; break;
            case "integrationCode": myElement = integrationCode; break;
            case "priorityCode": myElement = priorityCode; break;
            case "description": myElement = description; break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "loginButton": myElement = loginButton; break;
            case "addButton": myElement = addButton; break;
            case "saveButton": myElement = saveButton; break;
            case "closeDialog": myElement = closeDialog; break;
            case "searchButton": myElement = searchButton; break;
            case "deleteButton": myElement = deleteButton; break;
            case "deleteDialogBtn": myElement = deleteDialogBtn; break;
            case "acceptCookies": myElement = acceptCookies; break;
            case "resetPasswordBtn": myElement = resetPasswordBtn; break;
            case "resetPasswordLink": myElement = resetPasswordLink; break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "dashboard": myElement = dashboard; break;
            case "successMessage": myElement = successMessage; break;
            case "alreadyExist": myElement = alreadyExist; break;
            case "requiredUsernameAndPassword": myElement = requireUnamePass; break;
            case "resetPasswordHeader": myElement = resetPasswordHeader; break;
            case "invalidUsernameAndPassword": myElement = invalidUnamePass; break;

        }

        verifyContainsText(myElement, text);
    }


    public void SearchAndDelete(String searchText) {

        //scrollUp()
        findAndSend("searchInput", searchText); // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //waitUntilLoading();

        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"), "Search"));


        findAndClick("deleteButton");// silme butonua bas
        findAndClick("deleteDialogBtn");// dilogdaki silme butonuna bas
    }


}
