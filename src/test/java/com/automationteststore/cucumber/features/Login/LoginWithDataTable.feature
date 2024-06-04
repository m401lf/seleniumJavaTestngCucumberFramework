@LoginWithDataTable
Feature: Login Page - Login Functionality

  Background: common steps in scenarios
    Given I landed on Ecommerce website
    And I should see in the page as follows:
      | url                             | page title                                  |
      | https://automationteststore.com | A place to practice your automation skills! |
    When I tap on "Login or register" to navigate to login page


  Scenario Outline: should be able to login with valid credentials
    #And I login in login page as a returning customer
    When I fill in the following login credentials:
      | loginname       | password    |
      | datastudioplace | Manchester1 |
    And I click on login button
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I logout application

    Examples:
      | loginValidationMessage |
      | Welcome back           |


  Scenario Outline: should not be able to login with invalid credentials
    #And I login in login page
    When I fill in the following login credentials:
      | loginname       | password     |
      | datastudioplace | Manchester11 |
    And I click on login button
    Then should be presented with the following error validation message "<loginErrorValidationMessage>"
    And I quit browser

    Examples:
      | loginErrorValidationMessage                  |
      | Error: Incorrect login or password provided. |