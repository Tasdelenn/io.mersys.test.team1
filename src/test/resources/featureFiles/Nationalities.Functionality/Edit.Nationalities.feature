Feature: Nationalities Fuctionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |


  @Regression @EditNationalities
  Scenario: Edit a Nationalities
    When Click on the element in the Dialog
      | editButton |
    And User sending the keys in Dialog content
      | nameInput | English |
    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed
