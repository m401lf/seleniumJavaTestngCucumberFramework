package testScripts.TestNGTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;
import pages.LoginPage;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;

public class LoginRecoveryForgottenLoginnameTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Test
    public void loginForgottenPasswordTest() throws IOException {

        indexPage = new IndexPage(driver);
        indexPage.navigateToLoginPage();
        boolean status_url = indexPage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        Assert.assertTrue(status_url);

        boolean status_title = indexPage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        Assert.assertTrue(status_title);
        loginPage = indexPage.clickOnMyAccountAndLoginLink();

        boolean status_returningCustomer = loginPage.getReturningCustomer().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        Assert.assertTrue(status_returningCustomer);

        boolean status_newCustomer = loginPage.getNewCustomer().equalsIgnoreCase(GlobalVars.getNewCustomer());
        Assert.assertTrue(status_newCustomer);

        loginPage.enterEmailAddress(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getWrongPassword());
        accountPage = loginPage.clickOnLoginButton();

        boolean status = loginPage.getErrorWarningConfirmationMsg().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg());
        Assert.assertTrue(status);

//        boolean status_forgot_your_password = loginPage.getForgotYourPasswordLinkTxt().trim().contains(GlobalVars.getForgotYourPasswordTxt());
//        Assert.assertTrue(status_forgot_your_password);
//
//        boolean status_forgot_your_loginname = loginPage.getForgotYourLoginLinkTxt().contains(GlobalVars.getForgotYourLoginnameTxt());
//        Assert.assertTrue(status_forgot_your_loginname);
//
//        forgottenLoginnamePage = loginPage.clickForgetYourLoginLink();
//
//        boolean result = forgottenLoginnamePage.isHintHeaderDisplayed();
//        Assert.assertTrue(result);
//
//        boolean result_hintText = forgottenLoginnamePage.isHintHeaderDisplayed();
//        Assert.assertTrue(result_hintText);
//
//        forgottenLoginnamePage.enterLastName(GlobalVars.getRecoveryLoginnameLastName());
//        forgottenLoginnamePage.enterEmail(GlobalVars.getEmailPassword());
//        loginPage = forgottenLoginnamePage.clicksOnContinueBtn();
//
//        boolean result_success = loginPage.getSuccessMsg().contains(GlobalVars.getRecoveryLoginnameAlertSuccessMsg());
//        Assert.assertTrue(result_success);


    }

}