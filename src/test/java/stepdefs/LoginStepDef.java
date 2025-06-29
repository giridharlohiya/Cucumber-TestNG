package stepdefs;

import org.testng.Assert;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDef{
	
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User Is On The Login Page")
	public void User_Is_On_The_Login_Page() {
		Assert.assertTrue(loginpage.Enter_URL(), "Login page not displayed!");	
		System.out.println("Login page displayed successfully");
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
}

