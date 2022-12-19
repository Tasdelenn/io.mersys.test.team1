Feature: Login Functionality

  Background:
    Given Navigate to Mersys Campus

  @Login @Negative
  Scenario: Login with blank username or blank entry
    When Click to login button
    Then User should be seen require username and password

  @Login @Negative
  Scenario: Login with invalid username and password
    When Enter invalid username and password
    Then User should be seen invalid username or password

#  @Login
#  Scenario: Reset Password
#    When Click to Reset Password Link
#    Then User should be seen Reset Your Password

  @Login @SmokeTest @Regression
  Scenario: Login with valid username and password

    When Enter username and password and click login button
    Then User should be login successfuly