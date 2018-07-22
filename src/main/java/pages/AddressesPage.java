package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class AddressesPage extends GeneralPage {
    private By proceedToCheckout;
    public AddressesPage(WebDriver driver) {
        super(driver);
        initAddressesPageElements();
        wait.waitForElement(proceedToCheckout,5);
    }

    private void initAddressesPageElements() {
        proceedToCheckout = getLocator("addresses.proceed_to_checkout.button");
    }

    public void clickOnProceedToCheckoutButton(){
        wait.waitForElement(proceedToCheckout,5);
        driver.findElement(proceedToCheckout).click();
    }
}
