package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends BaseFunctions{

    public LeftNav() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement countries;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenShip;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;

    @FindBy(xpath = "(//span[text()='States'])")
    private WebElement states;

    @FindBy(xpath="(//span[contains(text(),'Document Types')])[1]")
    private WebElement documentTypes;

    @FindBy(xpath="//span[text()='Grade Levels']")
    private WebElement gradeLevels;

    @FindBy(xpath="//span[text()='Cities']")
    private WebElement cities;

    @FindBy(xpath = "(//span[text()='Discounts'])")
    private WebElement discounts;



    WebElement myElement;

    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "setupOne": myElement = setupOne; break;
            case "parameters": myElement = parameters; break;
            case "countries": myElement = countries; break;
            case "citizenShip": myElement = citizenShip; break;
            case "nationalities": myElement = nationalities; break;
            case "fees": myElement = fees; break;
            case "entranceExamsOne": myElement = entranceExamsOne; break;
            case "setupTwo": myElement = setupTwo; break;
            case "entranceExamsTwo": myElement = entranceExamsTwo; break;
            case "states": myElement = states; break;
            case "documentTypes": myElement = documentTypes; break;
            case "gradeLevels": myElement = gradeLevels; break;
            case "discounts": myElement = discounts; break;
            case "cities": myElement=cities;break;

        }

        clickFunction(myElement);
    }
}
