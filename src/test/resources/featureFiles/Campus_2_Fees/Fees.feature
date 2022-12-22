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

    Scenario: Add a exist fee name
      Then User add a new fee
      And Success message should be displayed

      Then User add a exist fee name
      And Already Exist message should be displayed
      And Close the dialog content and Delete fee
      And Success message should be displayed

    Scenario: Search and delete an unavailable fee
      Then The user search and delete an unavaible fee
      And Verify that there is no data to display



