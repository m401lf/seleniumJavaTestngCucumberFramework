package com.automationteststore.testCases.Search;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import pages.SearchWidgetPage;
import pages.TopMenuPage;

import java.io.IOException;

@Listeners(base.Listeners.class)

public class SearchTest extends BaseTest {
    TopMenuPage naviPage;
    SearchWidgetPage searchWidget;
    SearchResultPage searchResultPage;

    @Test(priority = 1)
    public void verifySearchWithValidProduct() throws IOException {
        naviPage = new TopMenuPage(driver);
        searchWidget = new SearchWidgetPage(driver);
        searchResultPage = searchWidget.SearchWithInvalidKeyword(dataProp.getProperty("validProduct"));
        //Assert.assertTrue(searchResultPage.displayStatusOfHPValidProduct(), "Valid product HP is not displayed in the search results");

    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() throws IOException {
        naviPage = new TopMenuPage(driver);
        searchResultPage = searchWidget.SearchWithInvalidKeyword(dataProp.getProperty("invalidProduct"));
        //Assert.assertEquals(searchResultPage.retrieveNoProductMessageText(), "There is no product that matches the search criteria.", "No product message in search results is not displayed");

    }

    @Test(priority = 3, dependsOnMethods = {"verifySearchWithValidProduct", "verifySearchWithInvalidProduct"})
    public void verifySearchWithoutAnyProduct() throws IOException {
        naviPage = new TopMenuPage(driver);
        searchResultPage = searchWidget.clickSearchButton();
        //Assert.assertEquals(searchResultPage.retrieveNoProductMessageText(), dataProp.getProperty("NoProductTextInSearchResults"), "No product message in search results is not displayed");

    }

}
