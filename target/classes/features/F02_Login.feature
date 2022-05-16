@Smoke
Feature: User could log in with valid email and password

  Scenario: User could log in with registered credentials
    Given user had a valid registered account
    And user navigate to home page
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    Then user click on log out button
