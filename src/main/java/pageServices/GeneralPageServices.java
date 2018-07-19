package pageServices;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.GeneralPage;

public class GeneralPageServices {
    private GeneralPage page;
    protected Logger logger = Logger.getLogger(GeneralPageServices.class);
    protected String location = "||||| : ";
    protected String locationSymbol = "///// : ";

    public GeneralPageServices(WebDriver driver) {
        page = new GeneralPage(driver);
    }
}
