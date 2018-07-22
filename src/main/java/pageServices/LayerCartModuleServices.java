package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AddressesPage;
import pages.LayerCartModule;

public class LayerCartModuleServices extends GeneralPageServices{
    private LayerCartModule layerCartModule;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public LayerCartModuleServices(WebDriver driver) {
        super(driver);
        location = "LAYER CART";
        logger.info("@ "+location);
        layerCartModule = new LayerCartModule(driver);
    }

    public void waitLayerCartDisplayed() {
        layerCartModule.waitLayerCartDisplayed();
    }

    public void clickOnProceedToCheckoutButton() {
        logger.info(locationSymbol+"Click on button proceed to checkout");
        layerCartModule.waitLayerCartDisplayed();
        layerCartModule.clickOnProceedToCheckoutButton();
    }
}
