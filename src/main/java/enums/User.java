package enums;

public enum User {
    //EXISTING_USER(perhaps too?),USER_LONG_PASSW,USER_LONG_EMAIL,USER_SPECIAL_CHARACTERS_PASSW are existing emails in the outside world (only 2 months)
    EXISTING_USER("hf_challenge_123456@hf12345.com","12345678","Joe","Black"),
    NOT_EXISTING_USER("blabla123456@blablasout.frzw","asdfgqwer"),
    USER_LONG_PASSW("marguerite.spencer@wegwerfmail.org","wertzuiopasdfghjklyxcvbnmwertzuiopqasdfghjklyxcvbnmqwertzuiasdfghjklyxcvbnmqwertzuioasdfghjkyxcvbn123"),
    USER_LONG_EMAIL("aric.shields33_aric.shields33-aric.shields33.aric.shields33_aric.shields33-aric.shields33-aric.shields33_aric.shields33@wegwerfmail.org","blabla1234"),
    USER_SPECIAL_CHARACTERS_PASSW("marguerite.spencer@wegwerfmail.org","bSz/95-2$7blaTZO04."),

    USER_BASIC_INFOS1(Gender.FEMALE,"Firstname","Lastname","Qwerty","1","1","2000","Company","Qwerty, 123","zxcvb","Qwerty","Colorado","12345","Qwerty","12345123123","12345123123","hf"),
    USER_BASIC_INFOS2(Gender.MALE,"John","Sweet","AsWe123","3","11","1944","SNCF","6 rue des Forêts","","Newtok","Alaska","99559","Nothing to add","0546298107","0610650848","dm"),
    ;

    Gender gender;
    String username,firstname,lastname,password,bday_day,bday_month,bday_year,company,addr1,addr2,city,state,postcode,other,phone,mobilePhone,alias;
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }



    User(Gender gender, String firstname, String lastname, String password, String bday_day, String bday_month, String bday_year, String company,
         String addr1, String addr2, String city, String state, String postcode, String other, String phone, String mobilePhone, String alias) {
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.bday_day = bday_day;
        this.bday_month = bday_month;
        this.bday_year = bday_year;
        this.company = company;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.other = other;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.alias = alias;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBday_day() {
        return bday_day;
    }

    public String getBday_month() {
        return bday_month;
    }

    public String getBday_year() {
        return bday_year;
    }

    public String getCompany() {
        return company;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getOther() {
        return other;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAlias() {
        return alias;
    }
}

