
Feature: login

  Scenario: successful login

    When user is on login page
    And user enters correct email and password
    And user clicks LogIn button
    Then user logged in successfully


  Scenario Outline: unsuccessful login

    When user is on login page
    And user enters incorrect "<email>" or "<password>"
    And user clicks LogIn button
    Then user is on the same page


    Examples:

      | email                     | password   |
      | example@gmail.com         | whenIwork1 |
      | serhiitynovskyi@gmail.com | password   |
      | email@gmail.com           | pass       |
