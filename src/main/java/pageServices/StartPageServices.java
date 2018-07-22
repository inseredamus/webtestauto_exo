package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.StartPage;

public class StartPageServices extends GeneralPageServices {
    private StartPage startPage;
    private Logger logger = Logger.getLogger(StartPageServices.class);
    public StartPageServices(WebDriver driver) {
        super(driver);
        location = "START PAGE";
        logger.info("@ "+location);
        startPage = new StartPage(driver);
    }

    public void clickOnSigninLink() {
        logger.info(locationSymbol+"Click on the link Sign In");
        startPage.clickOnSigninLink();
    }
}

