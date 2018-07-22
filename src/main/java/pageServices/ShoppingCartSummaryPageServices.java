package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartSummaryPage;

public class ShoppingCartSummaryPageServices extends GeneralPageServices {
    private ShoppingCartSummaryPage shoppingCartSummaryPage;
    private Logger logger = Logger.getLogger(ShoppingCartSummaryPageServices.class);
    public ShoppingCartSummaryPageServices(WebDriver driver) {
        super(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    }

    public void clickOnProceedToCheckoutButton() {
        logger.info(locationSymbol+"Click on button Proceed to checkout");
        shoppingCartSummaryPage.clickOnProceedToCheckoutButton();
    }
}
