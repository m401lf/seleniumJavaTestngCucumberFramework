package testScripts.Login;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import base.BaseTest;
import utilities.GlobalVars;

@Listeners(testComponents.Listeners.class)
public class LoginTest_ValidCredentials extends BaseTest {

    IndexPage ip;
    LoginPage lp;
    AccountPage ap;
    LogoutPage lgp;
    EditPage ep;

    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        ip = new IndexPage(driver);
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        lp = ip.clickOnMyAccountAndLoginLink();
        ap = lp.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        Assert.assertTrue(ap.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        ep = ap.tapOnEditAsideWidgetLink();
        ap = ep.clickOnAccountContinueButton();
        lgp = ap.tapLogoutLinkFromSideWidgetLinks();
        ip = lgp.clickAccountLogoutContinueBtn();
    }

}