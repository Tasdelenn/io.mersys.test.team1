Feature: Discounts Fuctionality

  Background:
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | discounts  |

  @Regression @EditDiscounts
  Scenario: Edit a Discounts
    When Click on the element in the Dialog
      | editButton |
    And User sending the keys in Dialog content
      | description1    | semanurr |
      | codeintegration | 44       |
      | priorityCode    | 88       |
    And Click on the element in the Dialog
      | active |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed