package testclasses;

import enums.User;
import org.junit.Ignore;
import org.junit.Test;
import pageServices.AccountCreationPageServices;
import pageServices.AuthenticationPageServices;
import pageServices.MyAccountPageServices;
import pageServices.StartPageServices;
import testUtils.CustomAssert;
import testUtils.TestSetupUtils;

import static enums.Page.*;
import static utils.RandomData.getRandomHfEmail;

public class RegistrationAndLoginTest extends TestSetupUtils {

    /**
     * @author inseredamus
     *
     * An explorative Test is very important for a company, because if the test succeeds, we know that all the functions used are working.
     * If the explorative Test fails, it not easy to know which function is not working, that's why it's interesting to split the explorative test into smoke tests.
     * One smoke Test should indicates if one specific function is working or not.
     *
     * For example : the explorative test (testing functions a+b+c+d) runs until the middle of the test. The log events can determinate that the function b was not working.
     * But is function c not working as well ? => smoke tests can tell about it.
     *
     * The goal in test automation : stability and precise result
     */

    @Ignore
    @Test
    public void functionSignInTest(){ //TEST A
        web.net().openUrl(START_PAGE);
        StartPageServices startPage = web.startPage();
        CustomAssert.assertTrue("Right page opened",startPage.isRightPageOpened(START_PAGE));
        startPage.clickOnSigninLink();
        CustomAssert.assertTrue("Right page opened",web.authentication().isRightPageOpened(AUTHENTICATION));
    }

    @Ignore
    @Test
    public void functionCreateAnAccountTest(){ //TEST B
        web.net().openUrl(AUTHENTICATION);
        AuthenticationPageServices authentication = web.authentication();
        CustomAssert.assertTrue("Right page opened",authentication.isRightPageOpened(AUTHENTICATION));
        String randomEmail = getRandomHfEmail();
        authentication.typeOnEmailField(randomEmail);
        authentication.clickOnCreateAnAccountButton();
        CustomAssert.assertTrue("Right page opened",web.accountCreation().isRightPageOpened(ACCOUNT_CREATION));
    }

    @Ignore
    @Test
    public void functionRegisterTest(){ //TEST C
        web.net().openUrl(ACCOUNT_CREATION,getRandomHfEmail());
        AccountCreationPageServices accountCreation = web.accountCreation();
        CustomAssert.assertTrue("Right page opened",accountCreation.isRightPageOpened(ACCOUNT_CREATION));
        accountCreation.fillYourPersonalInformation(User.USER_BASIC_INFOS1);
        accountCreation.fillYourAddress(User.USER_BASIC_INFOS1);
        accountCreation.clickRegisterButton();
        CustomAssert.assertTrue("Right page opened",web.myAccount().isRightPageOpened(MY_ACCOUNT));
    }

    @Ignore
    @Test
    public void functionLoggoutTest(){ //TEST D
        web.net().openUrl(MY_ACCOUNT,User.EXISTING_USER);
        MyAccountPageServices myAccount = web.myAccount();
        CustomAssert.assertTrue("Right page opened",myAccount.isRightPageOpened(MY_ACCOUNT));
        myAccount.clickOnLogoutButton();
        CustomAssert.assertTrue("Right page opened",web.authentication().isRightPageOpened(AUTHENTICATION));
    }

    @Test
    public void registerTest(){ //= TEST A + B + C + (D)
        web.net().openUrl(START_PAGE);
        StartPageServices startPage = web.startPage();
        CustomAssert.assertTrue("Right page opened",startPage.isRightPageOpened(START_PAGE));
        web.startPage().clickOnSigninLink();
        AuthenticationPageServices authentication = web.authentication();
        CustomAssert.assertTrue("Right page opened",authentication.isRightPageOpened(AUTHENTICATION));
        authentication.typeOnEmailField(getRandomHfEmail());
        authentication.clickOnCreateAnAccountButton();
        AccountCreationPageServices accountCreation = web.accountCreation();
        CustomAssert.assertTrue("Right page opened",accountCreation.isRightPageOpened(ACCOUNT_CREATION));
        User user = User.USER_BASIC_INFOS1;
        accountCreation.fillYourPersonalInformation(user);
        accountCreation.fillYourAddress(user);
        accountCreation.clickRegisterButton();
        MyAccountPageServices myAccount = web.myAccount();
        CustomAssert.assertTrue("Right page opened",myAccount.isRightPageOpened(MY_ACCOUNT));
        CustomAssert.assertTrue("The link logout is displayed on the page", myAccount.isLogoutLinkPresent());
        CustomAssert.assertTrue("The firstname and Lastname are displayed correctly",myAccount.areExpectedFistnameAndLastnameDisplayed(user));
        CustomAssert.assertTrue("The Welcome information is displayed",myAccount.isWelcomeInfoPresent());
        CustomAssert.assertTrue("The current url is correctly built",myAccount.isCurrentUrlCorrectlyBuilt());

        //if we want to add the logout function to the explorative test
        /*
        myAccount.clickOnLogoutButton();
        authentication = web.authentication();
        CustomAssert.assertTrue("Right page opened",authentication.isRightPageOpened(AUTHENTICATION));
        */
    }

    @Test
    public void logInTest(){ //TEST D ~ explorative
        User user = User.EXISTING_USER;
        web.net().openUrl(START_PAGE);
        StartPageServices startPage = web.startPage();
        CustomAssert.assertTrue("Right page opened",startPage.isRightPageOpened(START_PAGE));
        web.startPage().clickOnSigninLink();
        CustomAssert.assertTrue("Right page opened",web.authentication().isRightPageOpened(AUTHENTICATION));
        AuthenticationPageServices authentication = web.authentication();
        authentication.loginAndSubmit(user);
        MyAccountPageServices myAccount = web.myAccount();
        CustomAssert.assertTrue("Right page opened",myAccount.isRightPageOpened(MY_ACCOUNT));
        CustomAssert.assertTrue("The firstname and Lastname are displayed correctly",myAccount.areExpectedFistnameAndLastnameDisplayed(user));
        CustomAssert.assertTrue("The link logout is displayed on the page", myAccount.isLogoutLinkPresent());
        CustomAssert.assertTrue("The Welcome information is displayed",myAccount.isWelcomeInfoPresent());
        CustomAssert.assertTrue("The current url is correctly built",myAccount.isCurrentUrlCorrectlyBuilt());
    }
}
