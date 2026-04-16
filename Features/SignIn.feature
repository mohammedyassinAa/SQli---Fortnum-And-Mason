Feature: SignIn Feature
  Verify the login Feature

#  Happy path
  Scenario Outline:  Create Successful Account
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all required fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then account is created successfully
    Examples:
      | email                   | firstName                 | lastName            |  password         | repeatPassword   |
      | "yssnmedtest1@gmail.com" | "Mohammed Yassine"       | "Aoulad ahriz"      | "StrongPass123!"  | "StrongPass123!" |

#  Invalid email format
  Scenario Outline: Invalid email format
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then email error message is displayed
    Examples:
      | email                 | firstName     | lastName      |  password             | repeatPassword   |
      | "yssnmedgmail.com"    | "test"        | "test"        | "StrongPass123!"      | "StrongPass123"  |

#  Reuse existing email
  Scenario Outline: Reuse existing email
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then email error message is displayed
    Examples:
      | email                 | firstName     | lastName      |  password             | repeatPassword   |
      | "test@gmail.com"       | "test"        | "test"       | "StrongPass123!"      | "StrongPass123"  |

 # All fields missing (full empty form)
  Scenario Outline: All required fields missing
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then error message is displayed
    Examples:
      | email | firstName | lastName  |  password  | repeatPassword   |
      | ""    | ""        | ""        | ""         | ""               |

#  Passwords do not match
  Scenario Outline: Passwords do not match
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then password error message is displayed
    Examples:
      | email                 | firstName     | lastName      |  password             | repeatPassword   |
      | "yssnmed@gmail.com"    | "test"        | "test"        | "StrongPass1234!"      | "StrongPass123!"  |

#  Password too short
  Scenario Outline: Password too short
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then password error message is displayed
    Examples:
      | email                 | firstName     | lastName      |  password         | repeatPassword   |
      | "yssnmedgmail.com"    | "test"        | "test"        | "SP14!"           | "SP14!"          |


#  14	Newsletter/corporate toggle  no errors
  Scenario Outline: Check Newsletter/corporate
    Given user is on homepage
    And user navigates to SignIn Page
    When user fills in and checks Newsletter and corporate in all blank fields with valid values <email>, <firstName>, <lastName>, <password>, <repeatPassword>
    Then account is created successfully
    Examples:
      | email                   | firstName                 | lastName            |  password         | repeatPassword   |
      | "yssnmedtestNC@gmail.com" | "Mohammed Yassine"       | "Aoulad ahriz"      | "StrongPass123!"  | "StrongPass123!" |