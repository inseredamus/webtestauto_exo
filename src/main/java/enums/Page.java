package enums;

public enum Page {
    //css  :#page h1 -> text (1)
    //css  :body[class*=lang] -> id

    //after open the url value of : automation.practice.url
    START_PAGE("Automation Practice Website","index"), //the first h1 is Automation Practice Website

    //after clicking on 'sign in'
    ACCOUNT_CREATION("Create an account","authentication"), //there is only one h1

    //after clicking on 'create an account'
    MY_ACCOUNT("My account","my-account"), //there is onliy one h1

    ALL_PAGES("",""),
    ;

    private String headingText;
    private String bodyId;

    Page(String headingText, String bodyId) {
        this.headingText = headingText;
        this.bodyId = bodyId;
    }

    public String getHeadingText() {
        return headingText;
    }

    public String getBodyId() {
        return bodyId;
    }
}
