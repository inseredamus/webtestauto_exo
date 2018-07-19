package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class StartPage extends GeneralPage {
    private By signinLink;
    public StartPage(WebDriver driver) throws Exception {
        super(driver);
        initStartPageElements();
        wait.waitForElement(signinLink,5);
    }

    private void initStartPageElements() {
        signinLink = getLocator("start_page.sign_in.login.link");
    }

    public void clickOnSigninLink(){
        driver.findElement(signinLink).click();
    }
}
