package Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.ElementUtil;

public class SignUpPage 
{
    private ElementUtil utility;
 	private WebDriver driver;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.utility = new ElementUtil(driver);

    }	
//Locators
    private By fname_ID = By.id("firstname");
    private By lname_ID = By.id("lastname");
    private By email_Id = By.id("email_address");
    private By pwd_Id = By.id("password");
    private By cpwd_Id = By.name("password_confirmation");
    private By CreateAccLink = By.linkText("Create an Account");
    private By CreateAccButton = By.xpath("//button[@title='Create an Account']");
    private By CreateAccMsg = By.xpath("//*[contains(text(),'Create New Customer Account')]");
    private By HomePageLabel = By.xpath("//*[contains(text(),'Home Page')]");
    private By TyMsg = By.xpath("//*[contains(text(),'Thank you for registering with Main Website Store.')]");
    private By ExistingErrMsg_xp = By.xpath("//*[contains(text(),'There is already an account with this email address.')]");
    private By PwdAndCPwdMsgError_xp = By.xpath("//*[contains(text(),'Please enter the same value again.')]");
    private By weakPwdMsg = By.id("password-error");
    private By emailErrorMsg_id = By.id("email_address-error");

    private By AddPopUp_xp = By.xpath("//*[@id='card']//*[text()='Ad'])");
    private By AddCloseBtn_xp = By.xpath("//*[@class='toprow']//*[@aria-label='Close ad']");

//Methods

    
    public void clickButtonInSignUp(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "create an account":
                utility.click(CreateAccLink);
                break;
            case "create account":
                utility.click(CreateAccButton);
                break;
        }
    }

    public void EnterAccCreationDetails(String pwd, String cpwd,String emailId) {
        if(utility.isDisplayed(AddPopUp_xp)) {
            utility.click(AddCloseBtn_xp);
        }
        String randomName = utility.generateRandomString(5);
        utility.sendKeys(fname_ID, randomName);
        utility.sendKeys(lname_ID, randomName);
        utility.sendKeys(email_Id, emailId);
        utility.sendKeys(pwd_Id, pwd);
        utility.sendKeys(cpwd_Id, cpwd);
    }    

    public boolean AccCreatedSuccessMsg() {
        return utility.isDisplayed(TyMsg);
    }

    public boolean ExistingEmailValidationMsg() {
        return utility.isDisplayed(ExistingErrMsg_xp);
    }

    public boolean areAllFieldErrorsShown(){
        List<String> errorTexts = driver.findElements(By.xpath("//*[text()='This is a required field.']"))
            .stream()
            .map(e -> e.getText().trim())
            .collect(Collectors.toList());

        boolean areAllErrorsSame = errorTexts.stream()
            .allMatch(text -> text.equals("This is a required field."));
        return areAllErrorsSame;
    }
    
    public boolean isPasswordMismatchErrorDisplayed() {
        return utility.isDisplayed(PwdAndCPwdMsgError_xp);
    }

    public void enterWeakPassword(String password) {
        utility.sendKeys(pwd_Id, password);
        utility.sendKeys(cpwd_Id, password);    
    }

    public String WeakPwdMsgDisplayed() {
        return utility.getText(weakPwdMsg);
    }
    
    public void enterEmail(String email) {
    utility.sendKeys(email_Id,email);
    }

    public String getEmailErrorMessage() {
         return utility.getText(emailErrorMsg_id);
    }


}
