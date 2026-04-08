Feature: Login Feature
  Verify the login Feature

#  happy path
  Scenario Outline: Login as a authenticated user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username>
    And user fill password <password>
    Then success message is displayed
    Examples:
      | username           | password  |
      | "yssnmed@gmail.com" | "Yassin123_" |

#    unhappy path
  Scenario Outline: Login as an Unauthorised user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username>
    And user fill password <password>
    Then error message is displayed
    Examples:
      | username           | password  |
      | "yssnmed@gmail.com" | "Yassin123" |

#    invalid username/email format
  Scenario Outline: Login with invalid username format
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username>
    Then email error message is displayed
    Examples:
      | username |
      | "yssnmedgmail.com"       |

#    empty username
    Scenario Outline: Login with empty username
      Given user is on homepage
      And user navigates to Login Page
      When user fill username <username>
      Then email error message is displayed
      Examples:
        | username |
        | ""       |

#    empty password
    Scenario Outline: Login with empty password
      Given user is on homepage
      And user navigates to Login Page
      When user fill username <username>
      And user fill password <password>
      Then password error message is displayed
      Examples:
        | username            | password |
        | "yssnmed@gmail.com" |   ""     |