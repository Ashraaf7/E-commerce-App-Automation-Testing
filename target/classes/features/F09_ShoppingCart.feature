@Smoke
Feature: Logged user could add different products to Shopping cart

  Scenario: Logged user should add different products to Shopping cart
    Given user had a valid registered account
    And user navigate to home page
    #Login again if not Logged yet
    And user click on log in
    And user fill his or her email
    And user fill his or her password
    And user click on log in button
    Then user should login successfully and see log out appears at the top right
    #Start of actual scenario steps
#    1st product
    Given user select random category
    Then user should redirected to the page of the selected category
    Then user click on random product
    And user check if the product have attributes
    And user click on add to cart
#    2nd product
    Given user select random category
    Then user should redirected to the page of the selected category
    Then user click on random product
    And user check if the product have attributes
    And user click on add to cart
#    3rd product
    Given user select random category
    Then user should redirected to the page of the selected category
    Then user click on random product
    And user check if the product have attributes
    And user click on add to cart
    Then user should found the product added to cart in shopping cart