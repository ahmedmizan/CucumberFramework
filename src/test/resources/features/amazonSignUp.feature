@regression @sign-up
Feature: Sign-up feature
  Background:
    Given I am on amazon landing page


#    @sign-up-1
#
#        Scenario: Sign in for Amazon Account
#          When I mouse over on sign in
#          Then I click  your account
#          And Click on login and security


  @sign-up-2
  Scenario: Sign up for Amazon account
    When I mouse over on sign in
    And I click on your account link
    And Click on login and security link
    And I click on create your amazon account
#        And Again click on create account
    And Enter Ahmed Abdullah into name field
    And Enter ahmed@gmail.com into Email field
    And Enter abcd1234 into Password field
    And Enter abcd1234 into confirm Password field
    And Click on create an account