package enums;

public enum User {
    EXISTING_USER("hf_challenge_123456@hf12345.com","12345678"),
    NOT_EXISTING_USER("blabla123456@blablasout.frzw","asdfgqwer"),
    USER_LONG_PASSW("marguerite.spencer@wegwerfmail.org","wertzuiopasdfghjklyxcvbnmwertzuiopqasdfghjklyxcvbnmqwertzuiasdfghjklyxcvbnmqwertzuioasdfghjkyxcvbn123"),
    USER_LONG_EMAIL("aric.shields33_aric.shields33-aric.shields33.aric.shields33_aric.shields33-aric.shields33-aric.shields33_aric.shields33@wegwerfmail.org","blabla1234"),
    USER_SPECIAL_CHARACTERS_PASSW("marguerite.spencer@wegwerfmail.org","bSz/95-2$7blaTZO04.");

    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
