package pages;

import enums.Page;
import enums.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitClass;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static utils.ObjectMap.getLocator;

public class GeneralPage {
    protected final WebDriver driver;
    WaitClass wait;
    private Logger logger = Logger.getLogger(GeneralPage.class);

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitClass(driver);
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
        By heading = getLocator("all_pages.page_heading.text");
        By body = getLocator("all_pages.page_body.id");
        //two checks : bodyId & HeadingText of the page
        int count = 0;
        boolean temp = false;
        while(count < 7 && !temp) {
            temp = driver.findElement(body).getAttribute("id").equals(page.getBodyId()) && driver.findElement(heading).getText().equals(page.getHeadingText());
            this.waitAwhile(1);
            count++;
        }
        return temp;

    }

    public void selectOption(By element, String option) {
        Select select = new Select(driver.findElement(element));
        try{
            select.selectByValue(option);
        }catch(Exception e){
            select.selectByVisibleText(option);
        }
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

    public String openUrl(Page page){
        String temp = page.getUrl();
        driver.get(temp);
        return temp;
    }

    public String openUrl(Page page,String email){
        String temp = page.getUrl(email);
        driver.get(temp);
        return temp;
    }

    public String openUrl(Page page, User user){
        String temp = page.getUrl(user);
        driver.get(temp);
        return temp;
    }
}
