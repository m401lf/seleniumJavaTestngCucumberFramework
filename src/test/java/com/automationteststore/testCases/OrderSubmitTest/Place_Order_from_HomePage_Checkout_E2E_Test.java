package com.automationteststore.testCases.OrderSubmitTest;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;

public class Place_Order_from_HomePage_Checkout_E2E_Test extends BaseTest {

    String[] itemsNeeded = {"SKINSHEEN BRONZER STICK", "BENEFIT BELLA BAMBA", "ABSOLUE EYE PRECIOUS CELLS"};

    TopMenuPage naviPage;
    HomePage homePage;
    LoginPage loginPage;
    CheckoutConfirmationPage accountPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutConfirmationPage checkoutConfirmationPage;
    CheckoutCartPage checkoutCartPage;
    ProductCategoryPage productCategoryPage;
    CheckoutSuccessPage checkoutSuccessPage;


    @Test
    public void completeOrder1() throws IOException {
        naviPage = new TopMenuPage(driver);
        naviPage.navigateToIndexPage();
        homePage = new HomePage(driver);
        homePage.addProductsToCart(GlobalVars.getAbsolueEyePreciousCells());
        homePage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        homePage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        homePage.addProductsToCart(GlobalVars.getSkinBronzerStick());


        //////naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        Assert.assertTrue(naviPage.assertProductNamesAreDisplayed());

        loginPage = naviPage.clickCheckoutIcon();
        Assert.assertTrue(loginPage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly("Login"));
        Assert.assertTrue(loginPage.getNewCustomerTxt().contains("I AM A NEW CUSTOMER."));
        Assert.assertTrue(loginPage.getReturningCustomerTxt().contains("RETURNING CUSTOMER"));
        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getPassword());
        accountPage = loginPage.clickLoginButton();
       ///// naviPage.mouseHoverItemsDropdownLink();
        checkoutConfirmationPage = naviPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutConfirmationPage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly("Confirm"));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
        boolean status_orderNumber = checkoutSuccessPage.getOrderNumberText().contains("Your order #");
        AssertionHelper.updateTestStatus(status_orderNumber);
        AssertionHelper.updateTestStatus(checkoutSuccessPage.assertThankYouForShoppingWithUsTextIsDisplayed());
        checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();
        AssertionHelper.updateTestStatus(homePage.getThisPageUrl().contains("https://automationteststore.com/"));
        AssertionHelper.updateTestStatus(homePage.getThisPageTitle().contains("A place to practice your automation skills!"));

    }
}