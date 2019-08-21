Feature: Sign Up
  User needs to fill in the forms on 2 different activities:
    1. Registration information page
    2. Security information page

  @SignUp
  Scenario: Successful Sign up
    Given I am on Sign Up activity
    When I fill all Sign up fields
    Then I am registered