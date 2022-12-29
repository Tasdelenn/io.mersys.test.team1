Feature:  Country Functionality

  @Regression @SundayTest
  Scenario: Create Country
    And Navigate to country page
    When Create a country
    Then Success message should be displayed
