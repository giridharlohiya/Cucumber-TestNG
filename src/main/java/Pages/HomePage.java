package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Utility.ConfigReader;


public class HomePage 
{
    WebDriver driver;
    Properties prop;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }	

    public void navigateToHomePage() {
        driver.get(prop.getProperty("magentourl"));
      }
    
}
