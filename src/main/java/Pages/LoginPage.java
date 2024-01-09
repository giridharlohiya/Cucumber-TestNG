package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;

	public class LoginPage 
	{
	
	private WebDriver driver;
	DriverFactory driverFactory = new DriverFactory();

	//Constructor
	public LoginPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
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
    	if(EmailVisible){
		System.out.println("URL Launch Success");
    	return true;
		}
    	else
    	System.out.println("URL Launch Fail");
    	return false;	
    }
    
    public boolean User_Login() {
    	driver.findElement(Email_ID).sendKeys("standard_user");
    	driver.findElement(Password_ID).sendKeys("secret_sauce");
    	driver.findElement(LoginButton_ID).click();
    	return driver.findElement(ProductsTextOnHomePage).isDisplayed();
    }
	
}
