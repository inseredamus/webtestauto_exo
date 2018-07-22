package pageServices;

import enums.MenuTab;
import enums.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountPageServices extends GeneralPageServices{
    private MyAccountPage myAccountPage;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public MyAccountPageServices(WebDriver driver) {
        super(driver);
        location = "MY ACCOUNT PAGE";
        logger.info("@ "+location);
        myAccountPage = new MyAccountPage(driver);
    }

    public void clickOnLogoutButton() {
        logger.info(locationSymbol+"Click on Logout Button");
        myAccountPage.clickOnLogoutButton();
    }

    public boolean isLogoutLinkPresent(){
        return myAccountPage.isLogoutLinkPresent();
    }

    public String getDisplayedFirstnameAndLastname() {
        return myAccountPage.getDisplayedFirstnameAndLastname();
    }

    public boolean areExpectedFistnameAndLastnameDisplayed(User user) {
        return getDisplayedFirstnameAndLastname().equals(user.getFirstname()+" "+user.getLastname());
    }

    public boolean isWelcomeInfoPresent() {
        return myAccountPage.isWelcomeInfoPresent();
    }

    public boolean isCurrentUrlCorrectlyBuilt() {
        return myAccountPage.isCurrentUrlCorrectlyBuilt();
    }

    public void clickOnMenuTab(MenuTab tab) {
        logger.info(locationSymbol+"Click on Menu Tab : "+tab.name());
        myAccountPage.clickOnMenuTab(tab);
    }

    public void clickOnFadedShortSleeveTshirts() {
        myAccountPage.clickOnFadedShortSleeveTshirts();
    }

    public void openArticleFadedShortSleeveTshirts(){
        logger.info(locationSymbol+"Open the Article detail page : Faded Shorts Sleeve T-shirts");
        myAccountPage.clickOnFadedShortSleeveTshirts();
        myAccountPage.clickOnFadedShortSleeveTshirts();
    }

    public void clicOnAddToCartButton() {
        logger.info(locationSymbol+"Click on button Add to Cart");
        myAccountPage.clicOnAddToCartButton();
    }
}
