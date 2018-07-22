package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.OrderSummaryPage;

public class OrderSummaryPageServices extends GeneralPageServices {
    private OrderSummaryPage orderSummaryPage;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public OrderSummaryPageServices(WebDriver driver) {
        super(driver);
        location = "MY ACCOUNT PAGE";
        logger.info("@ "+location);
        orderSummaryPage = new OrderSummaryPage(driver);
    }

    public void clickOnConfirmMyOrderButton() {
        logger.info(locationSymbol+"Click on button I confirm my order");
        orderSummaryPage.clickOnConfirmMyOrderButton();
    }
}
