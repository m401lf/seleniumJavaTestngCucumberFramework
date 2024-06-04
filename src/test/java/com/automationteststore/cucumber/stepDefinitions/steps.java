package com.automationteststore.cucumber.stepDefinitions;

import base.BasePage;
import base.BaseTest;
import base.CheckPoint;
import helper.alert.AlertHelper;
import helper.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;

public class steps extends BaseTest {
    TopMenuPage naviPage;

    CheckoutCartPage checkoutCartPage;
    LoginPage loginPage;
    AsideWidgetPage asideWidgetPage;
    MyAccountPage accountPage;
    BasePage basePage;
    RegisterPage register;
    SuccessPage success;
    LogoutPage logoutPage;
    HomePage homePage;
    AlertHelper alertHelper;


    @Given("I landed on Ecommerce website")
    public void i_landed_on_ecommerce_website() throws IOException {
        naviPage = new TopMenuPage(driver);
        naviPage = launchApplication();

    }

    @And("I should see in the page as follows:")
    public void i_should_see_in_the_page_as_follow(DataTable dataTable) {
        AssertionHelper.updateTestStatus(naviPage.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().contains(dataTable.cell(1, 1)));

    }

    @When("I tap on {string} to navigate to login page")
    public void i_tap_on_to_navigate_to_login_page(String loginOrRegisterLink) {
        AssertionHelper.updateTestStatus(naviPage.getLoginOrRegisterLink().contains(loginOrRegisterLink));
        loginPage = naviPage.clickOnLoginOrRegisterLink();
    }


    @When("I should see in the login page as follows:")
    public void i_should_see_in_page_in_the_login_page(DataTable dataTable) {
        AssertionHelper.updateTestStatus(naviPage.getThisPageUrl().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().contains(dataTable.cell(1, 1)));
        AssertionHelper.updateTestStatus(naviPage.getPageHeaderText().contains(dataTable.cell(1, 2)));

    }

    @When("page header is displayed as {string}")
    public void page_header_display_as(String headerText) {
        Assert.assertEquals(naviPage.getPageHeaderText(), headerText);

    }


    @When("I can see current page breadcrumb {string}")
    public void i_can_see_current_page_breadcrumb(String pageBreadcrumb) {
        //loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        AssertionHelper.updateTestStatus(basePage.getPageBreadcrumbMenuList(pageBreadcrumb).isDisplayed());

    }

    @When("I can see {string} and {string}")
    public void i_can_see_and(String newCustomerText, String returnCustomerText) {
        AssertionHelper.updateTestStatus(loginPage.getNewCustomerTxt().contains(newCustomerText));
        AssertionHelper.updateTestStatus(loginPage.getReturningCustomerTxt().contains(returnCustomerText));

    }

    @When("I can see {string} is checked by default")
    public void i_can_see_is_checked_by_default(String accountRegisterText) {
        AssertionHelper.updateTestStatus(loginPage.getRegisterAccountRadioButtonTxt().contains(accountRegisterText));
        AssertionHelper.updateTestStatus(loginPage.assertRegisterAccountRadioButtonChecked());

    }

    @When("can see {string} and {string}")
    public void can_see_and(String forgetPasswordLink, String forgetYourLoginLink) {
        loginPage = new LoginPage(driver);
        AssertionHelper.updateTestStatus(loginPage.getForgotYourPasswordLinkTxt().contains(forgetPasswordLink));
        AssertionHelper.updateTestStatus(loginPage.getForgotYourLoginLinkTxt().contains(forgetYourLoginLink));

    }

    @Given("I enter loginname {string} and password {string}")
    public void i_enter_loginname_and_password(String loginname, String password) throws IOException {
        loginPage.enterLoginName(loginname);
        loginPage.enterPassword(password);
        accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();
    }

    @Given("I enter invalid loginname {string} and password {string}")
    public void i_enter_invalid_loginname_and_password(String loginname, String password) throws IOException {
        loginPage.enterLoginName(loginname);
        loginPage.enterPassword(password);
        loginPage.clickLoginButtonInAccountLoginPage();

    }

    @Then("should be presented with the following validation message as {string}")
    public void should_be_presented_with_the_following_validation_message_as(String loginValidationMessage) {
        Assert.assertTrue(accountPage.getWelcomeMessageTxt().contains(loginValidationMessage));

    }

    @When("I click on continue button")
    public void i_click_on_continue_button_in_login_page() {
        loginPage.clickOnContinueButtonInLoginPage();

    }

    @When("I tap {string} button in login page")
    public void i_tap_continue_button_in_login_page(String continueBtnText) {
        Assert.assertEquals(loginPage.getContinueButtonTxt(), continueBtnText);
        loginPage.clickOnContinueButtonInLoginPage();

    }

