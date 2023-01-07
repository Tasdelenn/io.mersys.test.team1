Feature: State Multi Scenario

  Background:
    Given Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | states     |

  @Regression @State
  Scenario: Create1) Create a new State from existing Countries
    When Create a new State name as "melek sehir" short name as "mk" from existing Country "Ukraine"
    Then Success message should be displayed

  @Regression @State
  Scenario: Edit1) Update State from existing Countries
    When Edit State name as "Melek Sehri" short name as "MK" from existing Country "Ukraine"
    Then Success message should be displayed

  @Regression @State
  Scenario: Delete1) Delete new created State from existing Countries
    When Delete new State name as "Melek Sehri" from existing Country
    Then Success message should be displayed

  @State
  Scenario: Create2) Create a new Country and use the created Country to create a new State
    When Create a new country name as "Kazakyeli" code as "KY" from New State window
    And Success message should be displayed
    Then Create a new State name as"Almaty" short name as"AL" from "Kazakyeli"
    And Success message should be displayed

  @State
  Scenario: Edit2) Update the new State by create a new Country and use it
    When  Edit the State named "Almaty" by create a new country name as "Atlant", code as "AT"
    And Success message should be displayed
    Then Update State name as "Almaty1" then select country "Atlant" and save
    And Success message should be displayed

  @StateNegative
  Scenario: Edit3) create new Country but can not update the State from the created Country
    When Edit from State name as "Almaty1" and create a new country name as "Kazak Yeli" code as "KY" without state
    And Success message should be displayed
    Then The created Country not found and the state was not successfully updated

  @State
  Scenario: Delete the Country without State
    And Navigate to country page and delete the Country name as"Kazak Yeli"

  @StateNegative
  Scenario: Create3) Create a new Country but can not create a new State from the created Country
    When Create a new country name as "Jana Khazak" code "JK" without state from New State window
    And Success message should be displayed
    Then The created Country not found and new state was not successfully created

  @State
  Scenario: Delete the Country2 without State
    And Navigate to country page and delete the Country name as"Jana Khazak"

  @State
  Scenario: Delete2) Delete new created State from the new created Country
    When Select new created Country and new Created State name as "Almaty1" delete them
    Then Success message should be displayed

  @State
  Scenario: Delete3) Delete Country from dropdown menu if there is no state data
    When The Country named as "Atlant" in the dropdown menu does not have State
    And Navigate to Country page and delete the Country name as "Atlant"
    Then Success message should be displayed



