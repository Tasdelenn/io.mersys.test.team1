Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @Create @GradeLevel
  Scenario: Create a Grade Levels
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Senior Level A2 |
      | shortName | SLA2            |
      | order     | 37              |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed

    @Negative @Create @GradeLevel
  Scenario: Create again the same name Grade Levels
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Senior Level A2 |
      | shortName | SLA2            |
      | order     | 23              |
      And Click on the element in the Dialog
      | saveButton |
      Then Already Exist message should be displayed
