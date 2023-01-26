package io.mersys.test.stepDefinitions;

import io.cucumber.java.en.And;
import io.mersys.test.pages.BaseFunctions;
import io.mersys.test.pages.DialogContent;
import io.mersys.test.utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClassesSteps extends BaseDriver {

    DialogContent dc = new DialogContent();

    @And("Make maximum the number of the element \\(size) in the page")
    public void makeMaximumTheNumberOfTheElementSizeInThePage() {

        dc.findAndClick("sizeButton");
        dc.findAndClick("sizeMaxValue");

    }

    @And("Sort elements by created time")
    public void sortElementsByCreatedTime() {

        dc.findAndClick("sortHeaderByDate");
        dc.findAndClick("sortHeaderByDate");
        dc.scrollTop();

    }

    @And("Find the just added item in to the page without search")
    public void findTheJustAddedItemInToThePageWithoutSearch() {

        List<String> list = new ArrayList<>();

        int i=0;
        for (WebElement e: dc.rows) {
            dc.scrollToElement(e);
            list.add(e.getText());
            System.out.println((i+1) + ". " + list.get(i));
            i++;
        }
    }

    private By getByFromElement(WebElement element) {

        By by = null;
        String[] selectorWithValue = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

        String selector = selectorWithValue[0].trim();
        String value = selectorWithValue[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }

    @And("Click top edit button")
    public void clickTopEditButton() {

        Bekle(2);
        dc.findAndClick("firstEditButton");

    }
}