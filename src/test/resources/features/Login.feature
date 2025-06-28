
Feature: Login Page Cases

  Scenario: Login Validate Credentials
    Given User Is On The Login Page
    When User enters valid email and password
    Then User should be navigated to the home page

  