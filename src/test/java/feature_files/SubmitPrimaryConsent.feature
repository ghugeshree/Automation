Feature: User completes the self-declaration(Primary consent) form before using
  All of Us application.

  @LogoutFromConsent
  Scenario: Logout from consent
    Given I am a registered user
    And   I am on Log in page
    When  I enter my credentials
    Then  I am logged in to my account
    And   I logout from my account before submitting consent

  @PrimaryConsent
  Scenario: Submit primary consent
    Given I am a registered user
    And   I enter my credentials
    And   I am logged in to my account
    When  I submit primary consent
    Then  I am on dashboard