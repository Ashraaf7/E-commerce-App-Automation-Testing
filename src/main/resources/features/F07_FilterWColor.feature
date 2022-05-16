@Smoke
Feature: Logged user could filter with color

  Scenario: Logged user could filter with color and verify it
    Given user had a valid registered account
    And user navigate to home page
    #Login again if not Logged yet
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    #Start of actual scenario steps
    Given user select category that have a color option filter
    And user select color filter red
    Then user should see relative products to the selected color
