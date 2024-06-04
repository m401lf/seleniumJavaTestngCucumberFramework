package testScripts.Registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(base.Listeners.class)
public class RegistrationTestUsingJsonInput extends BaseTest {
    IndexPage indexPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Test(dataProvider = "getData", groups = {"Register"}, description = "Registration Test Using Json Inputs")
    public void RegistrationTestUsingJsonInput(HashMap<String, String> input) throws Exception {
        //navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
        Assert.assertEquals(indexPage.getCurrentPageUrl(), (input.get("pageUrl")));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        registerPage = indexPage.clickMyAccountAndRegisterLink();
        Assert.assertTrue(registerPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
        Assert.assertTrue(registerPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
        Assert.assertTrue(registerPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
        registerPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        //registerPage.inputTelephone(input.get("tel"));
        Assert.assertTrue(registerPage.getPasswordSectionTxt().contains("Your Password"));
        registerPage.inputPassword(input.get("password"));
        registerPage.inputConfirmPassword(input.get("password"));
        Assert.assertTrue(registerPage.assertNewsletterHeaderTextDisplayed());
        Assert.assertTrue(registerPage.assertNoRadioButtonSelected());
        registerPage.tickOnYesSubscribeRadioButton();
        Assert.assertTrue(registerPage.assertYesRadioButtonSelected());
        Assert.assertTrue(registerPage.assertSubscribeButtonSelected());
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        Assert.assertTrue(registerPage.assertPrivacyPolicyRadioBtnSelected());
        Assert.assertTrue(registerPage.assertContinueButtonIsDisplayed());
        successPage = registerPage.clickOnContinueButton();
        Assert.assertTrue(successPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(successPage.assertContinueButtonIsEnabledAndDisplayed());
        accountPage = successPage.clickOnAccountSuccessContinueButton();
        Assert.assertTrue(accountPage.assertMyAccountTxtIsDisplayed());
        editPage = accountPage.tapOnEditAsideWidgetLink();
        Assert.assertTrue(editPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(editPage.assertContinueButtonDisplayed());
        accountPage = editPage.clickOnAccountContinueButton();
        Assert.assertTrue(accountPage.assertMyAccountTxtIsDisplayed());
        logoutPage = accountPage.tapOnSideWidgetLinkByName("Logout");
        Assert.assertTrue(logoutPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(logoutPage.assertContinueButtonIsEnabledAndDisplayed());
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testdata//Register.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{data.get(0)}, {data.get(0)}}; //for array multiple data set in the json file
    }

}
