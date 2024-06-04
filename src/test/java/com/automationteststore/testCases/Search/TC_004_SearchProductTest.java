package com.automationteststore.testCases.Search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import pages.SearchWidgetPage;
import pages.TopMenuPage;

@Listeners(base.Listeners.class)

@Test
public class TC_004_SearchProductTest extends BaseTest {
    SearchResultPage searchResultPage;
    SearchWidgetPage searchWidgetPage;
    TopMenuPage naviPage;

    public void test_productSearch() {
        //log.info(" Starting TC_004_SearchProductTest ");

        try {

            naviPage = new TopMenuPage(driver);
            searchWidgetPage = new SearchWidgetPage(driver);
            searchWidgetPage.enterSearchKeyword("men");
            searchResultPage = searchWidgetPage.clickSearchButton();

            searchResultPage.isProductExist("MacBook");

            Assert.assertTrue(searchResultPage.isProductExist("MacBook"));

        } catch (Exception e) {
            Assert.fail();
        }

        //log.info(" Finished TC_004_SearchProductTest ");

    }
}
