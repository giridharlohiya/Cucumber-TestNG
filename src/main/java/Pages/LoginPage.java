package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.ElementUtil;

public class LoginPage 
{
    private ElementUtil utility;
 	private WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utility = new ElementUtil(driver);

    }	
//Locators
    By Email_ID = By.id("user-name");
    By Password_ID = By.id("password");
    By LoginButton_ID = By.id("login-button");
    By ProductsTextOnHomePage = By.cssSelector(".title");
    By LoginErrMsg = By.xpath("//*[contains(text(),'Username and password do not match')]");

    
//Methods
    public boolean Enter_URL() {
        driver.get("https://www.saucedemo.com");
        return driver.findElement(Email_ID).isDisplayed();
        // System.out.println(EmailVisible ? "URL Launch Success" : "URL Launch Fail");
        //     return EmailVisible;	
    }
    
   	public void Login(String email, String password) {
        utility.sendKeys(Email_ID, email);
        utility.sendKeys(Password_ID, password);
    }    

	public boolean loginWithValidCredentials() {
        Login("standard_user","secret_sauce");
        utility.click(LoginButton_ID);
        return isHomePageDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return utility.isDisplayed(ProductsTextOnHomePage);
    }

    public boolean loginWithInValidEmail() {
        Login("abc","secret_sauce");
        utility.click(LoginButton_ID);
        return utility.isDisplayed(LoginErrMsg);

    }
     public boolean loginWithInValidPassword() {
        Login("standard_user","abc");
        utility.click(LoginButton_ID);
        return utility.isDisplayed(LoginErrMsg);
    }
}
