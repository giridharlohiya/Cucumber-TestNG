package stepdefs;

import java.util.List;

import org.testng.Assert;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

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
		loginpage.loginWithCredentials("newemaln2@gmai.com","Qwertyu1");
	}
	@Then("User should be navigated to the home page")
	public void user_should_verify_home_page() {
		Assert.assertTrue(loginpage.isHomePageDisplayed(), "Valid Credentials Login Failed!");
		System.out.println("Valid Credentials Login successfull");
	}

	@When("User enters Invalid email and Valid password")
	public void User_Login_With_Invalid_Email() {
		loginpage.loginWithCredentials("nedfdfdfaln2@gmai.com","Qwertyu1");	
	}	
	@Then("User validates Invalid error message")
	public void validates_Invalid_email_error_message() {
		Assert.assertTrue(loginpage.LoginErrMsgDisplayed(), "Invalid Email/Pwd Validation Failed!");
		System.out.println("Invalid Email/Pwd Validation successfull");
	}

	@When("User enters Valid email and Invalid password")
	public void User_Login_With_Invalid_password() {
		loginpage.loginWithCredentials("newemaln2@gmai.com","abc");	
	}	

	@Then("all fields should show validation error In LoginPage")
    public void allFieldsShowValidationOnLogin() {
        Assert.assertTrue(loginpage.areAllFieldErrorsShownOnLoginPage(), "All Field Validation Failed.");
    }

	@Then("the user enter emailId {string}")
    public void enteremailIdInForgotPwd(String email) {
        loginpage.enteremailIdInForgotPwd(email);
    }

	@Then("validate forgot password success message")
    public void VaidateForgotPwdSuccessMsg() {
        Assert.assertTrue(loginpage.VaidateForgotPwdSuccessMsg());
    }

	@When("User calls Get User API")
    public void GetUsersAPI() {
		Response res = loginpage.GetUsersAPI();
		Assert.assertEquals(res.getStatusCode(), 200, "Expected status code 200");
		
		List<String> fnames = res.jsonPath().getList("data.first_name");
		Assert.assertTrue(fnames.contains("George"));
	}
}

