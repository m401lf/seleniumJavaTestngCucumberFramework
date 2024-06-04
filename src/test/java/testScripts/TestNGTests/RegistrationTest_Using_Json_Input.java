package testScripts.TestNGTests;/*
package testScripts.TestNGTests;


import pages.*;
import pages.HomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RegistrationTest_Using_Json_Input extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountCreatePage accountCreatePage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountSuccessPage accountSuccessPage;

    @Test(dataProvider = "getData", groups = {"createAnAccount"})
    public void registration(HashMap<String,String> input) throws IOException, InterruptedException {
        homePage = new HomePage();
        boolean status = homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl"));
        Assert.assertTrue(status);
        Assert.assertTrue(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        accountLoginPage = homePage.clickLoginOrRegisterLink();

        Assert.assertTrue(accountLoginPage.getReturningCustomerTxt().trim().equalsIgnoreCase(input.get("returningCustomer")));
        Assert.assertTrue(accountLoginPage.getNewCustomerTxt().trim().equalsIgnoreCase(input.get("newCustomer")));
        Assert.assertTrue(accountLoginPage.isCheckoutOptionSelected());
        accountCreatePage = accountLoginPage.clickOnContinueButtonInAccountLoginPage();

        boolean continueBtnNotDisplayed = accountLoginPage.isContinueButtonNotDisplayed();
        Assert.assertFalse(continueBtnNotDisplayed, "Continue button is present in the page");

        boolean status_returningCustomerNotDisplayed = accountLoginPage.isReturningCustomerNotDisplayed();
        Assert.assertFalse(status_returningCustomerNotDisplayed, "Element is not present in the page");

        Assert.assertTrue(accountCreatePage.getCreateAccountTxt().contains(input.get("createAcc")));

        Assert.assertTrue(accountCreatePage.getYourPersonalDetailsTxt().contains(input.get("personalDetailsSection")));
        accountCreatePage.enterFirstName(input.get("fName"));
        accountCreatePage.enterLastName(input.get("lName"));
        accountCreatePage.enterEmailAddress();
        accountCreatePage.enterTelephoneNumber(input.get("tel"));
        accountCreatePage.enterFaxNumber(input.get("fax"));

        Assert.assertTrue(accountCreatePage.getYourAddressText().contains(input.get("addressSection")));

        accountCreatePage.enterCompanyName(input.get("coyName"));
        accountCreatePage.enterAddress1(input.get("addr1"));
        accountCreatePage.enterAddress2(input.get("addr2"));
        accountCreatePage.enterCity(input.get("city"));
        accountCreatePage.selectRegionState(input.get("region"));
        accountCreatePage.enterPostalOrZipCode(input.get("postalCode"));
        accountCreatePage.selectCountry(input.get("country"));

        Assert.assertTrue(accountCreatePage.getLoginDetailsSectionTxt().contains(input.get("loginDetailSection")));
        accountCreatePage.enterLoginName();
        accountCreatePage.enterPassword(input.get("password"));
        accountCreatePage.enterPasswordConfirm(input.get("conPassword"));

        Assert.assertTrue(accountCreatePage.getNewsletterTxt().contains(input.get("newsletterSection")));

        accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
        accountSuccessPage = accountCreatePage.clickOnContinueButtonInAccountCreatePage();
        boolean result1 = accountSuccessPage.getAccountHasBeenCreatedHeadingTxt().contains(input.get("accountSuccessfullyCreated"));
        Assert.assertTrue(result1);

        accountPage = accountSuccessPage.clickOnContinueAccountSuccessBtn();

        boolean result = accountPage.getWelcomeMessageTxt().contains(input.get("welMsg"));
        Assert.assertTrue(result);

        accountLogoutPage = accountPage.clickOnLogoffBtn();
        boolean result_logoutPageHeader = accountLogoutPage.getAccountLogoutTxt().equalsIgnoreCase(input.get("accountLogoutHeader"));
        Assert.assertTrue(result_logoutPageHeader);
        homePage = accountLogoutPage.clickOnLogoutContinueButton();

        Assert.assertTrue(homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl")));
        Assert.assertTrue(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//automationteststore//data//createAnAccount.json");
        return new Object[][]  {{data.get(0)} };
        // return new Object[][]  {{data.get(0)}, {data.get(0)}}; for array multiple data set in the json file
    }


}
*/
