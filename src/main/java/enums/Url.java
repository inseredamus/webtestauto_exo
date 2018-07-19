package enums;

import utils.LoadProperties;

public enum Url {
    AUTOMATION_PRACTICE_TEST("automation.practice.url"),
    ;

    private String value;

    Url(String value) {
        LoadProperties lp = new LoadProperties("application.properties");
        this.value = lp.getPropValue(value);
    }

    public String getValue() {
        return value;
    }
}
