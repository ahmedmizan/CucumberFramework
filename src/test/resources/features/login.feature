@web @regression @login
Feature: Login feature

  Background:
    Given I am on home page

  @login-1
  Scenario: Verify Invalid Login
    When I enter mzan@gmail.com into user name text fields on home screen
    And I enter test1234 into text fields on home screen
    And I click on login button on home screen
    Then I verify that i am on invalid login page



#  @login-3
#  Scenario Outline: Verify Invalid Login for multiple users
#    When I enter <invalidEmailAddress> into username text fields on home screen
#    And I click on login button on home screen
#    Then I verify that i am an invalid login page
#
#    Examples:
#      | invalidEmailAddress            |
#      | plainaddress                   |
#      | #@%^%#$@#$@#.com               |
#      | @example.com                   |




