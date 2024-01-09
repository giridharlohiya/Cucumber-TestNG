package stepdefs;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDef{
	
    private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("User Is On The Login Page")
	public void User_Is_On_The_Login_Page() {
		loginpage.Enter_URL();
	}
	
	@When("User Enter Email Password")
	public void User_Enter_Email_Password() {
		loginpage.User_Login();
	}

	@Then("User Should verify Home Page")
	public void User_Should_verify_Home_Page() {
		System.out.println("Logged Out");
	}
}
