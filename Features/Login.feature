Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario Outline: Login as a authenticated user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then success message is displayed
    Examples:
      | username           | password  |
      | "yssnmed@gmail.com" | "Yassin123_" |

  Scenario Outline: Login as an unauthorized user
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then error message is displayed
    Examples:
      | username           | password  |
      | "wronguser@mail.com" | "badpass"    |

  Scenario Outline: Login with invalid email format
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then email error message is displayed
    Examples:
      | username           | password  |
      | "yssnmedgmail.com" | "Yassin123_" |
#
  Scenario Outline: Login with blank email
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then email required message is displayed
    Examples:
      | username           | password  |
      | "" | "Yassin123_" |
#
  Scenario Outline: Login with blank password
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then password required message is displayed
    Examples:
      | username           | password  |
      | "yssnmedgmail.com" | "" |

  Scenario Outline: Login with blank email and blank password
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then email required message is displayed
    And password required message is displayed
    Examples:
      | username           | password  |
      | "" | "" |