package enums;

import utils.LoadProperties;

public enum Page {
    //css  :#page h1 -> text (1)
    //css  :body[class*=lang] -> id

    //after open the url value of : automation.practice.url
    START_PAGE("Automation Practice Website","index","page.automation.practice.index.url"),

    //after clicking on 'sign in'
    AUTHENTICATION("AUTHENTICATION","authentication","page.authentication.url"),

    //after clicking on 'create an account'
    //ACCOUNT_CREATION("Create an account","authentication","page.create.an.account.url"),
    ACCOUNT_CREATION("CREATE AN ACCOUNT","authentication","page.create.an.account.url"),

    //after creating an account or logging in
    MY_ACCOUNT("MY ACCOUNT","my-account","page.my.account.url"),

    WOMEN("WOMEN","category","page.category.url"),

    DRESSES("DRESSES","category","page.category.url"),

    TSHIRTS("T-SHIRTS","category","page.category.url"),

    SHOPPING_CART_SUMMARY("SHOPPING-CART SUMMARY","order","page.shoppingcart_summary.url"),

    ADDRESSES("ADDRESSES","order","page.addresses.url"),

    SHIPPING("SHIPPING","order","page.shipping.url"),

    PAYMENT_METHOD("PLEASE CHOOSE YOUR PAYMENT METHOD","order","page.payment_method.url"),

    ORDER_SUMMARY("ORDER SUMMARY","module-bankwire-payment","page.order_summary.url"),

    ORDER_CONFIRMATION("ORDER CONFIRMATION","order-confirmation","page.order_confirmation.url"),

    ALL_PAGES(null,null,null),
    ;

    private String headingText;
    private String bodyId;
    private String url;

    Page(String headingText, String bodyId, String url) {
        this.headingText = headingText;
        this.bodyId = bodyId;
        this.url = url;
    }

    public String getHeadingText() {
        return headingText;
    }

    public String getBodyId() {
        return bodyId;
    }

    public String getUrl() {
        String temp = new LoadProperties("application.properties").getPropValue(url);
        switch (this){
            case START_PAGE:
            case AUTHENTICATION:
                return temp;
            case DRESSES:
            case WOMEN:
            case TSHIRTS:
                    return temp.replace("CATEGORY_NUMBER",MenuTab.valueOf(this.name()).getCategoryNumber());
            case MY_ACCOUNT:
            case SHOPPING_CART_SUMMARY:
            case ACCOUNT_CREATION:
                return null;
            default:
                return null;
        }
    }

    public String getUrl(String email) {
        String temp = new LoadProperties("application.properties").getPropValue(url);
        switch (this){
            case START_PAGE:
            case AUTHENTICATION:
                return temp;
            case ACCOUNT_CREATION:
                return temp.replace("EMAIL",email);
            default:
                return null;
        }
    }

    public String getUrl(User user) {
        String temp = new LoadProperties("application.properties").getPropValue(url);
        switch (this){
            case START_PAGE:
            case AUTHENTICATION:
                return temp;
            case ACCOUNT_CREATION:
                return temp.replace("EMAIL",user.username);
            case MY_ACCOUNT:
            case SHOPPING_CART_SUMMARY:
                return temp.replace("EMAIL&PASSWORD",user.username+"&passwd="+user.password);
            default:
                return null;
        }
    }
}
