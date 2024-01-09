
Feature: Login Page Cases

  Scenario: Login Validate Credentials
    Given User Is On The Login Page
    When User Enter Email Password
    Then User Should verify Home Page

  