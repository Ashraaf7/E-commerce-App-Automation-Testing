@Smoke
Feature: Logged User could switch between currencies US-Euro

  Scenario: Logged User could switch between currencies
    Given user had a valid registered account
    And user navigate to home page
    #Login again if not Logged yet
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    #Start of steps
    Given user change current currency to EURO
    Then user should found all products prices in EURO
    Given user change current currency to US Dollar
    Then user should found all products prices in US Dollar