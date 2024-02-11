@feature
Feature: User Authentication

  Background:
    Given a demoBlaze home page is open

  Scenario: Sing up as a new user
    Given an unrecognized user
    When the user wants to sign up
    Then 'Sign up successful.' message should appear

  Scenario: Login attempt as a recognized user
    Given a recognized user
    When the user wants to log in
    Then the user should log in

  Scenario: Sing up with an existing user
    Given a recognized user
    When the user wants to sign up
    Then 'This user already exist.' message should appear

  Scenario: Login attempt as an unrecognised user
    Given an unrecognized user
    When the user wants to log in
    Then 'User does not exist.' message should appear

  Scenario: Sign up without password
    Given an unrecognized user
    When the user wants to sign up without a password
    Then 'Please fill out Username and Password.' message should appear

  Scenario: Send a message via Contact button
    Given the user selects 'Contact' button
    When the form is completed
    Then 'Thanks for the message!!' message should appear
