@regression @login
Feature: FB Sign-up functionality
  Background:
    Given I am on facebook home page

  @fb-sign-in
  Scenario: Verify Invalid Login
    When I enter mohammad@gmail.com into username text fields on home screen
    And I enter test1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am on invalid login page

  @fb-sign-up
  Scenario: Verify gender error
    When I enter Gulam in name text field
    And  I enter Rabbani in text field
    And I enter 9185682457 in mobil no field
    And I enter mnj23456 in password field
    And I click on sign up button
    And I select Jan from month drop down, 19 from date drop down and 2003 from year dropdown
    Then I receive a error msg

  @fb-sign-up-2
  Scenario Outline: Verify multiple sign-up
    When I enter <firstName> in name text field
    And  I enter <lastName> in text field
    And I enter <mobileNum> in mobil no field
    And I enter <password> in password field
    And I click on sign up button
    And I select <month> from month drop down, <date> from date drop down and <year> from year dropdown
    Then I receive a error msg

    Examples:
      |firstName| lastName | mobileNum | password | month | date | year |
      | Mizan   | Ahmed    |  4637264  |  wgfqe235| Feb   | 23   | 1976 |
      | Murad   | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |
      | Tahir   | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |
      | Jamil   | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |
      | Rubel   | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |
      | Shanta  | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |
      | Manha   | Ahmed    |  4667264  |  wgfsada5| Mar   | 13   | 1986 |