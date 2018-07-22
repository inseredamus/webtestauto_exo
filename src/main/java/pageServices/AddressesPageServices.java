package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AddressesPage;

public class AddressesPageServices extends GeneralPageServices {
    private AddressesPage addressesPage;
    private Logger logger = Logger.getLogger(AddressesPageServices.class);
    public AddressesPageServices(WebDriver driver) {
        super(driver);
        location = "ADDRESSES PAGE";
        logger.info("@ "+location);
        addressesPage = new AddressesPage(driver);
    }

    public void clickOnProceedToCheckoutButton() {
        logger.info(locationSymbol+"Click on button proceed to checkout");
        addressesPage.clickOnProceedToCheckoutButton();
    }
}
