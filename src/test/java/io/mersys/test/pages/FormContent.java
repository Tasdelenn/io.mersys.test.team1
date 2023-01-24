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

    @FindBy(xpath = "//span[text()=' Turkey ']")
    private WebElement Turkey;

    @FindBy(xpath = "//mat-select[@formcontrolname='id']/div")
    private WebElement countryBlog;

    @FindBy(xpath = "//div[contains(@class,'mat-form-field-infix ng-tns-c77')]/mat-select")
    private WebElement countryBlogSearchForm;

    @FindBy(xpath = "//mat-select[@formcontrolname='type']/div")
    private WebElement locationType;

    @FindBy(xpath = "//span[text()=' Laboratory ']")
    private WebElement selectLaboratory;

    @FindBy(xpath = "//mat-select[@id='mat-select-12']")
    private WebElement gradeLevel;

    @FindBy(xpath = "//span[text()=' Middle Level 101 ']")
    private WebElement selectGradeLevel;

    @FindBy(xpath = "//mat-select[@id='mat-select-14']")
    private WebElement classTeacher;

    @FindBy(xpath = "//span[text()=' Mehmet Ali Yeşil ']")
    private WebElement selectTeacher;

    @FindBy(xpath = "//mat-select[@id='mat-select-16']")
    private WebElement schoolLocation;

    @FindBy(xpath = "//span[text()=' South Campus ']")
    private WebElement selectSchoolLocation;

    @FindBy(xpath = "//mat-select[@id='mat-select-10']")
    private WebElement schoolDepartment;

    @FindBy(xpath = "//span[text()=' Teaching And Learning ']")
    private WebElement selectSchoolDepartment;

    //mat-select[@id='mat-select-18']
    @FindBy(xpath = "//mat-select[@id='mat-select-18']")
    private WebElement schoolSection;

    @FindBy(xpath = "//span[text()=' C LAB - Computer Laboratory ']")
    private WebElement selectSchoolSection;



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
            case "Turkey" : myElement=Turkey; break;
            case "selectLaboratory" : myElement=selectLaboratory; break;
            case "gradeLevel" : myElement=gradeLevel; break;
            case "selectGradeLevel" : myElement=selectGradeLevel; break;
            case "classTeacher" : myElement=classTeacher; break;
            case "selectTeacher" : myElement=selectTeacher; break;
            case "schoolLocation" : myElement=schoolLocation; break;
            case "selectSchoolLocation" : myElement=selectSchoolLocation; break;
            case "schoolDepartment" : myElement=schoolDepartment; break;
            case "selectSchoolDepartment" : myElement=selectSchoolDepartment; break;
            case "schoolSection" : myElement=schoolSection; break;
            case "selectSchoolSection" : myElement=selectSchoolSection; break;
        }

        clickFunction(myElement);
    }

    public void findAndAction(String strElement){

        switch (strElement)
        {
            case "countryBlog" : myElement=countryBlog; break;
            case "countryBlogSearchForm" : myElement=countryBlogSearchForm; break;
            case "locationType" : myElement=locationType; break;
            case "gradeLevel" : myElement=gradeLevel; break;
            case "selectGradeLevel" : myElement=selectGradeLevel; break;
        }

        ActionFunction(myElement);
    }
}

