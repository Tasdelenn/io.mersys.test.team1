Feature: Nationalities Functionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

  @Regression @CreateNationalities
  Scenario: Create a Discounts
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Turkish |
    # And click Anywhere
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed


  @Negative @CreateNationalities
  Scenario: Create again the same name Nationalities
    When Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Turkish |
    And Click on the element in the Dialog
      | saveButton |
    Then Already Exist message should be displayed

