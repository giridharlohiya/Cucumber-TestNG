package stepdefs;

import Pages.HomePage;
import Pages.SignUpPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import Factory.DriverFactory;

public class SignUpSteps {

    SignUpPage signUp = new SignUpPage(DriverFactory.getDriver());
    HomePage homepage = new HomePage(DriverFactory.getDriver());

//1st Scenario: Create a new account successfully
    @Given("the user is on the Magento homepage")
    public void userOnMagentoHomepage() {
        homepage.navigateToHomePage();
    }
    @When("the user clicks {string}")
    public void userClicksInSignUpPage(String button) {
        signUp.clickButtonInSignUp(button);
    }
    @And("the user enters valid details")
    public void enterAccountDetails() {
        signUp.EnterAccCreationDetails("Qwertyu1","Qwertyu1","newemaln2@gmai.com");
    }
    @And("clicks {string}")
    public void clickCreateAccount(String button) {
        signUp.clickButtonInSignUp(button);
    }
    @Then("the account should be created successfully")
    public void accountCreatedSuccessfully() {
        Assert.assertTrue(signUp.AccCreatedSuccessMsg(),"Account creation Failed.");
    }

//2nd Scenario: Create account with existing email
	@And("enters details with the existing email")
    public void enterDetailsWithExistingEmail() {
        signUp.EnterAccCreationDetails("Qwertyu1","Qwertyu1","newemaln2@gmai.com");
    }
    @Then("validate existing email error message")
    public void verifyErrorMessage() {
        Assert.assertTrue(signUp.ExistingEmailValidationMsg(), "existing email Validation Failed.");
    }

//3rd Scenario: Validate mandatory fields	
    @Then("all fields should show validation error")
    public void allFieldsShowValidation() {
        Assert.assertTrue(signUp.areAllFieldErrorsShown(), "All Field Validation Failed.");
    }

//4th Scenario: Validate password mismatch
    @When("the user enters mismatched password and confirm password")
    public void enterMismatchedPasswords() {
        signUp.EnterAccCreationDetails("Qwertyu1", "Qwertyu2","otheremail@gmai.com");
    }

	@Then("validate same password error message")
	public void validateSamePasswordErrorMessage() {
		Assert.assertTrue(signUp.isPasswordMismatchErrorDisplayed(), "Password mismatch error Validation Failed.");
	}
//5th Scenario: Validate weak password
	@When("the user enters a weak password {string}")
	public void enterWeakPassword(String password) {
		signUp.enterWeakPassword(password);
	}
	@Then("validate password error message {string}")
	public void validateWeakPasswordErrorMessage(String expectedMsg) {
        String actualMsg = signUp.WeakPwdMsgDisplayed();
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim());
	}
//6th Scenario: Validate email format
    @When("the user enters invalid email {string}")
    public void enterInvalidEmail(String email) {
        signUp.enterEmail(email);
    }
    @Then("validate email error message {string}")
    public void verifyEmailError(String expectedMsg) {
        String actualMsg = signUp.getEmailErrorMessage();
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim());
    }

}
