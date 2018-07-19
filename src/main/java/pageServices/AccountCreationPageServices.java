package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AccountCreationPage;

public class AccountCreationPageServices extends GeneralPageServices {
    private AccountCreationPage accountCreationPage;
    private Logger logger = Logger.getLogger(AccountCreationPageServices.class);
    public AccountCreationPageServices(WebDriver driver) {
        super(driver);
        location = "ACCOUNT_CREATION_PAGE: ";
        logger.info("@ "+location);
        accountCreationPage = new AccountCreationPage(driver);
    }

    public void clickMaleRadioButton() {
        logger.info(locationSymbol+"Click on Radio Button Gender Male");
        accountCreationPage.clickMaleRadioButton();
    }

    public void clickFemaleRadioButton() {
        logger.info(locationSymbol+"Click on Radio Button Gender Female");
        accountCreationPage.clickFemaleRadioButton();
    }

    public void typePersoFirstname(String firstname) {
        accountCreationPage.typePersoFirstname(firstname);
    }

    public void typePersoLastname(String lastname) {
        accountCreationPage.typePersoLastname(lastname);
    }

    public void typePersoEmail(String email) {
        accountCreationPage.typePersoEmail(email);
    }

    public void typePersoPassword(String password) {
        accountCreationPage.typePersoPassword(password);
    }

    public void selectBirthdayDay(String day) {
        accountCreationPage.selectBirthdayDay(day);
    }

    public void selectBirthdayMonth(String month) {
        accountCreationPage.selectBirthdayMonth(month);
    }

    public void selectBirthdayYear(String year) {
        accountCreationPage.selectBirthdayYear(year);
    }

    public void typeAddressFirstname(String firstname) {
        accountCreationPage.typeAddressFirstname(firstname);
    }

    public void typeAddressLastname(String lastname) {
        accountCreationPage.typeAddressLastname(lastname);
    }

    public void typeAddressCompany(String company) {
        accountCreationPage.typeAddressCompany(company);
    }

    public void typeAddress1(String addr1) {
        accountCreationPage.typeAddress1(addr1);
    }

    public void typeAddress2(String addr2) {
        accountCreationPage.typeAddress2(addr2);
    }

    public void typeCity(String city) {
        accountCreationPage.typeCity(city);
    }

    public void selectState(String state) {
        accountCreationPage.selectState(state);
    }

    public void typePostcode(String postcode) {
        accountCreationPage.typePostcode(postcode);
    }

    public void selectCountry(String country) {
        accountCreationPage.selectCountry(country);
    }

    public void typePhone(String phone) {
        accountCreationPage.typePhone(phone);
    }

    public void typeMobilePhone(String mobilePhone) {
        accountCreationPage.typeMobilePhone(mobilePhone);
    }

    public void typeAdditionalInto(String additionalInfo) {
        accountCreationPage.typeAdditionalInto(additionalInfo);
    }

    public void typeAlias(String alias) {
        accountCreationPage.typeAlias(alias);
    }

    public void clickRegisterButton() {
        accountCreationPage.clickRegisterButton();
    }
}
