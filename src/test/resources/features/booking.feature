@web @regression @booking
Feature: booking feature

  Background:
    Given I am on booking home page

    @booking-1
      Scenario: Verify there are 5 dropdown displayed for age at checkout
      When I click on select your language
      And I select English-US from the language list
      When I enter Texas into Where are you going text Field and I select Houston, Texas, United States of America from list
      When I click on calendar
      And I click on check-in
      And I click on check-out date
      When I click on adultsChildrenRoomsButton
      And I select 4 adults by clickin on adults
      And I select 3 children by clicking on Children
      Then I Verify there are 5 dropdown displayed for age at checkout




