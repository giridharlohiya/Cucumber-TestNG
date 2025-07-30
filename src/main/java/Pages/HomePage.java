package Pages;

import org.openqa.selenium.WebDriver;


public class HomePage 
{
 	private WebDriver driver;
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }	
//Locators
//Methods

    public void navigateToHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
      }
    
}
