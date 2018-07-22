package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class ShoppingCartSummaryPage extends GeneralPage {
    private By proceedToCheckoutButton;

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        initShoppingCartSummaryPageElements();
        wait.waitForElement(proceedToCheckoutButton,5);
    }

    private void initShoppingCartSummaryPageElements() {
        proceedToCheckoutButton = getLocator("shopping_cart_summary.proceed_to_checkout.button");
    }

    public void clickOnProceedToCheckoutButton(){
        wait.waitForElement(proceedToCheckoutButton,5);
        driver.findElement(proceedToCheckoutButton).click();
    }
}
