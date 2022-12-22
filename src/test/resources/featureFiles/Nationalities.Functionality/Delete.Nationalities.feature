Feature: Nationalities Functionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

  @Regression @DeleteNationalities
  Scenario: Delete a Nationalities
    When User delete the edited item
    Then Success message should be displayed