Feature: State Multi delete Scenario

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to State page

  @Negative
  Scenario: Delete4) User should not be able to delete the Country with States
    When Create a new country name as "Memleket" code as "MK" from New State window
    And Success message should be displayed
    And Create a new State name as"Yeniyer" short name as"YY" from "Memleket"
    And Success message should be displayed
    Then Navigate to country page and delete the Country name as"Memleket"
    And  User Should not be able to delete successfully

  Scenario: Delete5) User should be able to delete State then delete the country
    When Select new created Country and new Created State name as "Yeniyer" delete them
    And Success message should be displayed
    Then Navigate to country page and delete the Country name as"Memleket"
    And  Success message should be displayed

  @Negative
  Scenario: Delete6) User should not be able to delete State from the Country which used by City
    When Create a new country name as "ABALOSSAN" code as "AL" from New State window
    And Success message should be displayed
    Then Create a new State name as"Abavila" short name as"AB" from "ABALOSSAN"
    And Success message should be displayed
    And Navigate to Cities page and create a new City named "Vila" frome Country "ABALOSSAN" State "Abavila"
    And Success message should be displayed
    And Navigate to State page and delete the state "Abavila"
    And  User Should not be able to delete successfully


  Scenario: User should be able to delete City and delete State then delete Country successfully
    When Navigate to Cities page and delete city "Vila"
    And Success message should be displayed
    Then Navigate to State page and delete the state "Abavila"
    And Success message should be displayed
    Then Navigate to country page and delete the Country name as"ABALOSSAN"