Feature: Human Resources Attestations

  Background:
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | humanResources |
      | hrSetup        |
      | attestations   |

  @Regression @HumanResourcesTest
  Scenario: Create a Attestations
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Mehmet Ali Onay |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed

  @Regression @HumanResourcesTest
  Scenario: Edit a Attestations
    When User sending the keys in Dialog content
      | searchInput | Mehmet Ali Onay |
    And Click on the element in the Dialog
      | searchButton |
    And Click on the element in the Dialog
      | editButton3 |
    And User sending the keys in Dialog content
      | nameInput | Veli Onay |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed

  @Regression @HumanResourcesTest
  Scenario: Delete a Attestations
    When The user search and delete the item from Dialog Page
      | Veli Onay |
    Then Success message should be displayed