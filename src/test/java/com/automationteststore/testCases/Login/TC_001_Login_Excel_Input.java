package com.automationteststore.testCases.Login;

import base.BaseTest;
import utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;


@Listeners(base.Listeners.class)

public class TC_001_Login_Excel_Input extends BaseTest {

    TopMenuPage naviPage;
    LoginPage loginPage;
    MyAccountPage accountPage;


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_login_Excel_Input(String email, String password, String exp) {
        //log.info("**** Starting TC_001_Login_Excel_Input *****");

        try {
            naviPage = new TopMenuPage(driver);
            ///loginPage = naviPage.hoverOverAccountLinkAndClickLoginLink();
            loginPage.enterLoginName(email);
            loginPage.enterPassword(password);
            accountPage = loginPage.clickOnLoginButtonInAccountLoginPage();

            boolean targetPage = accountPage.assertMyAccountPageIsDisplayed();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    accountPage.clickOnLogoutButton();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    accountPage.clickOnLogoutButton();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        //log.info("**** Finished TC_001_Login_Excel_Input *****");
    }

}








