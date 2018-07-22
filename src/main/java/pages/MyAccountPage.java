package pages;

import enums.MenuTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class MyAccountPage extends GeneralPage{
    private By logoutLink, headerUserInfo, welcomeInfo, faddedShortSleeveTshirts, addToCart;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        initMyAccountPageElements();
        wait.waitForElement(logoutLink,5);
    }

    private void initMyAccountPageElements() {
        logoutLink = getLocator("my_account.logout.link");
        headerUserInfo = getLocator("my_account.header_user_info.text");
        welcomeInfo = getLocator("my_account.welcome.text");
        faddedShortSleeveTshirts = getLocator("my_account.faded.short.sleeve.tshirt.link");
        addToCart = getLocator("my_account.add_to_cart.button");
    }

    public void clickOnLogoutButton(){
        wait.waitForElement(logoutLink,5);
        driver.findElement(logoutLink).click();
    }

    public boolean isLogoutLinkPresent() {
        wait.waitForElement(logoutLink,5);
        return driver.findElement(logoutLink).isDisplayed();
    }

    public String getDisplayedFirstnameAndLastname(){
        wait.waitForElement(headerUserInfo,5);
        return driver.findElement(headerUserInfo).getText();
    }

    public boolean isWelcomeInfoPresent(){
        wait.waitForElement(welcomeInfo,5);
        return driver.findElement(welcomeInfo).getText().contains("Welcome to your account.");
    }

    public boolean isCurrentUrlCorrectlyBuilt(){
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    public void clickOnMenuTab(MenuTab tab){
        By element = tab.getByElement();
        wait.waitForElement(element,5);
        driver.findElement(element).click();
    }

    public void clickOnFadedShortSleeveTshirts(){
        wait.waitForElement(faddedShortSleeveTshirts,5);
        driver.findElement(faddedShortSleeveTshirts).click();
    }

    public void clicOnAddToCartButton(){
        wait.waitForElement(addToCart,5);
        driver.findElement(addToCart).click();
    }

}
