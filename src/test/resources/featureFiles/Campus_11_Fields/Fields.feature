Feature: Fields under Setup-Parameters Functionality

  Background:
    And Navigate to fields page

  Scenario: Add, Edit and Delete Fields
    Then User add a new field
    And Success message should be displayed

    Then User edit field
    And Success message should be displayed

    Then User delete field
    And Success message should be displayed

  Scenario: Add a exist field name
    Then User add a new field
    And Success message should be displayed

    Then User add a exist field name
    And Already Exist message should be displayed
    And Click on close button
    And The user search and delete the item from Dialog Page "Alan121"
    And Success message should be displayed

  Scenario: Search and delete an unavailable field
    Then The user search and delete an unavaible field
    And Verify that there is no data to display



