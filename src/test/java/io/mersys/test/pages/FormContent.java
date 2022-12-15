package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends BaseFunctions{

    public FormContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//mat-slide-toggle[@formcontrolname='required']//span)[3]")
    private WebElement switchRequired;

    @FindBy(xpath = "(//mat-slide-toggle[@formcontrolname='useCamera']//span)[3]")
    private WebElement switchUseCamera;

    WebElement myElement;

    public void findAndClick(String strElement){

        switch (strElement)
        {
            case "switchRequired" : myElement=switchRequired; break;
            case "switchUseCamera" : myElement=switchUseCamera; break;
        }

        clickFunction(myElement);
    }
}

