@Login001
Feature: Login Page - Login Functionality

  Background: common steps in scenarios
    Given I landed on Ecommerce website
    And I should see in the page as follows:
      | url                             | page title                                  |
      | https://automationteststore.com | A place to practice your automation skills! |

    When I tap on "Login or register" to navigate to login page
    And I should see in the login page as follows:
      | url              | page title    | page header   |
      | rt=account/login | Account Login | ACCOUNT LOGIN |
    And I can see current page breadcrumb "Login"
    And page header is displayed as "ACCOUNT LOGIN"
    And I can see "I AM A NEW CUSTOMER." and "RETURNING CUSTOMER"
    And I can see "Register Account" is checked by default
    And can see "Forgot your password?" and "Forgot your login?"


  Scenario: 01 - Successful login with valid credentials
    And I enter loginname "datastudioplace" and password "Manchester1"
    Then should be presented with the following validation message as "Welcome back"
    And I logout application

  Scenario Outline: 02 - Successful login with valid credentials
    And I enter loginname "<loginName>" and password "<password>"
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I logout application

    Examples:
      | loginName       | password    | loginValidationMessage |
      | datastudioplace | Manchester1 | Welcome back           |

  Scenario Outline: 03 - Unsuccessful login with invalid credentials
    And I enter invalid loginname "<loginName>" and password "<password>"
    Then should be presented with the following error validation message "<loginErrorValidationMessage>"
    And I quit browser

    Examples:
      | loginName         | password     | loginErrorValidationMessage                  |
      | datastudioplace00 | Manchester00 | Error: Incorrect login or password provided. |
      |                   |              | Error: Incorrect login or password provided. |


  Scenario Outline: 04 - Successful login with valid credentials with DataTable
    When I fill in the following login credentials:
      | loginname       | password    |
      | datastudioplace | Manchester1 |
    And I click on login button
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I logout application

    Examples:
      | loginValidationMessage |
      | Welcome back           |