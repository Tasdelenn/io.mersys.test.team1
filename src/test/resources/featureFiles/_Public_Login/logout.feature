Feature: Logout Functionality

  @SmokeTest @Regression
  Scenario: Logut of the Mersys Campus
    When User click account button
    And User click to sign out button
    Then User should be logout successfuly