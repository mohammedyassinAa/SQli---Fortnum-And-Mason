Feature: Login Feature
  Verify the login Feature

#  happy path
  Scenario Outline: Login as a authenticated user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then success message is displayed
    Examples:
      | username           | password  |
      | "yssnmed@gmail.com" | "Yassin123_" |

#    unhappy path
  Scenario Outline: Login as an Unauthorised user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then error message is displayed
    Examples:
      | username           | password  |
      | "yssnmed@gmail.com" | "Yassin123" |

#    empty username
  Scenario Outline: Login with empty username
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then email error message is displayed
    Examples:
      | username | password      |
      | ""       | "Yassin123_"  |

