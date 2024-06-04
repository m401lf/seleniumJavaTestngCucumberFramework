package com.automationteststore.testCases.Login;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(base.Listeners.class)

public class LoginTestWithValidCredentialsWithJsonInput extends BaseTest {

    TopMenuPage naviPage;
    AsideWidgetPage asideWidgetPage;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage accountPage;
    LogoutPage logoutPage;
    EditProfilePage editPage;

    @Test(description = "Login test with valid credentials", dataProvider = "getData", groups = {"LoginPositive"})
    public void loginTestValidCredentials(HashMap<String, String> input) throws Exception {
        naviPage = new TopMenuPage(driver);
        //loginPage = naviPage.hoverOverAccountLinkAndClickLoginLink();
        accountPage = loginPage.loginApplication(input.get("emailAddress"), input.get("password"));
        editPage = accountPage.clickOnEditAccountDetailsLink();
        accountPage = editPage.clickOnContinueEditBtn();
        logoutPage = new AsideWidgetPage(driver).tapLogoffLink();
        homePage = logoutPage.clickOnLogoutContinueButton();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//testData//data//LoginPositive.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]{{data.get(0)}, {data.get(0)}}; //for array multiple testData.data set in the json file

    }

}