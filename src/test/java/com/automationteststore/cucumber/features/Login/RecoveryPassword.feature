@RecoveryForgottenPassword
@Forgotten
Feature: Login Page - Recovery password Login Functionality

  Background: common steps in scenarios
    Given I navigate to login page
    And I can see "Returning Customer" and "I am a new customer." sub headings texts
    And I can see "Forgot your password" and "Forgot your login" links
    And I login with "wrongLoginName" and "Password001"
    And I tap on Login button
    And should be presented with the following Error validation message as "Error: Incorrect login or password provided."
    And click on Forgot your password link
    And I should be redirected to the forgotten-password page

  Scenario Outline: should be able to use Forgot your password with valid credentials
    And I can see Enter the login name and e-mail address associated with your account
    When I enter login name "benazeta70" and email address "benazeta70@gmail.com"
    And I tap on Continue button in recovery forgotten Password Page
    Then I should a see confirmation message "<status>"

    Examples:
      | status                                                             |
      | Success: Password reset link has been sent to your e-mail address. |
