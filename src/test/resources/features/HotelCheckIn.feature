@web@regression
  @check-in
Feature: Hotel booking feature
  Scenario: Verify user can select date from Calendar
    Given I am on hotels landing page
    When I select "Florida City,Florida, United States of America" as destination
    And I enter tomorrow as check in date
    And I enter 4 days from tomorrow as checkout date
    Then I verify 4 count on the briefcase
