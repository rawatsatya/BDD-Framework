#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login Functionality

  Scenario: Login with correct email and password
    Given I launch the browser
    When I navigate to 'http://automationexercise.com'
    Then I should see the home page
    
    When I click on the Signup & Login button
    Then Login to your account should be visible
    
    When User enters correct email address "<satyam.rawat.ext@bandhanbank.in>" and password "<Satyam@30>" and User clicks the login button
    Then Logged in as username "<Satyam>" should be visible