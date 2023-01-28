Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @GradeLevel @CreateGradeLevel
  Scenario: Create a Grade Levels
    When user add Grade Levels
    Then Success message should be displayed

  @Regression @GradeLevel @EditGradeLevel
  Scenario: Edit the Grade Levels
    When Sort elements by created time
    And Click on the element in the Dialog
      | editButton |
    And User sending the keys in Dialog content
      | nameInput | TS Batch 20 Team1 |
      | shortName | B20 T1            |
      | order     | 97                |
    And Click on the element in the Dialog content
      | active     |
      | saveButton |
    Then Success message should be displayed

  @Regression @GradeLevel @DeleteGradeLevel
  Scenario: Delete the Grade Levels
    When Sort elements by created time
    And Click on the element in the Dialog
      | deleteButton |
    And Click on the element in the Dialog content
      | deleteDialogBtn |
    Then Success message should be displayed