package pageServices;

import enums.Page;
import enums.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.GeneralPage;

import java.util.NoSuchElementException;

public class GeneralPageServices {
    private GeneralPage generalPage;
    private Logger logger = Logger.getLogger(GeneralPageServices.class);
    String location = "||||| : ";         //for the general Services
    String locationSymbol = "///// : ";   //inside the specific services

    public GeneralPageServices(WebDriver driver) {
        generalPage = new GeneralPage(driver);
    }

    public boolean isRightPageOpened(Page page) throws NoSuchElementException {
        return generalPage.isRightPageOpened(page);
    }

    public void openUrl(Page page) {
        logger.info(location+"Open the url of page : "+page.name());
        logger.info(location+"The url is : "+generalPage.openUrl(page));
    }

    public void openUrl(Page page, User user) {
        logger.info(location+"Open the url of page : "+page.name()+ " with User : "+user.getFirstname()+" "+user.getLastname());
        logger.info(location+"The url is : "+generalPage.openUrl(page,user));
    }

    public void openUrl(Page page, String email) {
        logger.info(location+"Open the url of page : "+page.name()+ " with Email : "+email);
        logger.info(location+"The url is : "+generalPage.openUrl(page,email));

    }
}
