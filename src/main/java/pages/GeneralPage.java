package pages;

import enums.Page;
import enums.Url;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitClass;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralPage {
    protected final WebDriver driver;
    WebDriverWait webDriverWait;
    WaitClass wait;
    Logger logger = Logger.getLogger(GeneralPage.class);

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 6);
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(By by, int timeoutSeconds){
        timeoutSeconds = timeoutSeconds != 0 ? timeoutSeconds : 3;
        for (int second = 0; second < timeoutSeconds; second++){
            try {
                driver.findElement(by);
            } catch (NoSuchElementException e){
                continue;
            }
            return true;
        }
        return false;
    }


    public boolean isRightPageOpened(Page page) throws NoSuchElementException {
        //two checks : bodyId & HeadingText of the page
        webDriverWait
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        return driver.findElement(By.cssSelector("body[class*=lang]")).getAttribute("id").equals(page.getBodyId()) &&
                driver.findElement(By.cssSelector("#page h1")).getText().equals(page.getHeadingText());
    }

    public void selectRandomRadioButton(By radioButton){
        driver.findElement(radioButton).click();
    }

    public boolean isCheckBoxSelected(By checkBox){
        return driver.findElement(checkBox).isSelected();
    }

    public void selectOption(By element, String option) {
        Select select = new Select(driver.findElement(element));
        try{
            select.selectByValue(option);
        }catch(Exception e){
            select.selectByVisibleText(option);
        }
    }

    public int getNumberOfSelectOptions(By selectOptions) {
        return driver.findElements(selectOptions).size();
    }

    public int getNumberOfElements(By element){
        return driver.findElements(element).size();
    }

    public void clearTextField(By element){
        driver.findElement(element).clear();
    }

    public String getPageIdentifier(){
        wait.waitForElement(By.tagName("body"), 5);
        String bodyClassAttribute = driver.findElement(By.tagName("body")).getAttribute("class");
        Pattern nodePattern = Pattern.compile("\\s[A-Z0-9_]+");
        Matcher matcher = nodePattern.matcher(bodyClassAttribute);

        if (matcher.find()){
            return matcher.group().trim();
        }
        return null;
    }

    public void waitAwhile() {
        waitInMilliSeconds(2000);
    }

    public void waitAwhile(int seconds) {
        waitInMilliSeconds(seconds * 1000);
    }

    public void waitAwhile(double seconds) {
        waitInMilliSeconds(seconds * 1000);
    }

    private void waitInMilliSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitInMilliSeconds(double milliseconds) {
        try {
            Thread.sleep((int) milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getStringList(By byElement){
        List<String> list = new ArrayList<>();
        List<WebElement> temp = driver.findElements(byElement);
        for(WebElement we : temp){
            String wordTemp = we.getText();
            if(!wordTemp.equals("")){
                list.add(we.getText());
            }
        }
        return list;
    }

    public void openUrl(Url url){
        String temp = url.getValue();
        driver.get(temp);
        logger.info("Open URL = "+temp);
    }
}
