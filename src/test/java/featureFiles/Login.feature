Feature: Log in
  The user must have a registered email address
  He must be able to log in with the registered email address

  @Login
  Scenario: Login
    Given I am a registered user
    And   I am on Log in page
    When  I enter my credentials
    Then  I am logged in to my account

  @ErrorMsgCheck
  Scenario Outline: Error message for inappropriate email
    Given I am on Log in page
    When  I enter invalid "<emailAddress>" or "<password>"
    Then  Error message is displayed

    Examples:
      | emailAddress         | password   |
      | someonesomewhere.com | Qwerty123  |
      | some                 | Qsdf       |
      | someone@somewhere    | Qwerty@123 |


