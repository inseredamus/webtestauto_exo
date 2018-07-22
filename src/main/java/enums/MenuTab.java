package enums;

import org.openqa.selenium.By;

import static utils.ObjectMap.getLocator;

public enum MenuTab {
    WOMEN("my_account.women.link","3"),
    DRESSES("my_account.dresses.link","8"),
    TSHIRTS("my_account.tshirts.link","5"),
    ;

    String uiLink;
    String categoryNumber;

    MenuTab(String uiLink, String categoryNumber) {
        this.uiLink = uiLink;
        this.categoryNumber = categoryNumber;
    }

    public By getByElement() {
        return getLocator(this.uiLink);
    }

    public String getCategoryNumber() {
        return categoryNumber;
    }
}
