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

    @FindBy(xpath = "//mat-select[@formcontrolname='attachmentStages']/div")
    private WebElement stageSelect;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement selectStudentRegistration;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[4]")
    private WebElement selectCertificate;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[3]")
    private WebElement selectEmployment;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[5]")
    private WebElement selectContract;

    WebElement myElement;

    public void findAndClick(String strElement){

        switch (strElement)
        {
            case "switchRequired" : myElement=switchRequired; break;
            case "switchUseCamera" : myElement=switchUseCamera; break;
            case "stageSelect" : myElement=stageSelect; break;
            case "selectStudentRegistration" : myElement=selectStudentRegistration; break;
            case "selectCertificate" : myElement=selectCertificate; break;
            case "selectEmployment" : myElement=selectEmployment; break;
            case "selectContract" : myElement=selectContract; break;
        }

        clickFunction(myElement);
    }
}

