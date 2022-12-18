Feature: Grade Level Fuctionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

  @Regression @DeleteGradeLevel
  Scenario: Delete a Grade Levels
    When User delete the edited item
    Then Success message should be displayed