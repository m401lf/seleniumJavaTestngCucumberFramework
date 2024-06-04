package com.automationteststore.testCases.OrderSubmitTest;


import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.GlobalVars;

public class verifyItemsUnitAndTotalPricesAreDisplayedShippingCart extends BaseTest {
    TopMenuPage naviPage;
    HomePage homePage;
    CheckoutCartPage checkoutCartPage;


    @Test
    public void verifyUnitPrice() throws Exception {
        naviPage = new TopMenuPage(driver);
        naviPage.navigateToIndexPage();
        homePage = new HomePage(driver);
        homePage.addProductsToCart(GlobalVars.getAbsolueEyePreciousCells());
        homePage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        homePage.addProductsToCart(GlobalVars.getBenefitBellaBamba());
        homePage.addProductsToCart(GlobalVars.getSkinBronzerStick());
        //naviPage.mouseHoverItemsDropdownLink();
        Assert.assertTrue(naviPage.assertProductsAreDisplayed());
        Assert.assertTrue(naviPage.assertProductNamesAreDisplayed());
        checkoutCartPage = naviPage.clickOnViewCartLink();
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getAbsolueEyePreciousCells(), 10);
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getBenefitBellaBamba(), 7);
        checkoutCartPage.increaseOrDecreaseQuantityOfItemsInTheCart(GlobalVars.getSkinBronzerStick(), 5);

        checkoutCartPage.clickOnUpdateButton();
        checkoutCartPage.removeItemFromShippingCart((GlobalVars.getAbsolueEyePreciousCells()));
        checkoutCartPage.clickOnUpdateButton();
        checkoutCartPage.assertProductNameAndUnitPriceIsDisplayed(GlobalVars.getBenefitBellaBamba());
        checkoutCartPage.assertProductNameAndTotalPriceIsDisplayed(GlobalVars.getBenefitBellaBamba());

    }
}


