Feature:  Country Functionality

  Background:
#    Given Navigate to Mersys Campus
#    When Enter username and password and click login button
#    Then User should be login successfuly
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | countries  |

  @Regression
  Scenario: Add Country
    When Click on the element in the Dialog content
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Tallsan |
      | codeInput | TL      |
    And Click on the element in the Dialog content
      | saveButton |
    Then Success message should be displayed

  Scenario: Update the Country
    When User sending the keys in Dialog content
      | searchInput | Tallsan |
    And Click on the element in the Dialog content
      | searchButton |
    And User should update the country name as "Talossan" code as "TS"
    Then Success message should be displayed

  Scenario: Delete the Country
    When Navigate to country page and delete the Country name as"Talossan"
    Then Success message should be displayed

    @Negative
  Scenario: Search and delete an unavailable Country
    Then The user search and delete an unavailable Country "Talossan"
    And Verify that there is no data to display