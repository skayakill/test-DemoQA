@All
Feature: Login

  @Test
Scenario: Login
  Given user is on login page
  When user click button register
  Then user input name
  And user fill email and password
  And user input confirmation password
  When user input click button register
  Then user register successfully
  When user go to homepage
  And user go to Shop Yoga
  Then user will show detail products