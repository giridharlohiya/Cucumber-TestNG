package stepdefs;

import org.testng.Assert;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDef{
	
    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	HomePage homepage = new HomePage(DriverFactory.getDriver());

	// @Given("the user is on the Magento homepage")
    // public void userOnMagentoHomepage() {
    //     homepage.navigateToHomePage();
    // }
    @When("the user clicks {string} On Home Page")
    public void userClickInLoginPage(String button) {
        loginpage.clickButtonnLoginPage(button);
    }
	
	@When("User enters valid email and password")
	public void user_enters_valid_email_and_password() {
		Assert.assertTrue(loginpage.loginWithValidCredentials(), "Login failed!");
		System.out.println("Login successful with valid credentials");
	}
	@Then("User should be navigated to the home page")
	public void user_should_verify_home_page() {
		Assert.assertTrue(loginpage.isHomePageDisplayed(), "Home page not displayed!");
		System.out.println("Home page displayed successfully");
	}

	@When("User enters Invalid email and Valid password")
	public void User_enters_Invalid_email_and_Valid_password() {
		Assert.assertTrue(loginpage.loginWithInValidEmail(), "Invalid email failed!");
		System.out.println("Invalid email Validated successfully");
	}	

	@When("User enters Valid email and Invalid password")
	public void User_enters_valid_email_and_Invalid_password() {
		Assert.assertTrue(loginpage.loginWithInValidPassword(), "Invalid email failed!");
		System.out.println("Invalid email Validated successfully");
	}	

	@Then("all fields should show validation error In LoginPage")
    public void allFieldsShowValidationOnLogin() {
        Assert.assertTrue(loginpage.areAllFieldErrorsShownOnLoginPage(), "All Field Validation Failed.");
    }

	@Then("the user enter emailId {string}")
    public void enteremailIdInForgotPwd(String email) {
        loginpage.enteremailIdInForgotPwd(email);
    }

	@Then("validate success message")
    public void VaidateSuccessMsg() {
        Assert.assertTrue(loginpage.VaidateForgotPwdSuccessMsg());
    }
}

