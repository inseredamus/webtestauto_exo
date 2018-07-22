package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ShippingPage;

public class ShippingPageServices extends GeneralPageServices {
    private ShippingPage shippingPage;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public ShippingPageServices(WebDriver driver) {
        super(driver);
        location = "SHIPPING PAGE";
        logger.info("@ "+location);
        shippingPage = new ShippingPage(driver);
    }

    public void clickOnTermCheckbox() {
        logger.info(locationSymbol+"Click on checkbox : terms of service");
        shippingPage.clickOnTermCheckbox();
    }

    public void clickOnProceedToCheckoutButton() {
        logger.info(locationSymbol+"Click on button : proceed to checkout");
        shippingPage.clickOnProceedToCheckoutButton();
    }
}
