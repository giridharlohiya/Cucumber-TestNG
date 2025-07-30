package Pages;

import java.util.List;
import java.util.stream.Collectors;

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
    By SignInLink_Link = By.linkText("Sign In");
    By SignInBtn_ID = By.xpath("//button[@class='action login primary']//span");
    By Email_ID = By.id("email");
    By Password_ID = By.id("pass");
    By HomePageLabel_cl = By.className("base");
    By LoginErrMsg = By.xpath("//*[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily')]");
    By ForgotYourPwdLink_cl = By.className("//*[contains(text(),'Forgot Your Password?')]");
    By ResetPwdBBtn_cl = By.className("action submit primary");
    By ForgotPwdSuccessMsg = By.xpath("//*[contains(text(),'If there is an account associated with')]");

    
//Methods
   public void clickButtonnLoginPage(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "sign in link":
                utility.click(SignInLink_Link);
                break;
            case "sign in button":
                utility.click(SignInBtn_ID);
                break;    
             case "forgot your password?":
                utility.click(ForgotYourPwdLink_cl);
                break;        
            case "reset my password":
                utility.click(ResetPwdBBtn_cl);
                break; 
        }
    }
    
   	public void Login(String email, String password) {
        utility.sendKeys(Email_ID, email);
        utility.sendKeys(Password_ID, password);
    }    

	public boolean loginWithValidCredentials() {
        Login("newemaln2@gmai.com","Qwertyu1");
        utility.click(SignInBtn_ID);
        return isHomePageDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return utility.isDisplayed(HomePageLabel_cl);
    }

    public boolean loginWithInValidEmail() {
        Login("nedfdfdfaln2@gmai.com","Qwertyu1");
        utility.click(SignInBtn_ID);
        return utility.isDisplayed(LoginErrMsg);

    }
     public boolean loginWithInValidPassword() {
        Login("newemaln2@gmai.com","abc");
        utility.click(SignInBtn_ID);
        return utility.isDisplayed(LoginErrMsg);
    }

    public boolean areAllFieldErrorsShownOnLoginPage(){
        List<String> errorTexts = driver.findElements(By.xpath("//*[text()='This is a required field.']"))
            .stream()
            .map(e -> e.getText().trim())
            .collect(Collectors.toList());

        boolean areAllErrorsSame = errorTexts.stream()
            .allMatch(text -> text.equals("This is a required field."));
        return areAllErrorsSame;
    }

    public void enteremailIdInForgotPwd(String email) {
        utility.sendKeys(Email_ID, email);
    }

    public boolean VaidateForgotPwdSuccessMsg() {
        return utility.isDisplayed(ForgotPwdSuccessMsg);
    }
}
