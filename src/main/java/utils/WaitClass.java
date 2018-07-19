package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitClass {
    WebDriverWait webDriverWait;

    private final WebDriver driver;
    public WaitClass(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 6);
    }

    public void waitForVisibility(By element) {
        waitForVisibility(element, 20);
    }
    public void waitForVisibility(By element, int sec) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(this.driver, sec);
        webDriverWait.until(visibilityOfElementLocated(element));
    }

    public void waitForClickability(By element) {
        waitForClickability(element, 20);
    }
    public void waitForClickability(By element, int sec) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(this.driver, sec);
        webDriverWait.until(elementToBeClickable(element));
    }

    public boolean waitForElement(By locatorKey, int repeats) {
        boolean result = false;
        try {
            webDriverWait
                    .withTimeout(repeats, TimeUnit.SECONDS)
                    .pollingEvery(100, TimeUnit.MICROSECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(locatorKey));
            result = true;

        } catch (Exception e){
            //add this in logs
            System.out.println("Element with Locator-Key: "+locatorKey+" is not Present!");
        };
        return result;
    }

    public void waitUntilElementsEnd(By by) {
        boolean waiting = true;
        while (waiting) {
            if (!waitForElement(by, 1)) //if (!wait.isElementDisplayed(By.cssSelector("#messageBox button[class*='disabled']")))
                waiting = false;
        }
    }
    // used to escape Thread.sleep() - wait until a expected css element will be displayed on the page
    public void waitUntilElementIsDisplayed(By element) {
        webDriverWait
                .withTimeout(6, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
