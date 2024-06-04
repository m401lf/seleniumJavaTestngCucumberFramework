package com.automationteststore.testCases.OrderSubmitTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopMenuPage;

import java.util.List;
import java.util.Objects;


public class addToCart extends BaseTest {
	TopMenuPage naviPage;
	HomePage homePage;
	String productName1 = "ABSOLUE EYE PRECIOUS CELLS";
	String productName2 = "TOTAL MOISTURE FACIAL CREAM";


	@Test(priority = 1)
	public void add_To_Cart() {

		naviPage = new TopMenuPage(driver);
		homePage = new HomePage(driver);
		List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

		WebElement prod = products.
				stream()
				.parallel()
				.filter(product -> product.findElement(By.cssSelector("a")).getText().contains(productName1))
				.findFirst().orElse(null);
		assert prod != null;
		prod.findElement(By.cssSelector("a.productcart")).click();



	}

	@Test(priority = 2)
	public void add2Cart() {
		naviPage = new TopMenuPage(driver);
		homePage = new HomePage(driver);
		List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

		Objects.requireNonNull(products.stream()
				.filter(product -> product.findElement(By.cssSelector("a")).getText().contains(productName2))
				.findFirst().orElse(null)).findElement(By.cssSelector("a.productcart")).click();

	}

}
