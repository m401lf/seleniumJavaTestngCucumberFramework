package testScripts.Login;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import base.BaseTest;
import utilities.GlobalVars;

@Listeners(testComponents.Listeners.class)

public class LoginTestWithValidCredentials extends BaseTest {

    IndexPage indexPage;
    LoginPage loginPage;
    AccountPage accountPage;
    LogoutPage logoutPage;
    EditPage editPage;


    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        indexPage = new IndexPage(driver);
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        loginPage = indexPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.assertPageIsLoginPage().contains(GlobalVars.getLoginPageUrl()));
        accountPage = loginPage.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        Assert.assertTrue(accountPage.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickOnAccountContinueButton();
        logoutPage = accountPage.tapLogoutLinkFromSideWidgetLinks();
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

}