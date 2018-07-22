package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class OrderConfirmationPage extends GeneralPage {
    private By orderStep4, orderStep5, summaryConfirmationInfo;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        initOrderConfirmationPageElements();
        wait.waitForElement(summaryConfirmationInfo,5);
    }

    private void initOrderConfirmationPageElements() {
        orderStep4 = getLocator("order_confirmation.orderStept4.item");
        orderStep5 = getLocator("order_confirmation.orderStept5.item");
        summaryConfirmationInfo = getLocator("order_confirmation.confirmation_info.item");
    }

    public boolean isStep4ShippingDisplayed(){
        wait.waitForElement(orderStep4,5);
        return driver.findElement(orderStep4).isDisplayed();
    }

    public boolean isStep5PaymentDisplayed(){
        wait.waitForElement(orderStep5,5);
        return driver.findElement(orderStep5).isDisplayed();
    }

    public boolean isMyOrderComplete(){
        wait.waitForElement(summaryConfirmationInfo,5);
        return driver.findElement(summaryConfirmationInfo).getText().contains("Your order on My Store is complete");
    }

    public boolean isCurrentUrlCorrectlyBuilt() {
        return driver.getCurrentUrl().contains("controller=order-confirmation");
    }

    //http://automationpractice.com/index.php?controller=order-confirmation&id_cart=646955&id_module=3&id_order=63056&key=76afb2170a71135061f2d4f0eea22a57
}
