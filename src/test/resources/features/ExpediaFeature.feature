@web @regression @login
Feature: Booking feature

#  Background:
#    Given I am on home page
#
#  @login-1
#  Scenario: Verify Invalid Login
#    When I enter jkdfsl@gmail.com into user name text fields on home screen
#    And I enter test1234 into text fields on home screen
#    And I click on login button on home screen
#    Then I verify that i am on invalid login page



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


 Scenario: Expedia test
 When I write Dhaka into Destination field
 And I select Dhaka (DAC - Shahjalal Intl.) from suggestion list
