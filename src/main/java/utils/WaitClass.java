package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.log4j.Logger.getLogger;

public class WaitClass {
    private WebDriverWait webDriverWait;
    private Logger logger = getLogger(WaitClass.class);

    private final WebDriver driver;
    public WaitClass(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 6);
    }

    public boolean waitForElement(By locatorKey, int seconds) {
        boolean result = false;
        try {
            webDriverWait
                    .withTimeout(Duration.ofSeconds(seconds))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(locatorKey));
            result = true;

        } catch (Exception e){
            //add this in logs
            logger.info("||||| : Element with Locator-Key: "+locatorKey+" is not Present!");
            return result;
        }
        if(!result){
            throw new AssertionError("The By element ("+locatorKey+") was not located");
        }
        return true;
    }
}
