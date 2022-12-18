Feature: Grade Level Fuctionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
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