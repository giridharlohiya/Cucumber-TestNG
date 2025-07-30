package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

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

    public String generateRandomString(int length) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

    public String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString() + "@testmail.com";
    }

}
