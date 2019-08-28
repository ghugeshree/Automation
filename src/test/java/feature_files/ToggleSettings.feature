Feature: Toggle

  Scenario: I toggle settings
    Given I am a registered user
    And I enter my credentials
    And I am logged in to my account
    When I click on Profile tab
    And I am on setting page
    When I click on toggle button
    Then I close application