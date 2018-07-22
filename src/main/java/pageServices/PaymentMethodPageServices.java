package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.PaymentMethodPage;

public class PaymentMethodPageServices extends GeneralPageServices {
    private PaymentMethodPage paymentMethodPage;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public PaymentMethodPageServices(WebDriver driver) {
        super(driver);
        location = "MY ACCOUNT PAGE";
        logger.info("@ "+location);
        paymentMethodPage = new PaymentMethodPage(driver);
    }

    public void clickOnBankwireLink() {
        logger.info(locationSymbol+"Click on the link bank wire");
        paymentMethodPage.clickOnBankwireLink();
    }
}
