Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @Delete @GradeLevel
  Scenario: Delete last created Grade Levels
    When Sort elements by created time
    And Click on the element in the Dialog
      | deleteButton |
    And Click on the element in the Dialog content
      | deleteDialogBtn |
    Then Success message should be displayed

  @Regression @Delete @GradeLevel
  Scenario: Delete again the which last created Grade Levels
    When Sort elements by created time
    And Click on the element in the Dialog
      | deleteButton |
    And Click on the element in the Dialog content
      | deleteDialogBtn |
    Then Success message should be displayed