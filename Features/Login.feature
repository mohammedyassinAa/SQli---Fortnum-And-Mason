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
#      | "yssnm@gmail.com" | "Yassin1_" |
