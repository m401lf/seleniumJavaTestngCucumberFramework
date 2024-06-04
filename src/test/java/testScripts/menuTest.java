package testScripts;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.NavigationMenuPage;
import pages.TopMenuPage;

import java.io.IOException;

public class menuTest extends BaseTest {
    TopMenuPage naviPage;
    NavigationMenuPage navigationMenuPage;


    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown() throws IOException, InterruptedException {
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("MAKEUP", "Lips");
    }

    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown1() throws IOException, InterruptedException {
        naviPage = new TopMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("MAKEUP", "Nails");
    }

    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown2() throws IOException, InterruptedException {
        naviPage = new TopMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("SKINCARE", "Sun");
    }

    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown3() throws IOException, InterruptedException {
        naviPage = new TopMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("FRAGRANCE", "    Women");
    }

    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown4() throws IOException, InterruptedException {
        naviPage = new TopMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("HOME", "Account");
    }

    @Test
    public void mouseOverMenuAndClickAnItemFromDropdown5() throws IOException, InterruptedException {
        naviPage = new TopMenuPage(driver);
        navigationMenuPage = new NavigationMenuPage(driver);
        navigationMenuPage.hoverOverProductCategoryAndClickItemFromDropdownList("MEN", "    Skincare");
    }

}
