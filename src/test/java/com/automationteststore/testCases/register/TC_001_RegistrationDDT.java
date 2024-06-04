package com.automationteststore.testCases.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SuccessPage;
import pages.TopMenuPage;
import utilities.DataProviders;


@Listeners(base.Listeners.class)

public class TC_001_RegistrationDDT extends BaseTest {

    TopMenuPage naviPage;
    LoginPage loginPage;
    RegisterPage register;
    SuccessPage successPage;


    @Test(dataProvider = "RegisterData", dataProviderClass = DataProviders.class)
    public void verify_RegistrationDDT(
            String firstname,
            String lastname,
//            String telephone,
//            String fax,
//            String coyName,
//            String address1,
//            String address2,
//            String city,
//            String regionOrState,
//            String postcode,
//            String password,
            String exp) {

        //log.info("**** Starting TC_001_RegistrationDDT *****");

        try {
            naviPage = new TopMenuPage(driver);
            loginPage = naviPage.clickOnLoginOrRegisterLink();
            register = loginPage.clickOnContinueButtonInAccountLoginPage();
            register.enterFirstName(firstname);
            register.enterLastName(lastname);
            register.enterEmailAddress();
            register.enterTelephoneNumber(p.getProperty("telephone"));
            register.enterFaxNumber(p.getProperty("fax"));
            register.enterCompanyName(p.getProperty("companyName"));
            register.enterAddress1(p.getProperty("address1"));
            register.enterAddress2(p.getProperty("address2"));
            register.enterCity(p.getProperty("city"));
            register.selectRegionOrState(p.getProperty("province"));
            register.enterPostalOrZipCode(p.getProperty("postalCode"));
            register.inputUniqueLoginName();
            register.enterPassword(p.getProperty("password"));
            register.enterConfirmPassword(p.getProperty("password"));
            register.tickOnSubscribeAsYes();
            register.checkOnIAgreeToPrivacyPolicyRadioButton();
            successPage = register.clickContinueButtonInRegisterPage();

            boolean targetPage = successPage.assertPageHeaderIsDisplayed();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    successPage.clickContinueButtonInSuccessPage();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    successPage.clickContinueButtonInSuccessPage();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        //log.info("**** Finished TC_001_RegisterDDT *****");
    }

}








