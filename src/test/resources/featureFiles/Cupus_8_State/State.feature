Feature: State Multi Scenario

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to State page


    Scenario: Create1) Create a new State from existing Countries
      When Create a new State from existing Country
      Then Success message should be displayed

    Scenario: Create2) Create a new Country and use the created Country to create a new State
      When Create a new country from New State window
      And Success message should be displayed
      Then Create a new State
      And Success message should be displayed

      @Negative
    Scenario: Create3) Create a new Country but can not create a new State from the created Country
      When Create a new country without state from New State window
      And Success message should be displayed
      Then The created Country not found and new state was not successfully created

    Scenario: Edit1) Update State from existing Countries
      When Edit State from existing Country
      Then Success message should be displayed

    Scenario: Edit2) Update the new State by create a new Country and use it
      When  Edit the new State by create a new country
       And Success message should be displayed
       Then Update State and save
       And Success message should be displayed

       @Negative
    Scenario: Edit3) create new Country but can not update the State from the created Country
      When Create a new country without state from Edit State window
      And Success message should be displayed
      Then The created Country not found and the state was not successfully updated

    Scenario: Delete1) Delete new created State from existing Countries
      When Delete new State from existing Country
      Then Success message should be displayed

    Scenario: Delete2) Delete new created State from the new created Country
      When Select new created Country and new Created State delete them
      Then Success message should be displayed

    Scenario: Delete3) Delete Country from dropdown menu if there is no state data
      When The Country in the dropdown menu does not have State
      Then Navigate to country page
      And  Find and delete the Country
      And  Navigate to State page
      And  Click on dropdown menu and the Country should not be visible


