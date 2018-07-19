package testUtils;

import org.openqa.selenium.WebDriver;
import pageServices.AccountCreationPageServices;
import pageServices.MyAccountPageServices;
import pageServices.StartPageServices;

public class Web {
    private WebDriver driver;

    public Web(WebDriver driver) {
        this.driver = driver;
    }

    public AccountCreationPageServices accountCreation() {
        return new AccountCreationPageServices(driver);
    }

    public MyAccountPageServices myAccount(){
        return new MyAccountPageServices(driver);
    }

    public StartPageServices startPage(){
        return new StartPageServices(driver);
    }
}
