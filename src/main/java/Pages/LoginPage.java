package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
 	private WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }	
//Locators
By Email_ID = By.id("user-name");
By Password_ID = By.id("password");
By LoginButton_ID = By.id("login-button");
By ProductsTextOnHomePage = By.cssSelector(".title");
    
//Methods
public boolean Enter_URL() {
	driver.get("https://www.saucedemo.com");
	boolean EmailVisible = driver.findElement(Email_ID).isDisplayed();
	System.out.println(EmailVisible ? "URL Launch Success" : "URL Launch Fail");
        return EmailVisible;	
}
    
	public boolean loginWithValidCredentials() {
        driver.findElement(Email_ID).sendKeys("standard_user");
        driver.findElement(Password_ID).sendKeys("secret_sauce");
        driver.findElement(LoginButton_ID).click();
        return isHomePageDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(ProductsTextOnHomePage).isDisplayed();
    }

}
