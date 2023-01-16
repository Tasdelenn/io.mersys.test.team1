Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @Delete @GradeLevel
  Scenario: Delete a Grade Levels
    When User delete the edited item
    Then Success message should be displayed