@Smoke
Feature: Logged User could search for any product

  Scenario: Logged User could search for any product and find relative items
    Given user had a valid registered account
    And user navigate to home page
    #Login again
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    #Start search steps
    Given user click on search field
    And user type what he or she want to search "shirt"
    And user click on search button
    Then user could find relative results