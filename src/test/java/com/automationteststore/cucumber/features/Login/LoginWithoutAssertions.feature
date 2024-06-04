@LoginWithoutAssertions
Feature: Login Page - Login Functionality

  Background: common steps in scenarios
    Given I landed on Ecommerce website
    When I tap on "Login or register" to navigate to login page


  Scenario: user should be able to login with valid credentials
    And I enter loginname "datastudioplace" and password "Manchester1"
    Then should be presented with the following validation message as "Welcome back"
    And I logout application

  Scenario Outline: user should be able to login with valid credentials
    And I enter loginname "<loginName>" and password "<password>"
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I logout application

    Examples:
      | loginName       | password    | loginValidationMessage |
      | datastudioplace | Manchester1 | Welcome back           |

  Scenario Outline: user should NOT be able to login with invalid credentials
    And I enter invalid loginname "<loginName>" and password "<password>"
    Then should be presented with the following error validation message "<loginErrorValidationMessage>"
    And I quit browser

    Examples:
      | loginName         | password     | loginErrorValidationMessage                  |
      | datastudioplace00 | Manchester00 | Error: Incorrect login or password provided. |
      |                   |              | Error: Incorrect login or password provided. |


  Scenario Outline: login with valid credentials with DataTable
    When I fill in the following login credentials:
      | loginname       | password    |
      | datastudioplace | Manchester1 |
    And I click on login button
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I logout application

    Examples:
      | loginValidationMessage |
      | Welcome back           |