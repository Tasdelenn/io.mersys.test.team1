Feature: State Multi Scenario

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to State page


    Scenario: Create1) Create a new State from existing Countries
      When Create a new State name as "melek sehir" short name as "mk" from existing Country
      Then Success message should be displayed

    Scenario: Create2) Create a new Country and use the created Country to create a new State
      When Create a new country name as "Kazakyeli" code as "KY" from New State window
      And Success message should be displayed
      Then Create a new State name as"Almaty" short name as"AL"
      And Success message should be displayed

      @Negative
    Scenario: Create3) Create a new Country but can not create a new State from the created Country
      When Create a new country name as "Jana Khazak" code "JK" without state from New State window
      And Success message should be displayed
      Then The created Country not found and new state was not successfully created

    Scenario: Edit1) Update State from existing Countries
      When Edit State name as "Melek Sehri" short name as "MK" from existing Country
      Then Success message should be displayed

    Scenario: Edit2) Update the new State by create a new Country and use it
      When  Edit the new State by create a new country name as "Atlant", code as "AT"
       And Success message should be displayed
       Then Update State and save
       And Success message should be displayed

       @Negative
    Scenario: Edit3) create new Country but can not update the State from the created Country
      When Create a new country name as "Kazak Yeli" code as "KY" without state from Edit State window
      And Success message should be displayed
      Then The created Country not found and the state was not successfully updated

    Scenario: Delete1) Delete new created State from existing Countries
      When Delete new State name as "Melek Sehri" from existing Country
      Then Success message should be displayed

    Scenario: Delete2) Delete new created State from the new created Country
      When Select new created Country and new Created State name as "Almaty1" delete them
      Then Success message should be displayed

    Scenario: Delete3) Delete Country from dropdown menu if there is no state data
      When The Country in the dropdown menu does not have State
      Then Navigate to country page
      And  Find and delete the Country name as "Atlant"
      And  Navigate to State page
      And  Click on dropdown menu and the Country name as "Atlant" should not be visible


