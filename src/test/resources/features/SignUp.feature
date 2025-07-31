Feature: Sign Up

 Scenario: Create a new account successfully
   Given the user is on the Magento homepage
   When the user clicks "Create an Account"
   And the user enters valid details
   And clicks "Create Account"
   Then the account should be created successfully

 Scenario: Create account with existing email
   Given the user is on the Magento homepage
   When the user clicks "Create an Account"
   And enters details with the existing email
   And clicks "Create Account"
   Then validate existing email error message

 Scenario: Validate mandatory fields
   Given the user is on the Magento homepage
   When the user clicks "Create an Account"
   And clicks "Create Account"
   Then all fields should show validation error

 Scenario: Validate password mismatch
   Given the user is on the Magento homepage
   When the user clicks "Create an Account"
   When the user enters mismatched password and confirm password
   And clicks "Create Account"
   Then validate same password error message

Scenario: Validate weak password
  Given the user is on the Magento homepage
  When the user clicks "Create an Account"
  And the user enters a weak password
  And clicks "Create Account"
  Then validate password error message "Minimum length of this field must be equal or greater than 8 symbols."

Scenario: Validate email format
  Given the user is on the Magento homepage
  When the user clicks "Create an Account"
  And the user enters invalid email "test.com"
  And clicks "Create Account"
  Then validate email error message "Please enter a valid email address (Ex: johndoe@domain.com)."
