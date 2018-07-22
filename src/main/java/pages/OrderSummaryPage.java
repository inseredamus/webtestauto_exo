package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class OrderSummaryPage extends GeneralPage {
    private By confirmButton;
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        initOrderSummaryPageElements();
        wait.waitForElement(confirmButton,5);
    }

    private void initOrderSummaryPageElements() {
        confirmButton = getLocator("order_summary.confirm.button");
    }

    public void clickOnConfirmMyOrderButton(){
        wait.waitForElement(confirmButton,5);
        driver.findElement(confirmButton).click();
    }
}
