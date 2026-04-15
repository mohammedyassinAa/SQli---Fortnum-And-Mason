Feature: SignIn Feature
  Verify the login Feature

#  Happy path
  Scenario Outline:  Create Successful Account
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all required fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
#    Then account is created successfully

    Examples:
      | email                   | firstName                 | lastName            |  password         | repeatPassword   |
      | "yssnmedtest@gmail.com" | "Mohammed Yassine"    | "Aoulad ahriz"      | "StrongPass123!"  | "StrongPass123!"   |

  # Happy Path
#  Scenario: Successful account creation
#    Given user is on the Create Account page
#    When user fills in all required fields with valid values
#      | Email           | yssnmed+test@gmail.com |
#      | First Name      | Yassin                 |
#      | Last Name       | Med                    |
#      | Password        | StrongPass123!         |
#      | Repeat Password | StrongPass123!         |
#    And user submits the form
#    Then account is created successfully

#  # All fields missing (full empty form)
#  Scenario: All required fields missing
#    Given user is on the Create Account page
#    When user leaves all required fields empty
#    And user submits the form
#    Then "Field is required." error is shown for each required field

  # All other negative and validation/error paths as parameterized outline
#  Scenario Outline: Create Account validation and error cases
#    Given user is on the Create Account page
#    When user fills the fields as follows:
#      | Email           | <email>      |
#      | First Name      | <firstName>  |
#      | Last Name       | <lastName>   |
#      | Password        | <password>   |
#      | Repeat Password | <repeatPwd>  |
#    And user submits the form
#    Then the error message "<error>" is displayed
#
#    Examples:
#      | email                  | firstName | lastName | password        | repeatPwd        | error                       |
#      | yssnmedgmail.com       | Yassin    | Med      | StrongPass123!  | StrongPass123!   | Invalid email format        |
#      | yssnmed+test@gmail.com | Yassin    | Med      | StrongPass123!  | WrongPass321!    | Passwords do not match      |
#      | yssnmed+test@gmail.com | Yassin    | Med      | Short1!         | Short1!          | Minimum 8 characters        |
#      | existing@mail.com      | Yassin    | Med      | StrongPass123!  | StrongPass123!   | Email already exists        |
#      | yssnmed+test@gmail.com | 1234      | Med      |
#