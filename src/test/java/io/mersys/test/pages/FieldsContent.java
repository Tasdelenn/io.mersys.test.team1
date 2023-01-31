package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FieldsContent extends BaseFunctions{
    public FieldsContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@matbadgecolor='accent']")
    private WebElement addFields;

    @FindBy(xpath = "//ms-add-button")
    private WebElement addFields2;



    @FindBy(xpath = "(//mat-select[@role='combobox']/div)[2]")
    private WebElement fieldType;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement Number;




    @FindBy(xpath = "//div[contains(text(),'Could not delete')]")
    private WebElement notDeleteMessage;
    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "fieldType": myElement = fieldType; break;
            case "addFields": myElement = addFields; break;
            case "addFields2": myElement = addFields2; break;
            case "Number": myElement = Number; break;

        }

        clickFunction(myElement);
    }



}
