package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.OrderConfirmationPage;

public class OrderConfirmationPageServices extends GeneralPageServices {
    private OrderConfirmationPage orderConfirmationPage;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public OrderConfirmationPageServices(WebDriver driver) {
        super(driver);
        location = "ORDER CONFIRMATION PAGE";
        logger.info("@ "+location);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    public boolean isStep4ShippingDisplayed() {
        return orderConfirmationPage.isStep4ShippingDisplayed();
    }

    public boolean isStep5PaymentDisplayed() {
        return orderConfirmationPage.isStep5PaymentDisplayed();
    }

    public boolean isMyOrderComplete() {
        return orderConfirmationPage.isMyOrderComplete();
    }

    public boolean isCurrentUrlCorrectlyBuilt() {
        return orderConfirmationPage.isCurrentUrlCorrectlyBuilt();
    }
}
