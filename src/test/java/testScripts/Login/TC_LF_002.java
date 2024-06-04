package testScripts.Login;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(testComponents.Listeners.class)

public class TC_LF_002 extends BaseTest {

    LoginPage loginPage;

    @Test(dataProvider = "getData", groups = {"Login"}, description = "(TS_002) Login Functionality - Login Test With Invalid Credentials")
    public void LoginTestInvalidCredentials(HashMap<String, String> input) throws IOException {
        indexPage = new IndexPage(driver);
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        loginPage = indexPage.clickOnMyAccountAndLoginLink();
        loginPage.inputLoginApplication(input.get("emailAddress"), input.get("password"));
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.assertWarningConfirmationMsg());
        Assert.assertTrue(loginPage.getErrorWarningConfirmationMsg().contains(input.get("loginErrorMsg")));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testdata//Login.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{data.get(0)}, {data.get(1)}, {data.get(2)}}; //for array multiple data set in the json file
    }
}
