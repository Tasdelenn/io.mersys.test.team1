Feature: Fees under Setup-Parameters Functionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to fees page

  Scenario: Add, Edit and Delete Fees

    Then User add a new fee
    And Success message should be displayed

    Then User edit fee
    And Success message should be displayed

    Then User delete fee
    And Success message should be displayed


