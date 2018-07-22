package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class PaymentMethodPage extends GeneralPage {
    private By bankwireLink;
    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        initPaymentMethodPageElements();
        wait.waitForElement(bankwireLink,5);
    }

    private void initPaymentMethodPageElements() {
        bankwireLink = getLocator("payment_method.bankwire.link");
    }

    public void clickOnBankwireLink(){
        wait.waitForElement(bankwireLink,5);
        driver.findElement(bankwireLink).click();
    }
}
