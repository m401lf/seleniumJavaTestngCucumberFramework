package com.automationteststore.cucumber.stepDefinitions;

import base.BasePage;
import base.BaseTest;
import helper.alert.AlertHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.*;

public class forgottenSteps extends BaseTest {
    TopMenuPage naviPage;
    LoginPage loginPage;
    AsideWidgetPage asideWidgetPage;
    MyAccountPage accountPage;
    BasePage basePage;
    RegisterPage register;
    SuccessPage success;
    LogoutPage logoutPage;
    HomePage homePage;
    AlertHelper alertHelper;


    @Given("I navigate to login page")
    public void i_navigate_to_login_page() {
        loginPage = new LoginPage(driver);
        loginPage = naviPage.clickOnLoginOrRegisterLink();
    }

    @Given("I can see {string} and {string} sub headings texts")
    public void i_can_see_and_sub_headings_texts(String string, String string2) {

    }

    @Given("I can see {string} and {string} links")
    public void i_can_see_and_links(String string, String string2) {

    }

    @Given("I login with {string} and {string}")
    public void i_login_with_and(String string, String string2) {

    }

    @Given("I tap on Login button")
    public void i_tap_on_login_button() {

    }

    @Given("should be presented with the following Error validation message as {string}")
    public void should_be_presented_with_the_following_error_validation_message_as(String string) {

    }

    @Given("click on Forgot your Login link")
    public void click_on_forgot_your_login_link() {

    }

    @Given("I should be redirected to the forgotten-loginname page")
    public void i_should_be_in_forgotten_loginname_page() {

    }

    @Given("I can see Enter the last name and e-mail address associated with your account")
    public void i_can_see_enter_the_last_name_and_e_mail_address_associated_with_your_account() {

    }

    @Given("I enter last name {string} and email address {string}")
    public void i_enter_last_name_and_email_address(String string, String string2) {

    }

    @Given("I tap on Continue button in recovery forgotten Loginname Page")
    public void i_tap_on_continue_button_in_recovery_forgotten_loginname_page() {

    }

    @Given("I should a see confirmation message {string}")
    public void i_should_a_see_confirmation_message(String string) {

    }

    @Given("click on Forgot your password link")
    public void click_on_forgot_your_password_link() {

    }

    @Given("I should be redirected to the forgotten-password page")
    public void i_should_be_in_forgotten_password_page() {

    }

    @Given("I can see Enter the login name and e-mail address associated with your account")
    public void i_can_see_enter_the_login_name_and_e_mail_address_associated_with_your_account() {

    }

    @When("I enter login name {string} and email address {string}")
    public void i_enter_login_name_and_email_address(String string, String string2) {

    }

    @When("I tap on Continue button in recovery forgotten Password Page")
    public void i_tap_on_continue_button_in_recovery_forgotten_password_page() {

    }

}
