package testUtils;

import org.openqa.selenium.WebDriver;
import pageServices.*;

public class Web {
    private WebDriver driver;

    public Web(WebDriver driver) {
        this.driver = driver;
    }

    public GeneralPageServices net(){
        return new GeneralPageServices(driver);
    }

    public AccountCreationPageServices accountCreation() {
        return new AccountCreationPageServices(driver);
    }

    public AuthenticationPageServices authentication(){
        return new AuthenticationPageServices(driver);
    }

    public StartPageServices startPage(){
        return new StartPageServices(driver);
    }

    public MyAccountPageServices myAccount() { return new MyAccountPageServices(driver); }

    public ShoppingCartSummaryPageServices shoppingCartSummary(){
        return new ShoppingCartSummaryPageServices(driver);
    }

    public AddressesPageServices addresses() {
        return new AddressesPageServices(driver);
    }

    public ShippingPageServices shipping(){
        return new ShippingPageServices(driver);
    }

    public PaymentMethodPageServices payment(){ return new PaymentMethodPageServices(driver); }

    public OrderSummaryPageServices orderSummary(){
        return new OrderSummaryPageServices(driver);
    }

    public OrderConfirmationPageServices orderConfirmation(){
        return new OrderConfirmationPageServices(driver);
    }

    public LayerCartModuleServices layerCart() { return new LayerCartModuleServices(driver);
    }
}
