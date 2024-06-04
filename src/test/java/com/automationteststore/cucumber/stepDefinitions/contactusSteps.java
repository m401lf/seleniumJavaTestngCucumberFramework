package com.automationteststore.cucumber.stepDefinitions;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;


public class contactusSteps extends BaseTest {
    public LoginPage loginPage;
    public LoginPage indexPage;
    public MyAccountPage accountPage;
    TopMenuPage naviPage;
    FooterPage footerPage;
    ContactUsPage contactUsPage;
    ContactUsSuccessPage contactUsSuccessPage;


    @Given("I navigate to contactus page")
    public void iNavigateToContactusPage() throws IOException {
        naviPage = new TopMenuPage(driver);
        naviPage.navigateToIndexPage();
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().contains(GlobalVars.getHomePageTitle()));
        footerPage = new FooterPage(driver);
        contactUsPage = footerPage.clickOnContactusLink();
    }

    @And("I can see contact details {string}, {string} and {string} are displayed")
    public void iCanSeeContactDetailsIsDisplayedAnd(String contactusTxt, String address, String phoneNumber) {
        AssertionHelper.updateTestStatus(contactUsPage.getContactDetailsText().contains(contactusTxt));
        AssertionHelper.updateTestStatus(contactUsPage.getAddressText().contains(address));
        AssertionHelper.updateTestStatus(contactUsPage.getPhoneNumberTxt().contains(phoneNumber));
    }

    @And("clicks on the submit button")
    public void clicksOnTheSubmitButton() throws IOException {
        contactUsSuccessPage = contactUsPage.tapOnSubmitBtn();
    }

    @Then("I should get confirmation warning massage firstname {string}")
    public void iShouldGetConfirmationWarningMassageFirstname(String errorFirstnameMsg) {
        AssertionHelper.updateTestStatus(contactUsPage.getErrorFirstNameBoxMsg().contains(errorFirstnameMsg));
    }

    @Then("I should get confirmation warning massage email {string}")
    public void iShouldGetConfirmationWarningMassageEmail(String errorEmailMsg) {
        AssertionHelper.updateTestStatus(contactUsPage.getErrorEmailBoxMsg().trim().contains(errorEmailMsg));
    }

    @Then("I should get confirmation warning massage inquiry {string}")
    public void iShouldGetConfirmationWarningMassageInquiry(String warningMassageInquiry) throws InterruptedException {
        AssertionHelper.updateTestStatus(contactUsPage.getErrorInquiryBoxMsg().contains(warningMassageInquiry));
    }

    @When("I inputted first name as {string} email Address as {string} and inquiry as {string}")
    public void iInputtedFirstNameAsEmailAddressAsAndInquiryAs(String firstname, String email, String inquiryMsg) {
        contactUsPage.inputFirstName(firstname);
        contactUsPage.inputEmail(email);
        contactUsPage.inputInquiry(inquiryMsg);
    }

    @Then("I can see {string} button and {string}")
    public void iCanSeeContinousButtonAnd(String continueBtn, String subnitSuccessMsg) {
        AssertionHelper.updateTestStatus(contactUsSuccessPage.getContinueButtonText().equalsIgnoreCase(continueBtn));
        AssertionHelper.updateTestStatus(contactUsSuccessPage.getSuccessfullySentMessage().equalsIgnoreCase(subnitSuccessMsg));
    }

    @And("I tap on the continue button")
    public void iTapOnTheContinueButton() throws IOException {
        indexPage = contactUsSuccessPage.clickOnContinueButton();
    }

}



