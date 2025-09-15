package Pages;

import org.openqa.selenium.WebDriver;

import Utility.ConfigReader;


public class HomePage 
{
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }	

    public void navigateToHomePage() {
        driver.get(ConfigReader.get("magentourl"));
      }
    
}
