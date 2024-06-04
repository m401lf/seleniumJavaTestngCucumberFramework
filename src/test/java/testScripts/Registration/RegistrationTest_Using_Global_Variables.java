package testScripts.Registration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(testComponents.Listeners.class)
public class RegistrationTest_Using_Global_Variables extends BaseTest {

    IndexPage indexPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    AccountPage accountPage;
    EditPage editPage;
    LogoutPage logoutPage;

    @Test(dataProvider = "getData", groups = {
            "Register"}, description = "Registration Test Using Global Input")
    public void RegistrationTestUsingGlobalVariables(HashMap<String, String> input) throws Exception {
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (GlobalVars.getHomePageTitle()));
        Assert.assertEquals(indexPage.getCurrentPageUrl(), (GlobalVars.getHomePageUrl()));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        registerPage = indexPage.clickMyAccountAndRegisterLink();
        Assert.assertTrue(indexPage.getCurrentPageTitle().contains(GlobalVars.getAccountCreatePageTitle()));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains(GlobalVars.getAccountCreatePageUrl()));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        Assert.assertTrue(indexPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(registerPage.assertYourPersonalDetailsIsDisplayed());
        registerPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        registerPage.inputPassword(input.get("password"));
        registerPage.inputConfirmPassword(input.get("password"));
        registerPage.tickOnYesSubscribeRadioButton();
        registerPage.clickOnAgreeToPrivacyPolicyButton();
        successPage = registerPage.clickOnContinueButton();
        accountPage = successPage.clickOnAccountSuccessContinueButton();
        editPage = accountPage.tapOnEditAsideWidgetLink();
        accountPage = editPage.clickOnAccountContinueButton();
        logoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
        indexPage = logoutPage.clickAccountLogoutContinueBtn();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testdata//Register.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{data.get(0)}, {data.get(0)}}; //for array multiple data set in the json file
    }

}
    


