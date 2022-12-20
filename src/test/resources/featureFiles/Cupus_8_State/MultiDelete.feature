Feature: State Multi delete Scenario

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to State page
  @Negative
  Scenario: Delete4) User should not be able to delete the Country with States
    When Create a new country name as "Memleket" code as "MK" from New State window
    And Create a new State name as"Yeniyer" short name as"YY" from "Memleket"
    And Success message should be displayed
    Then Navigate to country page and delete the Country name as"Memleket"
    And  User Should not be able to delete successfully

  Scenario: Delete5) User should be able to delete State then delete the country
    When Select new created Country and new Created State name as "Yeniyer" delete them
    And Success message should be displayed
    Then Navigate to country page and delete the Country name as"Memleket"
    And  User Should not be able to delete successfully

  Scenario: Delete6) User should not be able to delete State from the Country which used by City
    When Create a new country name as "Talossan" code as "TL" from New State window
    Then Create a new State name as"Abavila" short name as"AB" from "Talossan"
    And Navigate to Cities page and create a new City named {string} frome Country {string} State {string}
    And Navigate to
