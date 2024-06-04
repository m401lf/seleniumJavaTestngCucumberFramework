package testScripts.TestNGTests;/*
package testScripts.TestNGTests;


import pages.*;
import pages.HomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.GlobalVars;

import java.io.IOException;

public class Place_Order_from_HomePage_E2E_Test extends BaseTest {
    String[] itemsNeeded= {"SKINSHEEN BRONZER STICK","BENEFIT BELLA BAMBA","ABSOLUE EYE PRECIOUS CELLS"};
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    CheckoutConfirmationPage checkoutConfirmationPage;
    CheckoutCartPage checkoutCartPage;
    ProductCategoryPage productCategoryPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Test
    public void completeOrder() throws IOException {
        homePage = new HomePage();
        boolean status_url = homePage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        Assert.assertTrue(status_url);
        boolean status_title = homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        Assert.assertTrue(status_title);

        */
/*homePage.moveToElement(driver, homePage.account_link);
        homePage.verifyItemPresentInList(homePage.subMenuList, "Tiger");
        homePage.readValueFromElement(homePage.account_link);
        homePage.clickOnTextFromDropdownList(homePage.account_link, "Login");
        homePage.mouseover(driver, homePage.account_link);
        homePage.clickOnMenu(homePage.getHairCare());*//*



 */
/*homePage.moveToElement(driver, homePage.getMakeup());
        homePage.mouseover(driver, homePage.getMakeup());
        homePage.clickOnItem("Lips");*//*


        //homePage.clickOnTextFromDropdownList(homePage.makeup, "Nails");

        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_1);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_2);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_3);

        checkoutCartPage = homePage.clickCartLink();
        checkoutCartPage.inputItemQuantity(4);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.inputItemQuantity(2);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.clickOnRemoveIconBtn();

        accountLoginPage = checkoutCartPage.clickOnCheckoutBtn();

        boolean status_returningCustomer = accountLoginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        Assert.assertTrue(status_returningCustomer);
        boolean status_newCustomer = accountLoginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        Assert.assertTrue(status_newCustomer);
        accountLoginPage.enterLoginName(GlobalVars.getUserName());
        accountLoginPage.enterPassword(GlobalVars.getPassword());
        checkoutConfirmationPage = accountLoginPage.clickLoginButton();
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();

        boolean status_orderNunber = checkoutSuccessPage.getOrderNumberTxt().contains("Your order #");
        Assert.assertTrue(status_orderNunber, "Order numder is not contained and displayed");

        Assert.assertTrue(checkoutSuccessPage.assertThankYouForShoppingWithUsTxt().contains("Thank you for shopping with us!"), "Thank you message is not contained and displayed");
        Assert.assertTrue(checkoutSuccessPage.verifyThankYouForShoppingWithUsTxt());
        checkoutSuccessPage.clickOnContinueCheckoutSuccessBtn();

        Assert.assertTrue(homePage.getCurrentPageUrl().contains("https://com/"));
        Assert.assertTrue(homePage.getCurrentPageTitle().contains("A place to practice your automation skills!"));
    }
}*/
