Feature: User completes the self-declaration(Primary consent) form before using
  All of Us application.

  Scenario: Submit primary consent
    Given I am a registered user
    And   I enter my credentials
    And   I am logged in to my account
    When  I submit primary consent
    Then  I am able to see my dashboard