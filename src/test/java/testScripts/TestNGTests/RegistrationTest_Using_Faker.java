package testScripts.TestNGTests;/*
package testScripts.TestNGTests;


import pages.*;
import pages.HomePage;
import base.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class RegistrationTest_Using_Faker extends BaseTest{
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountCreatePage accountCreatePage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountSuccessPage accountSuccessPage;

    @Test(dataProvider = "getData", groups = {"createAnAccount"})
    public void registration(HashMap<String,String> input) throws IOException, InterruptedException {
        Faker fakerWithLocales = new Faker(Locale.UK);

        homePage = new HomePage();
        homePage.navigateToUrl(utilities.GlobalVars.getHomePageUrl());
        boolean status = homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl"));
        Assert.assertTrue(status);
        Assert.assertTrue(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        Assert.assertTrue(homePage.getPageHeaderTxt().trim().contains("FEATURED"));

        accountLoginPage = homePage.clickLoginOrRegisterLink();

        Assert.assertTrue(accountLoginPage.getPageHeaderTxt().trim().contains("ACCOUNT LOGIN"));

        Assert.assertTrue(accountLoginPage.getReturningCustomerTxt().trim().equalsIgnoreCase(input.get("returningCustomer")));
        Assert.assertTrue(accountLoginPage.getNewCustomerTxt().trim().equalsIgnoreCase(input.get("newCustomer")));
        Assert.assertTrue(accountLoginPage.isCheckoutOptionSelected());
        accountCreatePage = accountLoginPage.clickOnContinueButtonInAccountLoginPage();

        Assert.assertTrue(accountCreatePage.getPageHeaderTxt().trim().contains("CREATE ACCOUNT"));
        Assert.assertTrue(accountCreatePage.getCreateAccountTxt().contains(input.get("createAcc")));

        Assert.assertTrue(accountCreatePage.getYourPersonalDetailsTxt().contains(input.get("personalDetailsSection")));
        accountCreatePage.enterFirstName(fakerWithLocales.name().firstName());
        accountCreatePage.enterLastName(fakerWithLocales.name().lastName());
        accountCreatePage.inputEmailAddress(fakerWithLocales.internet().emailAddress());
        accountCreatePage.enterTelephoneNumber(fakerWithLocales.phoneNumber().cellPhone());
        accountCreatePage.enterFaxNumber(fakerWithLocales.phoneNumber().cellPhone());

        Assert.assertTrue(accountCreatePage.getYourAddressText().contains(input.get("addressSection")));
        accountCreatePage.enterCompanyName(fakerWithLocales.company().bs());
        accountCreatePage.enterAddress1(fakerWithLocales.address().streetAddress());
        accountCreatePage.enterAddress2(fakerWithLocales.address().secondaryAddress());
        accountCreatePage.enterCity(fakerWithLocales.address().city());
        accountCreatePage.selectRegionState(input.get("region"));
        accountCreatePage.enterPostalOrZipCode(input.get("postalCode"));
        accountCreatePage.selectCountry(input.get("country"));

        Assert.assertTrue(accountCreatePage.getLoginDetailsSectionTxt().contains(input.get("loginDetailSection")));
        accountCreatePage.inputLoginName(fakerWithLocales.name().username());
        accountCreatePage.enterPassword(input.get("password"));
        accountCreatePage.enterPasswordConfirm(input.get("conPassword"));


        Assert.assertTrue(accountCreatePage.getNewsletterTxt().contains(input.get("newsletterSection")));
        accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
        accountSuccessPage = accountCreatePage.clickOnContinueButtonInAccountCreatePage();

        Assert.assertTrue(accountSuccessPage.getPageHeaderTxt().trim().contains("YOUR ACCOUNT HAS BEEN CREATED!"));
        boolean status_accountSuccessfullyCreated = accountSuccessPage.getAccountHasBeenCreatedHeadingTxt().contains(input.get("accountSuccesfullyCreated"));
        Assert.assertTrue(status_accountSuccessfullyCreated);

        accountPage = accountSuccessPage.clickOnContinueAccountSuccessBtn();

        Assert.assertTrue(accountPage.getPageHeaderTxt().trim().contains("MY ACCOUNT"));
        boolean result = accountPage.getWelcomeMessageTxt().contains(input.get("welMsg"));
        Assert.assertTrue(result);

        accountLogoutPage = accountPage.clickOnLogoffBtn();

        Assert.assertTrue(accountLogoutPage.getPageHeaderTxt().trim().contains("ACCOUNT LOGOUT"));
        boolean status_logoutPageHeader = accountLogoutPage.getAccountLogoutTxt().equalsIgnoreCase(input.get("accountLogoutHeader"));
        Assert.assertTrue(status_logoutPageHeader);

        homePage = accountLogoutPage.clickOnLogoutContinueButton();

        Assert.assertTrue(homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl")));
        Assert.assertTrue(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        Assert.assertTrue(homePage.getPageHeaderTxt().trim().contains("FEATURED"));
    }
    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//automationteststore//data//createAnAccount.json");
        return new Object[][]  {{data.get(0)} };
        //return new Object[][]  {{data.get(0)}, {data.get(1)}}; // for array multiple data set in the json file
    }


}
*/
