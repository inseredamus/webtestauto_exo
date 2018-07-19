package utils;


import org.openqa.selenium.By;

public class ObjectMap {
    /**
     * @param logicalElementName : a String generally comes from a file : ui_elements.properties with the format : org.test.checkout.submit.button
     * @return By Element in the format : driver.findElement(By element).click()
     * @throws Exception
     */

    public static By getLocator(String logicalElementName) {
        LoadProperties lp = new LoadProperties("ui_elements.properties");
        String locator = lp.getPropValue(logicalElementName);
        String locatorType = locator.split("->")[0].toLowerCase();
        String locatorValue = locator.split("->")[1].toLowerCase();
        switch(locatorType) {
            case "id" : return By.id(locatorValue);
            case "name" : return By.name(locatorValue);
            case "classname" :
            case "class" : return By.className(locatorValue);
            case "linktext" :
            case "link" : return By.linkText(locatorValue);
            case "css" :
            case "cssselector" : return By.cssSelector(locatorValue);
            case "xpath" : return By.xpath(locatorValue);
            default:
                try {
                    throw new Exception("Locator type '" + locatorType + "' not defined!!");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
        }
    }
}
