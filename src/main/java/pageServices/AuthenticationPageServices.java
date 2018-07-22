package pageServices;

import enums.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;

public class AuthenticationPageServices extends GeneralPageServices {
    private AuthenticationPage authenticationPage;
    private Logger logger = Logger.getLogger(AuthenticationPageServices.class);
    public AuthenticationPageServices(WebDriver driver) {
        super(driver);
        location = "AUTHENTICATION PAGE";
        logger.info("@ "+location);
        authenticationPage = new AuthenticationPage(driver);
    }

    public void typeOnEmailField(User user) {
        logger.info(locationSymbol+"Type the username/email : "+user.getUsername());
        authenticationPage.typeOnEmailField(user.getUsername());
    }

    public void typeOnEmailField(String emailOrUsername) {
        logger.info(locationSymbol+"Type the username/email : "+emailOrUsername);
        authenticationPage.typeOnEmailField(emailOrUsername);
    }


    public void clickOnCreateAnAccountButton() {
        logger.info(locationSymbol+"Click on the Button Create an account");
        authenticationPage.clickOnCreateAnAccountButton();
    }

    public void typeAlreadyRegisteredEmail(String email) {
        logger.info(locationSymbol+"Type an email (already registered) : "+email);
        authenticationPage.typeAlreadyRegisteredEmail(email);
    }

    public void typePassword(String password) {
        logger.info(locationSymbol+"Type the password : "+password.substring(0,2)+"****");
        authenticationPage.typePassword(password);
    }

    public void loginAndSubmit(User user){
        logger.info(locationSymbol+"# Login the user : "+user.getFirstname()+" "+user.getLastname()+" =>");
        typeAlreadyRegisteredEmail(user.getUsername());
        typePassword(user.getPassword());
        clickOnSubmitLoginButton();
    }

    public void clickOnSubmitLoginButton() {
        logger.info(locationSymbol+"Click on the submit login button");
        authenticationPage.clickOnSubmitLoginButton();
    }
}
