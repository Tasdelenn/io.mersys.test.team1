Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @CreateGradeLevel
  Scenario: Create a Grade Levels
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Senior Level |
      | shortName | SL           |
      | order     | 14           |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed

    @Negative @CreateGradeLevel
  Scenario: Create again the same name Grade Levels
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Senior Level |
      | shortName | SL           |
      | order     | 14           |
    And Click on the element in the Dialog
      | saveButton |
      Then Already Exist message should be displayed
