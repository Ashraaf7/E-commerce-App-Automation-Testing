@Smoke
Feature: User could reset his/her password successfully

  Scenario: User could reset the password successfully
    Given user had a valid registered account
    And user navigate to home page
    And user click on log in
    And user click on forgot password?
    And user fill email with valid email
    And user click on Recover button
    Then user should see message "Email with instructions has been sent to you."at the top