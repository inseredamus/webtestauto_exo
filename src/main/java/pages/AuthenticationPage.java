package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class AuthenticationPage extends GeneralPage {
    private By emailCreateField,createAccountButton,alreadyRegisteredEmailField,passwordField,submitLogin;
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        initAuthenticationPageElements();
        wait.waitForElement(emailCreateField,5);
    }

    private void initAuthenticationPageElements() {
        emailCreateField = getLocator("authentication.email_address.field");
        createAccountButton = getLocator("authentication.submit.create.button");
        alreadyRegisteredEmailField = getLocator("authentication.already.registered.email_address.field");
        passwordField = getLocator("authentication.password.field");
        submitLogin = getLocator("authentication.submit.login.button");
    }

    public void typeOnEmailField(String email){
        driver.findElement(emailCreateField).sendKeys(email);
    }

    public void clickOnCreateAnAccountButton(){
        wait.waitForElement(createAccountButton,5);
        driver.findElement(createAccountButton).click();
    }

    public void typeAlreadyRegisteredEmail(String email){
        wait.waitForElement(alreadyRegisteredEmailField,5);
        driver.findElement(alreadyRegisteredEmailField).sendKeys(email);
    }

    public void typePassword(String password){
        wait.waitForElement(passwordField,5);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSubmitLoginButton(){
        wait.waitForElement(submitLogin,5);
        driver.findElement(submitLogin).click();
    }
}
