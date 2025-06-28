package stepdefs;

import org.testng.Assert;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDef{
	
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("User Is On The Login Page")
	public void User_Is_On_The_Login_Page() {
		loginpage.Enter_URL();
	}
	
	@When("User enters valid email and password")
	public void user_enters_valid_email_and_password() {
		loginpage.loginWithValidCredentials();
	}

	@Then("User should be navigated to the home page")
	public void user_should_verify_home_page() {
    Assert.assertTrue(loginpage.isHomePageDisplayed(), "Home page not displayed!");
}
}
