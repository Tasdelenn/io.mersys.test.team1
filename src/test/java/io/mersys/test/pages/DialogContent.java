package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogContent extends BaseFunctions {

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

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

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//ms-delete-button/button/span")
    private List<WebElement> deleteButton2;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;
    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']//span")
    private WebElement active;
    //    @FindBy(xpath = "(//mat-slide-toggle[@formcontrolname='active']/label/span)[1]")
//    private WebElement active;
    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//mat-form-field[@appearance='outline']//textarea")
    private WebElement description;

    @FindBy(css = "input[data-placeholder='Order']")
    private WebElement order;

    @FindBy(xpath = "//ms-edit-button//button[@color='accent']")
    private WebElement editButton;

    @FindBy(xpath = "//ms-edit-button/button")
    private WebElement editButton2;

    //@FindBy(css = "ms-edit-button[class='ng-star-inserted'] button") /** locator de??i??mi?? */
    @FindBy(css = "ms-edit-button[class^='ng-']")
    private List<WebElement> editButton3;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='description']//input")
    private WebElement description1;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeintegration;

    @FindBy(xpath = "//div[contains(text(),'There is no data to display')]")
    private WebElement noDataMessage;

    @FindBy(css = "mat-select[role='combobox'][formcontrolname='id']")
    private WebElement countryNameInput0;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {  // 2.a??ama
        // burda string isimden weblemente ula????cam
        switch (strElement) {
            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":
                myElement = nameInput;
                break;
            case "codeInput":
                myElement = codeInput;
                break;
            case "shortName":
                myElement = shortName;
                break;
            case "searchInput":
                myElement = searchInput;
                break;
            case "integrationCode":
                myElement = integrationCode;
                break;
            case "priorityCode":
                myElement = priorityCode;
                break;
            case "description":
                myElement = description;
                break;
            case "order":
                myElement = order;
                break;
            case "description1":
                myElement = description1;
                break;
            case "codeintegration":
                myElement = codeintegration;
                break;
            case "countryNameInput0":
                myElement = countryNameInput0;
                break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {  // 2.a??ama
        // burda string isimden weblemente ula????cam
        switch (strElement) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "closeDialog":
                myElement = closeDialog;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "deleteButton2":
                BaseDriver.getWait().until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), deleteButton2.size()));
                myElement = deleteButton2.get(0);
                break;
            case "deleteDialogBtn":
                myElement = deleteDialogBtn;
                break;
            case "acceptCookies":
                myElement = acceptCookies;
                break;
            case "editButton":
                myElement = editButton;
                break;
            case "editButton2":
                myElement = editButton2;
                break;
            case "editButton3":
                BaseDriver.getWait().until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("ms-edit-button[class^='ng-']"), editButton3.size()));
                myElement = editButton3.get(0);
                break;
            case "active":
                myElement = active;
                break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {  // 2.a??ama
        // burda string isimden weblemente ula????cam
        switch (strElement) {
            case "dashboard":
                myElement = dashboard;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
            case "alreadyExist":
                myElement = alreadyExist;
                break;
            case "noDataMessage":
                myElement = noDataMessage;
                break;
            case "loginButton":
                myElement = loginButton;
                break;

        }

        verifyContainsText(myElement, text);
    }


    public void SearchAndDelete(String searchText) {

        //scrollUp()
        findAndSend("searchInput", searchText); // aranacak kelimeyi kutucu??a g??nder
        findAndClick("searchButton"); // arama butonuna bas

        //waitUntilLoading();

        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"), "Search"));


        findAndClick("deleteButton");// silme butonua bas
        findAndClick("deleteDialogBtn");// dilogdaki silme butonuna bas
    }


}
