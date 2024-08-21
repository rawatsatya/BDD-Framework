Feature: User Registration on automationexercise.com

  Scenario: Register a new user
    Given I launch the browser
    When I navigate to 'http://automationexercise.com'
    Then I should see the home page
    When I click on the Signup & Login button
    Then I should see New User Signup!
    When I enter name and email address and I click the Signup button
    Then I should see ENTER ACCOUNT INFORMATION
    When I select the checkbox Sign up for our newsletter!
    And I select the checkbox Receive special offers from our partners!
    And I fill in the following details:
    And I click the Create Account button
    Then I should see ACCOUNT CREATED!
    When I click the Continue button
    Then I should see Logged in as username
    When I click the Delete Account button
    Then I should see ACCOUNT DELETED!
    