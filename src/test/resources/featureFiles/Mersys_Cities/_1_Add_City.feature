Feature: Cities add, update and delete functionality

  Background: Navigate and choose cities functionality
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | cities     |

    Scenario: add to city on Cities functionality
      When User should be click add button
      Then User should choose the country Turkey
      And User should be write a new city "MehmetMersys" name of sellected country
      Then User should be click save button
      Then User should be see successfully added message

      Scenario: update added city name
        When User should choose the country Turkey on search form
        Then user should write the name "MehmetMersys" of the city to change
        And User should click the search button and should see the city name
        And User should be click the edit button
        And User should write a new name "MehmetMersys1"
        Then User click the save button and see the successfully updated message

        Scenario: delete added and updated city of country
          When User should choose the country Turkey on search form
          Then User should write "MehmetMersys1" the city name of country
          And User should click the search button
          And User should click delete button and click the delete on confirmation button
          Then User should be see successfuly deleted message
