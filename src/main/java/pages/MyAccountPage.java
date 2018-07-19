package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class MyAccountPage extends GeneralPage {

    private By emailField,createAccountButton;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        initMyAccountPageElements();
        wait.waitForElement(emailField,5);
    }

    private void initMyAccountPageElements() {
        emailField = getLocator("my_account.email_address.field");
        createAccountButton = getLocator("my_account.submit.button");
    }

    public void typeOnEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickOnCreateAnAccountButton(){
        wait.waitForElement(createAccountButton,5);
        driver.findElement(createAccountButton).click();
    }
}
