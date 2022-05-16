@Smoke
Feature: Logged user could select different tags

  Scenario: Logged user could select different tags
    Given user had a valid registered account
    And user navigate to home page
    #Login again if not Logged yet
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    #Start of actual scenario steps
    #Tow Steps from F06 Feature
    Given user select random category
    Then user should redirected to the page of the selected category
    Given user select random tag
    Then user should see relative products to the selected tag