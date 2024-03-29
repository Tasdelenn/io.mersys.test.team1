package io.mersys.test.pages;

import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class BaseFunctions {

    public void sendKeysFunction(WebElement element, String value) {//3.Aşama
        waitUntilVisible(element); // gözükene kadar bekle
        scrollToElement(element); // elemente scroll yap
        element.clear();   // temizle
        element.sendKeys(value); // değeri gönder
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollTop() {

        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("window.scrollTo(0,0)");
        //js.executeScript("document.documentElement.scrollTop = 0;");  //Alternatif Kod

    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element); // tıklanabilir olana kadar bekle
        scrollToElement(element); // elemente scroll yap
        element.click(); // click yap
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsText(WebElement element, String text) {
        waitUntilVisible(element); // gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void waitUntilLoading() {
        WebDriverWait wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public void ActionFunction(WebElement element){
        waitUntilClickable(element);
        waitUntilVisible(element);
        Actions actions= new Actions(BaseDriver.getDriver());
        Action action=actions.moveToElement(element).click().build();
        action.perform();
    }
}