    @And("I logout application")
    public void and_I_logout_application() throws IOException {
        logoutPage = accountPage.clickOnLogoffBtn();
        homePage = logoutPage.clickOnLogoutContinueButton();
    }

    @When("I can see page title {string} and page header {string}")
    public void i_can_see_page_title_and_page_header(String pageTitle, String pageHeader) {
        register = new RegisterPage(driver);
        AssertionHelper.updateTestStatus(register.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(register.getPageHeaderText().contains(pageHeader));
    }

    @When("I should see {string}")
    public void i_should_see(String alreadyRegisteredText) {
        AssertionHelper.updateTestStatus(register.getIfYouAlreadyHaveAnAccountWithUs().contains(alreadyRegisteredText));

    }

    @When("I can see input sections as follows:")
    public void i_can_see_input_sections_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(register.getYourPersonalDetailsTxt().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(register.getYourAddressText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(register.getLoginDetailsSectionTxt().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(register.getNewsletterTxt().contains(dataTable.cell(3, 0)));

    }

    @When("I can see labels {int} first label {string} and last {string}")
    public void i_can_see_labels_first_label_and_last(Integer labelCount, String firstLabel, String lastLabel) {
        AssertionHelper.updateTestStatus(register.assertLabelCountAndSizeAndPositions(labelCount, firstLabel, lastLabel));


    }

    @When("I input firstName {string}")
    public void i_input_first_name(String firstName) {
        register.enterFirstName(firstName);
    }

    @When("I input lastName {string}")
    public void i_input_last_name(String lastName) {
        register.enterLastName(lastName);

    }

    @When("I input unique emailAddress")
    public void i_input_unique_email_address() {
        register.enterEmailAddress();
    }

    @When("I input telephone {string}")
    public void i_input_telephone(String telephone) {
        register.enterTelephoneNumber(telephone);
    }

    @When("I input fax {string}")
    public void i_input_fax(String fax) {
        register.enterFaxNumber(fax);

    }

    @When("I input company {string}")
    public void i_input_company(String coyName) {
        register.enterCompanyName(coyName);
    }

    @When("I input Address one {string}")
    public void i_input_address_one(String address1) {
        register.enterAddress1(address1);
    }

    @When("I input Address two {string}")
    public void i_input_address_two(String address2) {
        register.enterAddress2(address2);
    }

    @When("I input city {string}")
    public void i_input_city(String city) {
        register.enterCity(city);
    }

    @When("I select region or province {string}")
    public void i_select_region_or_province(String regionOrProvince) {
        register.selectRegionOrState(regionOrProvince);
    }

    @When("I input zipCodeOrPostCode {string}")
    public void i_input_zip_code_or_post_code(String postcode) {
        register.enterPostalOrZipCode(postcode);

    }

    @When("I select {string} country from the dropdown")
    public void i_select_country_from_the_dropdown(String country) {
        register.selectCountry(country);

    }

    @When("I input unique login name")
    public void i_input_unique_login_name() {
        register.inputUniqueLoginName();

    }

    @When("I input password {string}")
    public void i_input_password(String password) {
        register.enterPassword(password);
    }

    @When("I input confirm password {string}")
    public void i_input_confirm_password(String comPassword) {
        register.enterConfirmPassword(comPassword);

    }

    @When("I tick on subscription option Yes")
    public void i_tick_on_subscription_option_yes() {
        register.tickOnSubscribeAsYes();
    }

    @When("I tick on subscription option {string}")
    public void i_tick_on_subscription_option(String yesOptionText) {
        Assert.assertTrue(register.getSubscribeYesOptionText().contains(yesOptionText));
        register.tickOnSubscribeAsYes();
    }

    @When("I can see Subscribe Yes is checked")
    public void i_can_see_subscribe_is_checked() {
        AssertionHelper.updateTestStatus(register.assertSubscribeYesIsSelected());

    }

    @When("I can see Subscribe {string} is checked")
    public void i_can_see_subscribe_Yes_is_checked(String yesOptionText) {
        Assert.assertTrue(register.getSubscribeYesOptionText().contains(yesOptionText));
        AssertionHelper.updateTestStatus(register.assertSubscribeYesIsSelected());

    }

    @When("I tick on Privacy Policy radio button")
    public void i_tick_on_radio_button() {
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
    }

    @When("I tick on {string} radio button")
    public void i_tick_on_privacy_policy_radio_button(String privacyPolicyText) {
        Assert.assertEquals(register.getPrivacyPolicyText(), privacyPolicyText);
        register.checkOnIAgreeToPrivacyPolicyRadioButton();
    }

    @When("I can see {string} is ticked")
    public void i_can_see_privacy_policy_is_ticked(String privacyPolicyText) {
        AssertionHelper.updateTestStatus(register.assertPrivacyPolicyIsSelected());
        Assert.assertEquals(register.getPrivacyPolicyText(), privacyPolicyText);

    }

    @When("I tap on {string} button in register page")
    public void i_tap_on_button_in_register_page(String continueButtonText) throws IOException {
        if (register.getContinueButtonTxt().contains(continueButtonText)) {
            register.clickContinueButtonInRegisterPage();
        }

    }

    @When("I input Your Personal sections with the following details:")
    public void i_input_your_personal_sections_with_the_following_details(DataTable dataTable) {
        register = new RegisterPage(driver);
        register.enterFirstName(dataTable.cell(1, 0));
        register.enterLastName(dataTable.cell(1, 1));
        register.enterEmailAddress();
        register.enterTelephoneNumber(dataTable.cell(1, 2));
        register.enterFaxNumber(dataTable.cell(1, 3));

    }

    @When("I can see {string} section label")
    public void i_can_see_section_label(String string) {

    }

    @When("I input Your Address section with the following details:")
    public void i_input_your_address_section_with_the_following_details(DataTable dataTable) {
        register.enterCompanyName(dataTable.cell(1, 0));
        register.enterAddress1(dataTable.cell(1, 1));
        register.enterAddress2(dataTable.cell(1, 2));
        register.enterCity(dataTable.cell(1, 3));
        register.selectRegionOrState(dataTable.cell(1, 4));
        register.enterPostalOrZipCode(dataTable.cell(1, 5));
        register.selectCountry(dataTable.cell(1, 6));

    }

    @When("I input Login Details section with the following details:")
    public void i_input_login_details_section_with_the_following_details(DataTable dataTable) {
        register.inputUniqueLoginName();
        register.enterPassword(dataTable.cell(1, 0));
        register.enterConfirmPassword(dataTable.cell(1, 1));
        register.tickOnSubscribeAsYes();

    }

    @Then("I should see {string} and {string}")
    public void i_should_see_and(String pageTitle, String pageUrl) {
        AssertionHelper.updateTestStatus(success.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(success.getThisPageUrl().contains(pageUrl));


    }

    @Then("I should see {string} and {string} message")
    public void i_should_see_and_message(String pageHeader, String registerValidationMessage) {
        AssertionHelper.updateTestStatus(success.getThisPageHeader().contains(pageHeader));
        AssertionHelper.updateTestStatus(success.getCongratulationsAccountSuccessfullyCreatedText().contains(registerValidationMessage));

    }

    @Then("I should see {string} in Account success page")
    public void i_should_see_in_account_success_page(String accountCreatedSuccessfullyText) {
        success = new SuccessPage(driver);
        AssertionHelper.updateTestStatus(success.getYourAccountHasBeenCreatedText().contains(accountCreatedSuccessfullyText));

    }

    @Then("I can see in Account success page as follows:")
    public void i_can_see_in_account_success_page_as_follows(DataTable dataTable) {
        success = new SuccessPage(driver);
        AssertionHelper.updateTestStatus(naviPage.getWelcomeBackMessage().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(success.getYourAccountHasBeenCreatedText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(success.getCongratulationsAccountSuccessfullyCreatedText().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(success.getMyAccountText().contains(dataTable.cell(3, 0)));

    }

    @Then("I can see {string} Your new account has been successfully created!")
    public void i_can_see_your_new_account_has_been_successfully_created(String string) throws InterruptedException {
        AssertionHelper.updateTestStatus(success.getCongratulationsAccountSuccessfullyCreatedText().contains(string));

    }

    @Then("I logoff application")
    public void i_logoff_application() throws IOException {
        asideWidgetPage = new AsideWidgetPage(driver);
        logoutPage = asideWidgetPage.tapLogoffLink();
        homePage = logoutPage.clickOnLogoutContinueButton();

    }

    @Then("should be presented with the following error validation message {}")
    public void should_be_presented_with_the_following_error_validation_message_as(String loginErrorValidationMessage) throws InterruptedException {
        AssertionHelper.updateTestStatus(loginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessage().contains(loginErrorValidationMessage));
    }

    @Then("I quit browser")
    public void i_Quit_Browser() {
        driver.quit();

    }

    @When("I fill in the following login credentials:")
    public void i_fill_in_the_following_login_credentials(DataTable dataTable) {
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));

    }

    @When("I login in login page as a returning customer")
    public void i_login_in_login_page_as_a_returning_customer(DataTable dataTable) {
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));

    }

    @When("I login in login page")
    public void i_login_in_login_page(DataTable dataTable) {
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));

    }

    @When("I click on login button")
    public void i_click_on_login_button() throws IOException {
        accountPage = loginPage.ClickLoginButton();

    }

    @Then("I should see red warning error messages:")
    public void i_should_see_red_warning_error_messages(DataTable dataTable) {
        AssertionHelper.updateTestStatus(register.getAgreeToPrivacyPolicyRedMessages().contains(dataTable.cell(0, 0)));

    }

    @When("I can see error messages summary is displayed")
    public void i_can_see_error_messages_summary_is_displayed() {
        AssertionHelper.updateTestStatus(register.assertAllAlertErrorDangerSummaryText());

    }

    @Then("I should see red error warning messages:")
    public void i_should_see_red_error_warning_messages(DataTable dataTable) {
        AssertionHelper.updateTestStatus(register.getLoginNameRedMessages().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(register.getFirstNameRedMessages().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(register.getLastNameRedMessages().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(register.getEmailRedMessages().contains(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(register.getAddress1RedMessages().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(register.getCityRedMessages().contains(dataTable.cell(5, 0)));
        AssertionHelper.updateTestStatus(register.getZipCodeRedMessages().contains(dataTable.cell(6, 0)));
        AssertionHelper.updateTestStatus(register.getStateProvinceRedMessages().contains(dataTable.cell(7, 0)));
        AssertionHelper.updateTestStatus(register.getPasswordRedMessages().contains(dataTable.cell(8, 0)));
    }

    @Given("I can see top menu page properties as follows:")
    public void i_can_see_top_menu_page_properties_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(naviPage.getLoginOrRegisterLink().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(naviPage.getTopMenuItemsList(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(naviPage.getTopMenuItemsList(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(naviPage.getTopMenuItemsList(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(naviPage.getTopMenuItemsList(dataTable.cell(4, 0)));

    }

    @Given("I verify if links are present:")
    public void i_verify_if_links_are_present(DataTable dataTable) {
        AssertionHelper.updateTestStatus(naviPage.assertTopMenuItemsListArePresent(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(naviPage.assertTopMenuItemsListArePresent(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(naviPage.assertTopMenuItemsListArePresent(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(naviPage.assertTopMenuItemsListArePresent(dataTable.cell(3, 0)));
    }

    @Given("I can see page properties as follows:")
    public void i_can_see_page_properties_as_follows(DataTable dataTable) {
        homePage = new HomePage(driver);
        boolean status = homePage.getThisPageUrl().contains(dataTable.cell(1, 0));
        AssertionHelper.updateTestStatus(status);
        CheckPoint.mark("test-01", status, "Page url verification");
        boolean result = homePage.getThisPageTitle().contains(dataTable.cell(1, 1));
        AssertionHelper.updateTestStatus(result);
        CheckPoint.markFinal("test-01", result, "Page title verification");

    }

    @When("I can see page breadcrumb as follows:")
    public void i_can_see_page_breadcrumb_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(homePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(homePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(homePage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(dataTable.cell(2, 0)));

    }

    @When("I can see:")
    public void i_can_see(DataTable dataTable) {
        AssertionHelper.updateTestStatus(loginPage.getNewCustomerTxt().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(loginPage.getReturningCustomerTxt().contains(dataTable.cell(1, 0)));

    }

    @When("enter Your Personal Details section with:")
    public void enter_your_personal_details_section_with(DataTable dataTable) {

        register.enterFirstName(dataTable.cell(1, 0));
        register.enterLastName(dataTable.cell(1, 1));
        register.enterTelephoneNumber(dataTable.cell(1, 2));
        register.enterFaxNumber(dataTable.cell(1, 3));
    }

    @When("enter Your Address Details section with:")
    public void enter_your_address_details_section_with(DataTable dataTable) {
        register.enterCompanyName(dataTable.cell(1, 0));
        register.enterAddress1(dataTable.cell(1, 1));
        register.enterAddress2(dataTable.cell(1, 2));
        register.enterCity(dataTable.cell(1, 3));
        register.selectRegionOrState(dataTable.cell(1, 4));
        register.enterPostalOrZipCode(dataTable.cell(1, 5));
        register.selectCountry(dataTable.cell(1, 6));

    }

    @When("enter Your Login Details section with:")
    public void enter_your_login_details_section_with(DataTable dataTable) {
        register.enterPassword(dataTable.cell(1, 0));
        register.enterConfirmPassword(dataTable.cell(1, 1));

    }


}
