
Feature: Login Page Cases

  Scenario: Login With Validate Credentials
    Given User Is On The Login Page
    When User enters valid email and password
    Then User should be navigated to the home page

  Scenario: Login With InValidate email
    Given User Is On The Login Page
    When User enters Invalid email and Valid password

  Scenario: Login With InValidate password
    Given User Is On The Login Page
    When User enters Valid email and Invalid password
