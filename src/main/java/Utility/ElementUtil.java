package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private WebDriver driver;

    // Constructor
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Click
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Send keys
    public void sendKeys(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    // Get text
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Is displayed
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get attribute
    public String getAttribute(By locator, String attributeName) {
        return driver.findElement(locator).getAttribute(attributeName);
    }
}
