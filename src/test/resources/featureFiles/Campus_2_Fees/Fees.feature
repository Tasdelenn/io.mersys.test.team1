Feature: Fees under Setup-Parameters Functionality

  Background:
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
      And Click on close button
      And The user search and delete the item from Dialog Page "document8"
      And Success message should be displayed

    Scenario: Search and delete an unavailable fee
      Then The user search and delete an unavaible fee
      And Verify that there is no data to display



