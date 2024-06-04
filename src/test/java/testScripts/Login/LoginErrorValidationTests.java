package testScripts.Login;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;
@Listeners(testComponents.Listeners.class)

public class LoginErrorValidationTests extends BaseTest {

    LoginPage loginPage;
    Faker faker;

    // @Test(invocationCount = 2)
    @Test(description = "Login Test With Invalid Credentials")
    public void LoginTestWithInvalidCredentials(Method method) throws IOException {
        faker = new Faker(Locale.UK);
        navigateToGivenApplicationUrl(GlobalVars.getHomePageUrl());
        indexPage = new IndexPage(driver);
        loginPage = indexPage.tapOnAnItemFromTopMenuAndClickItemFromDropdownList("My Account", "Login");
        loginPage.inputLoginApplication(faker.internet().emailAddress(), GlobalVars.getWrongPass());
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.assertWarningConfirmationMsg());
        Assert.assertTrue(loginPage.getErrorWarningConfirmationMsg().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg()));
    }
}
