Feature:  Citizenship Functionality

  Background:
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne    |
      | parameters  |
      | citizenShip |

  @Regression @AddCitizenship
  Scenario: Create A Citizenship
    When Click on the element in the Dialog content
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Navi |
      | shortName | N    |
    And Click on the element in the Dialog content
      | saveButton |
    Then Success message should be displayed

  @Regression @Negative @AddCitizenship
  Scenario: Create An Existant Citizenship
    When User Create Again Citizenship name as "Navi" short name as "N"
    Then Already Exist message should be displayed
    And Click on close button

  @Regression @EditCitizenship
  Scenario: Update the Citizenship
    When User sending the keys in Dialog content
      | searchInput | Navi |
    And Click on the element in the Dialog content
      | searchButton |
    And User should be update the citizenship name as "Hobbit" code as "H"
    Then Success message should be displayed

  @Regression @DeleteCitizenship
  Scenario: Delete the Citizenship
    When The user search and delete the item from Dialog Page
      | Hobbit |
    Then Success message should be displayed

  @Regression @Negative @DeleteCitizenship
  Scenario: Search and delete an unavailable Citizenship
    When User sending the keys in Dialog content
      | searchInput | Hobbit |
    And Click on the element in the Dialog content
      | searchButton |
    And Verify that there is no data to display




