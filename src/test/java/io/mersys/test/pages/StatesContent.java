package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatesContent extends BaseFunctions{
    public StatesContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix')])[1]//mat-select")
    private WebElement selectCountryinSrearch;

    @FindBy(xpath = "//mat-select[@formcontrolname='id']//div[2]")
    private WebElement selectCountryinWindow;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']//div[2])[2]")
    private WebElement selectStateWindow;
    @FindBy(xpath="//ms-text-field//input")
    private WebElement searchNameInput;

    @FindBy(css = "div[class='ps__thumb-y']")
    private WebElement scroll;
    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'COUNTRY.TITLE.ADD')]//button")
    private WebElement addCountry;

    @FindBy(xpath = "(//ms-text-field[@placeholder='GENERAL.FIELD.NAME']/input)[3]")
    private WebElement countryNameInput;
    @FindBy(css = "span[class='mat-slide-toggle-thumb']")
    private WebElement stateExists;

    @FindBy(xpath = "(//ms-save-button)[2]")
    private WebElement countrySaveButton;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "(//div[contains(@id,'cdk-overlay')])[2]//span")
    public List<WebElement> countryNameList;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> countryStateList;

    @FindBy(xpath = "//tbody/tr/td/div")
    private WebElement noData;

    @FindBy(xpath = "//div[contains(text(),'Could not delete')]")
    private WebElement notDeleteMessage;
    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "selectCountry": myElement = selectCountryinWindow; break;
            case "addCountry": myElement = addCountry; break;
            case "stateExists": myElement = stateExists; break;
            case "countrySaveButton": myElement = countrySaveButton; break;
            case "selectCountryinSrearch": myElement = selectCountryinSrearch; break;
        }

        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value){
        switch (strElement)
        {
            case "nameInput" : myElement =nameInput; break;
            case "searchInput" : myElement =searchInput; break;
            case "countryNameInput": myElement = countryNameInput; break;
            case "searchNameInput" : myElement = searchNameInput; break;

        }

        sendKeysFunction(myElement, value);
    }
    public void findAndContainsText(String strElement, String text) {
        switch (strElement) {
            case "noData": myElement = noData; break;
            case "notDeleteMessage": myElement=notDeleteMessage;break;
        }

        verifyContainsText(myElement, text);
    }

    public WebElement getMyElement(String strElement) {
        switch (strElement){
            case "selectCountryinSrearch":myElement=selectCountryinSrearch;break;
            case "selectCountryinWindow":myElement=selectCountryinWindow;break;
            case "selectStateWindow":myElement=selectStateWindow;break;
            case "scroll":myElement=scroll;break;


        }
        return myElement;
    }

}
