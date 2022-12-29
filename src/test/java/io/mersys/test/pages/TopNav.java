package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNav extends BaseFunctions{

    public TopNav() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'T. TechnoStudy')]")
    private WebElement accountButton;
    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    private WebElement signOutButton;

    @FindBy(xpath = "//span[contains(text(),'GİRİŞ YAP')]")
    private WebElement logInButton;

    WebElement myElement;
    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "accountButton": myElement = accountButton; break;
            case "signOutButton": myElement = signOutButton; break;
            case "logInButton": myElement = logInButton; break;

        }

        clickFunction(myElement);
    }
}
