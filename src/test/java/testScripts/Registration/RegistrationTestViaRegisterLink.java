package testScripts.Registration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import base.BaseTest;
import utilities.GlobalVars;

@Listeners(testComponents.Listeners.class)

public class RegistrationTestViaRegisterLink extends BaseTest {
    IndexPage indexPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Test(description = "Registration test with valid credentials via Register link")
    public void RegistrationTestByRegisterLink() throws Exception {
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        indexPage = new IndexPage(driver);
        registerPage = indexPage.tapOnItemFromAccountOptions("My Account", "Register");
        registerPage.inputPersonalDetails("Firstname", "Lastname", "07405000000");
        registerPage.inputPasswordAndConfirmPassword("Password", "Password");
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        accountPage = successPage.clickOnAccountSuccessContinueButton();
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickOnAccountContinueButton();
        logoutPage = accountPage.tapOnSideWidgetLinkByName("Logout");
        indexPage = logoutPage.clickOnAccountLogoutContinueButton();
        Assert.assertTrue(indexPage.assertLogoDisplayed());

    }

}
