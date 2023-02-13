Feature: Departments Functionality

  Background:
    Given Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | departments |

  @SchoolDepartments
  Scenario: Add A Department

    When Click on the element in the Dialog content
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | Physics-Math |
      | codeInput | PM           |
    And Click on the element in the Dialog content
      | saveButton |
    Then Success message should be displayed

  @SchoolDepartments
  Scenario: Update A Department

    And User update the Department name as "Technology" code as "TL"
    Then Success message should be displayed

  @SchoolDepartments
  Scenario: Delete the Department

    And User find and delete the Department
    Then Success message should be displayed