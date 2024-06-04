@RecoveryForgottenLoginname
@Forgotten
Feature: Login Page - Recovery Loginname Login Functionality

  Background: common steps in scenarios
    Given I navigate to login page
    And I can see "Returning Customer" and "I am a new customer." sub headings texts
    And I can see "Forgot your password" and "Forgot your login" links
    And I login with "wrongLoginName" and "Password001"
    And I tap on Login button
    And should be presented with the following Error validation message as "Error: Incorrect login or password provided."
    And click on Forgot your Login link
    And I should be redirected to the forgotten-loginname page

  Scenario Outline: should be able to use Forgot your password with valid credentials
    And I can see Enter the last name and e-mail address associated with your account
    And I enter last name "Zeta" and email address "benazeta70@gmail.com"
    And I tap on Continue button in recovery forgotten Loginname Page
    And I should a see confirmation message "<status>"
    Examples:
      | status                                                                  |
      | Success: Your login name reminder has been sent to your e-mail address. |
