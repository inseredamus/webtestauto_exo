package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class ShippingPage extends GeneralPage {
    private By termServiceCheckbox, proceedToCheckoutButton;
    public ShippingPage(WebDriver driver) {
        super(driver);
        initShippingPageElements();
        wait.waitForElement(proceedToCheckoutButton,5);
    }

    private void initShippingPageElements() {
        proceedToCheckoutButton = getLocator("shipping.proceedToCheckout.button");
        termServiceCheckbox = getLocator("shipping.termService.checkbox");
    }

    public void clickOnTermCheckbox(){
        wait.waitForElement(termServiceCheckbox,5);
        driver.findElement(termServiceCheckbox).click();
    }

    public void clickOnProceedToCheckoutButton(){
        wait.waitForElement(proceedToCheckoutButton,5);
        driver.findElement(proceedToCheckoutButton).click();
    }


}
