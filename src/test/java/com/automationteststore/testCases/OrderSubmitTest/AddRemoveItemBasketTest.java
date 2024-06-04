package com.automationteststore.testCases.OrderSubmitTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.GlobalVars;

public class AddRemoveItemBasketTest extends BaseTest {

    String[] itemsNeeded = {"SKINSHEEN BRONZER STICK", "BENEFIT BELLA BAMBA", "ABSOLUE EYE PRECIOUS CELLS"};

    TopMenuPage naviPage;
    HomePage homePage;
    LoginPage loginPage;
    CheckoutConfirmationPage accountPage;
    CheckoutConfirmationPage checkoutConfirmationPage;


    @Test
    public void testAddRemoveItemBasket() {
        naviPage = new TopMenuPage(driver);
        homePage = new HomePage(driver);
        homePage.addProductToCart(GlobalVars.PRODUCTNAME_1);
        homePage.addProductToCart(GlobalVars.getBenefitBellaBamba());
        homePage.addProductToCart(GlobalVars.PRODUCTNAME_3);

        /////naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        loginPage = naviPage.clickCheckoutIcon();
        Assert.assertTrue(loginPage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly("Login"));
        Assert.assertTrue(loginPage.getNewCustomerTxt().contains("I AM A NEW CUSTOMER."));
        Assert.assertTrue(loginPage.getReturningCustomerTxt().contains("RETURNING CUSTOMER"));
        loginPage.enterLoginName(GlobalVars.getUserName());
        loginPage.enterPassword(GlobalVars.getPassword());
        accountPage = loginPage.clickLoginButton();
        /////naviPage.mouseHoverItemsDropdownLink();
        checkoutConfirmationPage = naviPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutConfirmationPage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly("Confirm"));
    }
}
