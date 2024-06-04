package com.automationteststore.testCases.OrderSubmitTest;

import base.BaseTest;
import helper.javaScript.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopMenuPage;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;

public class add_Multiple_Items_To_Cart extends BaseTest{
    TopMenuPage naviPage;
    HomePage homePage;
    String productName1 = "ABSOLUE EYE PRECIOUS CELLS";
    String productName2 = "TOTAL MOISTURE FACIAL CREAM";



    @Test()
    public void add_To_Cart() {
        naviPage = new TopMenuPage(driver);
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

        WebElement prod1 = products
                .stream()
                .parallel()
                .filter(product -> product.findElement(By.cssSelector("a")).getText().contains(productName1))
                .findFirst()
                .orElse(null);
        assert prod1 != null;
        prod1.findElement(By.cssSelector("a.productcart")).click();

        WebElement prod2 = products
                .stream()
                .parallel()
                .filter(product-> product.findElement(By.cssSelector("a")).getText().contains(productName2))
                .findFirst()
                .orElse(null);
        assert prod2 != null;
        prod2.findElement(By.cssSelector("a.productcart")).click();


    }

}
