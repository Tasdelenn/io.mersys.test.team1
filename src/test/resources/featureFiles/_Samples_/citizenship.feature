Feature:  Citizenships Functionalty

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly
    And Navigate to citizenship page

  Scenario:
    When Create a citizenship
    Then Success message should be displayed

    When User update the created Citizenship
    Then Success message should be displayed

    When User delete the updated Citizenship
    Then Success message should be displayed

