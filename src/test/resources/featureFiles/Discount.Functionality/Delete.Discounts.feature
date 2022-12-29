Feature: Discounts Functionality

  Background:
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | discounts  |

  @Regression @DeleteDiscounts
  Scenario: Delete a Discounts
    When User delete the edited item
    Then Success message should be displayed