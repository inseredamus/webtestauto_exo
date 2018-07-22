package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class LayerCartModule extends GeneralPage {
    private By layerCart, proceedToCheckout;
    public LayerCartModule(WebDriver driver) {
        super(driver);
        initLayerCartModuleElements();
        wait.waitForElement(layerCart,5);
    }

    private void initLayerCartModuleElements() {
        layerCart = getLocator("layer_cart.layerCart.item");
        proceedToCheckout = getLocator("layer_cart.proceedToCheckout.button");
    }

    public void waitLayerCartDisplayed(){
        wait.waitForElement(layerCart,5);
    }

    public void clickOnProceedToCheckoutButton(){
        wait.waitForElement(proceedToCheckout,5);
        driver.findElement(proceedToCheckout).click();
    }
}
