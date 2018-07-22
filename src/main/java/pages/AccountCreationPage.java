package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ObjectMap.getLocator;

public class AccountCreationPage extends GeneralPage {
    private By ypi_maleRadio,ypi_femaleRadio,ypi_firstname,ypi_lastname,ypi_email,ypi_password,ypi_birthday_d,ypi_birthday_m,ypi_birthday_y;
    private By addr_firstname,addr_lastname,addr_company,addr_addr1,addr_addr2,addr_city,addr_state,addr_postcode,addr_country,addr_other,addr_phone,addr_mobile,addr_alias;
    private By reg_submitButton;
    public AccountCreationPage(WebDriver driver) {
        super(driver);
        initAccountCreationElements();
        wait.waitForElement(ypi_maleRadio,5);
    }

    private void initAccountCreationElements() {
        ypi_maleRadio = getLocator("account_creation.your_perso_info.title.gender.male.radio");
        ypi_femaleRadio = getLocator("account_creation.your_perso_info.title.gender.female.radio");
        ypi_firstname = getLocator("account_creation.your_perso_info.customer_firstname.field");
        ypi_lastname = getLocator("account_creation.your_perso_info.customer_lastname.field");
        ypi_email = getLocator("account_creation.your_perso_info.email.field");
        ypi_password = getLocator("account_creation.your_perso_info.password.field");
        ypi_birthday_d = getLocator("account_creation.your_perso_info.days.select");
        ypi_birthday_m = getLocator("account_creation.your_perso_info.months.select");
        ypi_birthday_y = getLocator("account_creation.your_perso_info.years.select");
        addr_firstname = getLocator("account_creation.address.firstname.field");
        addr_lastname = getLocator("account_creation.address.lastname.field");
        addr_company = getLocator("account_creation.address.company.field");
        addr_addr1 = getLocator("account_creation.address.address1.field");
        addr_addr2 = getLocator("account_creation.address.address2.field");
        addr_city = getLocator("account_creation.address.city.field");
        addr_state = getLocator("account_creation.address.state.select");
        addr_postcode = getLocator("account_creation.address.zip.field");
        addr_country = getLocator("account_creation.address.country.select");
        addr_other = getLocator("account_creation.address.additional_information.field");
        addr_phone = getLocator("account_creation.address.home_phone.field");
        addr_mobile = getLocator("account_creation.address.mobile_phone.field");
        addr_alias = getLocator("account_creation.address.assign_an_alias.field");
        reg_submitButton = getLocator("account_creation.register.buton");
    }

    public void clickMaleRadioButton(){
        wait.waitForElement(ypi_maleRadio,5);
        driver.findElement(ypi_maleRadio).click();
    }

    public void clickFemaleRadioButton(){
        wait.waitForElement(ypi_femaleRadio,5);
        driver.findElement(ypi_femaleRadio).click();
    }

    public void typePersoFirstname(String firstname){
        wait.waitForElement(ypi_firstname,5);
        driver.findElement(ypi_firstname).sendKeys(firstname);
    }

    public void typePersoLastname(String lastname){
        wait.waitForElement(ypi_lastname,5);
        driver.findElement(ypi_lastname).sendKeys(lastname);
    }

    public void typePersoEmail(String email){
        wait.waitForElement(ypi_email,5);
        driver.findElement(ypi_email).sendKeys(email);
    }

    public void typePersoPassword(String password){
        wait.waitForElement(ypi_password,5);
        driver.findElement(ypi_password).sendKeys(password);
    }

    public void selectBirthdayDay(String day){
        wait.waitForElement(ypi_birthday_d,5);
        selectOption(ypi_birthday_d,day);
    }

    public void selectBirthdayMonth(String month){
        wait.waitForElement(ypi_birthday_m,5);
        selectOption(ypi_birthday_m,month);
    }

    public void selectBirthdayYear(String year){
        wait.waitForElement(ypi_birthday_y,5);
        selectOption(ypi_birthday_y,year);
    }

    public void typeAddressFirstname(String firstname){
        wait.waitForElement(addr_firstname,5);
        driver.findElement(addr_firstname).sendKeys(firstname);
    }

    public void typeAddressLastname(String lastname){
        wait.waitForElement(addr_lastname,5);
        driver.findElement(addr_lastname).sendKeys(lastname);
    }

    public void typeAddressCompany(String company){
        wait.waitForElement(addr_company,5);
        driver.findElement(addr_company).sendKeys(company);
    }

    public void typeAddress1(String addr1){
        wait.waitForElement(addr_addr1,5);
        driver.findElement(addr_addr1).sendKeys(addr1);
    }

    public void typeAddress2(String addr2){
        wait.waitForElement(addr_addr2,1);
        driver.findElement(addr_addr2).sendKeys(addr2);
    }

    public void typeCity(String city){
        wait.waitForElement(addr_city,5);
        driver.findElement(addr_city).sendKeys(city);
    }

    public void selectState(String state){
        wait.waitForElement(addr_state,5);
        selectOption(addr_state,state);
    }

    public void typePostcode(String postcode){
        wait.waitForElement(addr_postcode,5);
        driver.findElement(addr_postcode).sendKeys(postcode);
    }

    public void selectCountry(String country){
        wait.waitForElement(addr_country,5);
        selectOption(addr_country,country);
    }

    public void typePhone(String phone){
        wait.waitForElement(addr_phone,5);
        driver.findElement(addr_phone).sendKeys(phone);
    }

    public void typeMobilePhone(String mobilePhone){
        wait.waitForElement(addr_mobile,5);
        driver.findElement(addr_mobile).sendKeys(mobilePhone);
    }

    public void typeAdditionalInto(String additionalInfo){
        wait.waitForElement(addr_other,5);
        driver.findElement(addr_other).sendKeys(additionalInfo);
    }

    public void typeAlias(String alias){
        wait.waitForElement(addr_alias,5);
        driver.findElement(addr_alias).sendKeys(alias);
    }

    public void clickRegisterButton(){
        wait.waitForElement(reg_submitButton,5);
        driver.findElement(reg_submitButton).click();
    }
}


