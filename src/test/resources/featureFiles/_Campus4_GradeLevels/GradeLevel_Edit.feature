Feature: Grade Level Fuctionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @EditGradeLevel
  Scenario: Edit a Grade Levels
    When Click on the element in the Dialog
      | editButton |
    And User sending the keys in Dialog content
      | nameInput | Junior Level |
      | shortName | JL           |
      | order     | 8            |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed