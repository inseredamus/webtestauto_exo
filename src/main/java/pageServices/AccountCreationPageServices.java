package pageServices;

import enums.Gender;
import enums.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import pages.AccountCreationPage;

public class AccountCreationPageServices extends GeneralPageServices {
    private AccountCreationPage accountCreationPage;
    private Logger logger = Logger.getLogger(AccountCreationPageServices.class);
    public AccountCreationPageServices(WebDriver driver) {
        super(driver);
        location = "ACCOUNT CREATION PAGE";
        logger.info("@ "+location);
        accountCreationPage = new AccountCreationPage(driver);
    }

    public void fillYourPersonalInformation(User user){
        logger.info(locationSymbol+"# Fill Your Personal Information form =>");
        clickGenderRadioButton(user.getGender());
        typePersoFirstname(user.getFirstname());
        typePersoLastname(user.getLastname());
        typePersoPassword(user.getPassword());
        selectBirthday(user.getBday_day(),user.getBday_month(),user.getBday_year());
    }

    public void fillYourAddress(User user){
        logger.info(locationSymbol+"# Fill Your Address form =>");
        typeAddressFirstname(user.getFirstname());
        typeAddressLastname(user.getLastname());
        typeAddressCompany(user.getCompany());
        typeAddress1(user.getAddr1());
        typeAddress2(user.getAddr2());
        typeCity(user.getCity());
        selectState(user.getState());
        typePostcode(user.getPostcode());
        //selectCountry(user.getCountry()); will be automatically United States.
        typeAdditionalInto(user.getOther());
        typePhone(user.getPhone());
        typeMobilePhone(user.getMobilePhone());
        typeAlias(user.getAlias());
    }

    public void clickRegisterButton() {
        logger.info(locationSymbol+"Click on the register submit button");
        accountCreationPage.clickRegisterButton();
    }

    private void clickGenderRadioButton(Gender gender) {
        logger.info(locationSymbol+"Click on Radio Button Gender "+gender.name().toLowerCase());
        if(gender == Gender.MALE){
            accountCreationPage.clickMaleRadioButton();
        }else{
            accountCreationPage.clickFemaleRadioButton();
        }
    }

    private void typePersoFirstname(String firstname) {
        logger.info(locationSymbol+"Type the firstname : "+firstname+" in personal info");
        accountCreationPage.typePersoFirstname(firstname);
    }

    private void typePersoLastname(String lastname) {
        logger.info(locationSymbol+"Type the lastname : "+lastname+" in personal info");
        accountCreationPage.typePersoLastname(lastname);
    }

    public void typePersoEmail(String email) {
        logger.info(locationSymbol+"Type the email : "+email+" in personal info");
        accountCreationPage.typePersoEmail(email);
    }

    private void typePersoPassword(String password) {
        logger.info(locationSymbol+"Type the password : "+password.substring(0,2)+"***** in personal info");
        accountCreationPage.typePersoPassword(password);
    }

    private void selectBirthday(String day, String month, String year){
        logger.info(locationSymbol+"Select the birthday : "+day+"/"+month+"/"+year+" in personal info");
        accountCreationPage.selectBirthdayDay(day);
        accountCreationPage.selectBirthdayMonth(month);
        accountCreationPage.selectBirthdayYear(year);
    }

    private void typeAddressFirstname(String firstname) {
        logger.info(locationSymbol+"Type the firstname : "+firstname+" in address");
        accountCreationPage.clearAddressFistname();
        accountCreationPage.typeAddressFirstname(firstname);
    }

    private void typeAddressLastname(String lastname) {
        logger.info(locationSymbol+"Type the lastname :  "+lastname+" in address");
        accountCreationPage.clearAddressLastname();
        accountCreationPage.typeAddressLastname(lastname);
    }

    private void typeAddressCompany(String company) {
        logger.info(locationSymbol+"Type the company : "+company+" in address");
        accountCreationPage.typeAddressCompany(company);
    }

    private void typeAddress1(String addr1) {
        logger.info(locationSymbol+"Type the address part 1 : "+addr1+" in address");
        accountCreationPage.typeAddress1(addr1);
    }

    private void typeAddress2(String addr2) {
        logger.info(locationSymbol+"Type the address part 2 : "+addr2+" in address");
        //useful for the ignored smoke test : the part 2 of the address is not displayed (not critical if avoided, that's a why try/catch)
        try{
            accountCreationPage.typeAddress2(addr2);
        }catch(ElementNotVisibleException e){
            logger.warn("##### : The element address line 2 is not visible");
        }
    }

    private void typeCity(String city) {
        logger.info(locationSymbol+"Type the city : "+city+" in address");
        accountCreationPage.typeCity(city);
    }

    private void selectState(String state) {
        logger.info(locationSymbol+"Select the state : "+state+" in address");
        accountCreationPage.selectState(state);
    }

    private void typePostcode(String postcode) {
        logger.info(locationSymbol+"Type the postcode : "+postcode+" in address");
        accountCreationPage.typePostcode(postcode);
    }

    public void selectCountry(String country) {
        logger.info(locationSymbol+"Select the country : "+country+" in address");
        accountCreationPage.selectCountry(country);
    }

    private void typePhone(String phone) {
        logger.info(locationSymbol+"Type the phone : "+phone+" in address");
        accountCreationPage.clearPhone();
        accountCreationPage.typePhone(phone);
    }

    private void typeMobilePhone(String mobilePhone) {
        logger.info(locationSymbol+"Type the mobile phone : "+mobilePhone+" in address");
        accountCreationPage.clearMobilePhone();
        accountCreationPage.typeMobilePhone(mobilePhone);
    }

    private void typeAdditionalInto(String additionalInfo) {
        logger.info(locationSymbol+"Type the additional info : "+additionalInfo+" in address");
        accountCreationPage.typeAdditionalInto(additionalInfo);
    }

    private void typeAlias(String alias) {
        logger.info(locationSymbol+"Type the alias : "+alias+" in address");
        accountCreationPage.clearAliasField();
        accountCreationPage.typeAlias(alias);
    }

}
