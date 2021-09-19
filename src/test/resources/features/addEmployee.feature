@wip
Feature: add employee

  Background:

    When user is on login page
    And user enters correct email and password
    And user clicks LogIn button
    Then user logged in successfully

  Scenario: add employee

    When user goes to Scheduler page
    And user clicks Add Employees button
    And user fills out profile
    And user clicks Add and Invite Employee button
    Then new employee is added


