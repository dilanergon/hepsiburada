@LoginTest
Feature: Login Tests

  Scenario: Successful Login Test
    Given I'm going to the login page
    When I'm filling in the correct email and correct password fields
    And I click the submit button
    Then I see the home page

  Scenario:  Invalid Login Scenario with correct email and wrong password
    Given I'm going to the login page
    When I'm filling in the correct email and wrong password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with correct email and empty password
    Given I'm going to the login page
    When I'm filling in the correct email and I'm not filling in the password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with wrong email and correct password
    Given I'm going to the login page
    When I'm filling in the wrong email and I'm filling in the correct password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with wrong email and wrong password fields
    Given I'm going to the login page
    When I'm filling in the wrong email and wrong password fields
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with wrong email and empty password
    Given I'm going to the login page
    When I'm filling in the wrong email and I'm not filling password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with empty email and empty password
    Given I'm going to the login page
    When I'm not filling in the email and password fields
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with empty email and correct password
    Given I'm going to the login page
    When I'm not filling in the email and I'm filling in the correct password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with empty email and wrong password
    Given I'm going to the login page
    When I'm not filling in the email and I'm filling in the wrong password field
    And I click the submit button
    Then I see the error message


  Scenario:  Invalid Login Scenario with invalid email and correct password
    Given I'm going to the login page
    When I'm filling in the invalid email and I'm filling in the correct password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with invalid email and wrong password
    Given I'm going to the login page
    When I'm filling in the invalid email and I'm filling in the wrong password field
    And I click the submit button
    Then I see the error message

  Scenario:  Invalid Login Scenario with invalid email and empty password
    Given I'm going to the login page
    When I'm filling in the invalid email and I'm not filling in the password field
    And I click the submit button
    Then I see the error message



