Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @Edit @GradeLevel
  Scenario: Edit a Grade Levels
    When Click on the element in the Dialog
      | editButton |
    And User sending the keys in Dialog content
      | nameInput | Junior Level B2 |
      | shortName | JLB2            |
      | order     | 29               |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed