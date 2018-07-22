package testclasses;

import enums.Page;
import enums.User;
import org.junit.Test;
import pageServices.*;
import testUtils.CustomAssert;
import testUtils.TestSetupUtils;

import static enums.MenuTab.WOMEN;
import static enums.Page.ORDER_CONFIRMATION;


public class CheckoutTest extends TestSetupUtils {

    @Test
    public void checkoutLoggedBankWireTest(){
        web.net().openUrl(Page.START_PAGE);

        web.startPage().clickOnSigninLink();

        AuthenticationPageServices authentication = web.authentication();
        authentication.loginAndSubmit(User.EXISTING_USER);

        MyAccountPageServices myAccount = web.myAccount();
        myAccount.clickOnMenuTab(WOMEN);
        myAccount.openArticleFadedShortSleeveTshirts();
        myAccount.clicOnAddToCartButton();

        web.layerCart().clickOnProceedToCheckoutButton();

        ShoppingCartSummaryPageServices shoppingCartSummary = web.shoppingCartSummary();
        shoppingCartSummary.clickOnProceedToCheckoutButton();

        AddressesPageServices addresses = web.addresses();
        addresses.clickOnProceedToCheckoutButton();

        ShippingPageServices shipping = web.shipping();
        shipping.clickOnTermCheckbox();
        shipping.clickOnProceedToCheckoutButton();

        web.payment().clickOnBankwireLink();

        web.orderSummary().clickOnConfirmMyOrderButton();

        OrderConfirmationPageServices orderConfirmation = web.orderConfirmation();
        CustomAssert.assertTrue("Right page opened",orderConfirmation.isRightPageOpened(ORDER_CONFIRMATION));
        CustomAssert.assertTrue("Order step 4 : shipping is displayed",orderConfirmation.isStep4ShippingDisplayed());
        CustomAssert.assertTrue("Order step 5 : payment is displayed",orderConfirmation.isStep5PaymentDisplayed());
        CustomAssert.assertTrue("Order confirmation info notices it is complete",orderConfirmation.isMyOrderComplete());
        CustomAssert.assertTrue("The current url is correctly built",orderConfirmation.isCurrentUrlCorrectlyBuilt());
    }
}
