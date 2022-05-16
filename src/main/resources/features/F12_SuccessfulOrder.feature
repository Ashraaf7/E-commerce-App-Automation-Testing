@Smoke
Feature: Logged user could create successful order

  Scenario: Logged user could create successful order
    Given Go to shopping cart
    And user check on terms of service
    And user click on checkout button
    And user chose country
    And user chose city
    And user write address
    And user enter zip code
    And user enter phone number
    And user click on first continue button
    And user click on second continue button
    And user click on third continue button
    And user click on fourth continue button
    And user click on confirm order button
    Then user should redirected to the page of confirmed order