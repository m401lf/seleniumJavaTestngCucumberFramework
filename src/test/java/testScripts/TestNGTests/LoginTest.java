package testScripts.TestNGTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;

public class LoginTest extends BaseTest {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;
    LogoutPage logoutPage;

    EditPage editPage;

    @Test
    public void loginTest() throws IOException, InterruptedException {
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
        loginPage.enterPassword(GlobalVars.getPassword());

        accountPage = loginPage.clickOnLoginButton();
        boolean status_welcomeMsg = accountPage.getEditAccountDetailsText().contains(GlobalVars.getWelcomeMsg());
        Assert.assertTrue(status_welcomeMsg);

        editPage = accountPage.clickOnYourEditAccountInformationLink();
        Assert.assertTrue(editPage.getCurrentPageUrl().contains(GlobalVars.getAccountEditUrlPath()));

        accountPage = editPage.clickOnAccountContinueButton();
        boolean status_updatedSuccessfully = accountPage.getSuccessYourAccountSuccessfullyUpdatedTxt().contains(GlobalVars.getUpdatedSuccessfully());
        Assert.assertTrue(status_updatedSuccessfully);

        logoutPage = accountPage.clickOnLogoutSideWidgetLink();
        boolean status_AccountLogoutHeader = logoutPage.getAccountLogoutTxt().contains(GlobalVars.getAccountLogoutHeaderTxt());
        Assert.assertTrue(status_AccountLogoutHeader);

        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }
}