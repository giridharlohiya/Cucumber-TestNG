
Feature: Login Page Cases

  Scenario: Login With Validate Credentials
    Given the user is on the Magento homepage
    And the user clicks 'Sign In Link' On Home Page
    When User enters valid email and password
    Then User should be navigated to the home page

  Scenario: Login With InValidate email
    Given the user is on the Magento homepage
    And the user clicks 'Sign In Link' On Home Page
    When User enters Invalid email and Valid password
    Then User validates Invalid error message

  Scenario: Login With InValidate password
    Given the user is on the Magento homepage
    And the user clicks 'Sign In Link' On Home Page
    When User enters Valid email and Invalid password
    Then User validates Invalid error message

  Scenario: Login With with blank fields
    Given the user is on the Magento homepage
    And the user clicks 'Sign In Link' On Home Page
    And the user clicks 'Sign In Button' On Home Page
    Then all fields should show validation error In LoginPage

 Scenario: Validate Forgot Password link
    Given the user is on the Magento homepage
    And the user clicks 'Sign In Link' On Home Page
    And the user clicks 'Forgot Your Password?' On Home Page
    And the user enter emailId "newemaln2@gmai.com"
    And the user clicks 'Reset My Password' On Home Page
    Then validate forgot password success message 

Scenario: Validate Get User API
    Given User calls Get User API
