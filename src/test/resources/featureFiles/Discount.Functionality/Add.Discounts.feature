Feature: Discounts Functionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | discounts  |

  @Regression @CreateDiscounts
  Scenario: Create a Discounts
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | description1    | ogguzhan |
      | codeintegration | 77       |
      | priorityCode    | 44       |
    And Click on the element in the Dialog
      | active |
      | active |
    # And click Anywhere
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed


  @Negative @CreateDiscounts
  Scenario: Create again the same name Discounts
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | description1    | ogguzhan |
      | codeintegration | 77       |
      | priorityCode    | 44       |
    And Click on the element in the Dialog
      | active |
    And Click on the element in the Dialog
      | saveButton |
    Then Already Exist message should be displayed

