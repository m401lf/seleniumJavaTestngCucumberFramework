package com.automationteststore.cucumber.stepDefinitions;

import base.BaseTest;
import helper.assertion.AssertionHelper;
import helper.javaScript.JavaScriptHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;
import utilities.GlobalVars;

import java.io.IOException;
import java.util.List;


public class e2eSteps extends BaseTest {
    public LoginPage loginPage;
    public HomePage homePage;
    public MyAccountPage accountPage;
    public ForgottenPasswordPage forgottenPasswordPage;
    public ForgottenLoginnamePage forgottenLoginnamePage;
    public RegisterPage registerPage;
    public EditProfilePage editPage;
    public LogoutPage logoutPage;
    public SuccessPage successPage;
    public CheckoutCartPage checkoutCartPage;
    public CheckoutCustomerPage checkoutCustomerPage;
    public CheckoutConfirmationPage checkoutConfirmationPage;
    public CheckoutPage checkoutPage;
    public CheckoutSuccessPage checkoutSuccessPage;
    public ProductCategoryPage productCategoryPage;
    TopMenuPage naviPage;
    ShoppingCartPage shoppingCartPage;

    @Given("I am on ecommerce website")
    public void iAmOnEcommerceWebsite() throws IOException {
        naviPage = new TopMenuPage(driver);
        naviPage = launchApplication();
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));
        new JavaScriptHelper(driver).scrollToElement(products.get(0));


    }

    @Given("I am back on ecommerce website")
    public void iAmBackOnEcommerceWebsite() {
        AssertionHelper.updateTestStatus(naviPage.getThisPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl()));
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle()));
        driver.quit();
    }

    @When("I can see page title {string} and page url {string} in the Home page")
    public void i_can_see_page_title_and_page_url(String pageTitle, String pageUrl) {
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().contains(pageTitle));
        AssertionHelper.updateTestStatus(naviPage.getThisPageUrl().contains(pageUrl));
    }

    @Given("I can see in current page title and url as follows:")
    public void i_can_see_in_current_page_title_and_url_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(naviPage.getThisPageTitle().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(naviPage.getThisPageUrl().contains(dataTable.cell(1, 0)));

    }


    @When("I search with a keyword {string}")
    public void iMoveToTheSearchAndInputAKeyword(String item) {

    }


    @And("I add product {string}, {string} and {string} to cart")
    public void iAddAnItemToCart(String productName0, String productName1, String productName2) {
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
        productCategoryPage.addProductToCart(productName2);
    }

    @And("I add products {string} and {string} to cart")
    public void iAddProductsToCart(String productName0, String productName1) {
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
    }

    @And("I add products {string} and {string} and {string} to basket")
    public void iAddSomeProductsToBasket(String productName0, String productName1, String productName2) {
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
        productCategoryPage.addProductToCart(productName2);
    }

    @And("I add products to cart {string}, {string} and {string}")
    public void i_add_products_to_cart_and(String productName0, String productName1, String productName2) {
        homePage = new HomePage(driver);
        homePage.addProductsToCart(productName0);
        homePage.addProductsToCart(productName1);
        homePage.addProductsToCart(productName2);

    }

    @And("I scroll to the products view")
    public void iScrollToProductView() {
        List<WebElement> products = homePage.getProductList();
        new JavaScriptHelper(driver).scrollToElement(products.get(0));

    }

    @And("I add the following items to cart:")
    public void i_add_products_to_cart(DataTable dataTable) {
        homePage = new HomePage(driver);
        homePage.addProductToCart(dataTable.cell(0, 0));
        homePage.addProductToCart(dataTable.cell(1, 0));
        homePage.addProductToCart(dataTable.cell(2, 0));

    }

    @Given("can see No Of Items in Cart and Total Amount are displayed as follows:")
    public void can_see_no_of_items_in_cart_and_total_amount_are_displayed_as_follows(DataTable dataTable) {
        AssertionHelper.updateTestStatus(dataTable.cell(1, 0).contains(naviPage.getCartTotalAmountText()));
        AssertionHelper.updateTestStatus(dataTable.cell(2, 0).contains(naviPage.getCartTotalQuantityText()));

    }

    @And("I hoverOver items cart and click on checkout icon from dropdown")
    public void i_hoverOver_items_cart_and_click_on_checkout_icon_from_dropdown() {
        checkoutPage = naviPage.mouseOverItemsCartLinkAndClickCheckoutIcon();
    }

    @And("I hoverOver items cart and click on view Cart icon from dropdown")
    public void i_hoverOver_items_cart_and_click_on_view_Cart_icon_from_dropdown() {
        shoppingCartPage = naviPage.mouseOverItemsCartLinkAndClickViewCartIcon();
    }

    @When("I should see {} in checkout confirmation page")
    public void iShouldSeeInCheckoutConfirmationPage(String pageHeaderTitle) {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getOrderSummaryText().equalsIgnoreCase(pageHeaderTitle));


    }

    @And("I click on Checkout Icon button")
    public void iClickCheckoutIconButton() {
        loginPage = naviPage.clickCheckoutIcon();

    }

    @And("I click Checkout Icon button")
    public void clickCheckoutIconButton() throws IOException {
        loginPage = naviPage.clickCheckoutCartDropdownIconButton();

    }

    @And("I click View Cart Icon button")
    public void clickViewCartIconButton() throws IOException {
        shoppingCartPage = naviPage.clickViewCartDropdownIconButton();

    }


    @When("I login in login page as a returning customer:")
    public void i_login_in_login_page_as_a_returning_customer(DataTable dataTable) throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.enterLoginName(dataTable.cell(1, 0));
        loginPage.enterPassword(dataTable.cell(1, 1));
        checkoutConfirmationPage = loginPage.clickLoginButton();

    }


    @And("I navigate to shopping page")
    public void iNavigateToShoppingPage() throws IOException {
        naviPage.mouseOverItemLink();
        checkoutCartPage = naviPage.clickOnViewCartLink();

    }

    @And("I increased quantity by {}")
    public void iInputInQuantityFieldAndIncreasedBy(int number) {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.inputItemQuantity(number);

    }

    @And("I update {string} quantity in cart by {}")
    public void iUpdateProductQtyInTheCart(String productName, int qty) throws InterruptedException {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.updateQuantityOfProductInTheCart(productName, qty);

    }

    @Given("I can see product {string} and per unit price {}")
    public void i_can_see_product_and_per_unit_price(String productName, String unitPrice) {
        Assert.assertTrue(shoppingCartPage.getUnitPriceOfProductInTheCart(productName).equalsIgnoreCase(unitPrice));
    }

    @Given("verify the product name {string} and the model {}")
    public void verify_the_product_name_and_the_model(String productName, String productModel) {
        //Assert.assertEquals(shoppingCartPage.getTotalProductPriceInTheCart(productName), productModel);
        Assert.assertEquals(shoppingCartPage.getProductModelInTheCart(productName), productModel);


    }

    @Given("I should see the product name {string} in the cart")
    public void i_can_see_product_and_total_price(String productName) {
        Assert.assertTrue(shoppingCartPage.getNameOfProductsInTheCart(productName).contains(productName));

    }

    @Given("can see {string} product model as {string}")
    public void can_see_product_model_as(String productName, String modelNumber) {
        Assert.assertEquals(shoppingCartPage.getNameOfProductsInTheCart(productName), productName);
        Assert.assertEquals(shoppingCartPage.getProductModelInTheCart(productName), modelNumber);
        //Assert.assertEquals(shoppingCartPage.getProductModelNumberInTheCart(modelNumber),modelNumber);

    }

    @Given("I can see product {string} and total price {}")
    public void i_can_see_product_and_total_price(String productName, String totalPrice) {
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProductInTheCart(productName), totalPrice);

    }

    @Given("click on update button")
    public void click_on_update_button() {
        shoppingCartPage.clickOnUpdateButton();
    }

    @Given("click {string} button")
    public void click_update_button(String updateBtn) {
        Assert.assertEquals(shoppingCartPage.getUpdateButtonText(), updateBtn);
        shoppingCartPage.clickOnUpdateButton();
    }

    @Given("I can see current page submenu breadcrumbs {string} are correctly displayed")
    public void i_can_see_current_page_submenu_breadcrumbs_are_correctly_displayed(String breadcrumbText) {
        shoppingCartPage = new ShoppingCartPage(driver);
        AssertionHelper.updateTestStatus(shoppingCartPage.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(breadcrumbText));
    }

    @And("I reduced quantity by {int}")
    public void iReducedQuantityBy(int number) {
        shoppingCartPage.inputItemQuantity(number);

    }

    @And("I removed {string} item from cart")
    public void iRemovedSomeItemsFromCart(String productName) throws InterruptedException {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeProductFromCart(productName);

    }


    @And("I can see {string} and {string} in login page")
    public void iCanSeeReturningCustomerAndNewCustomerText(String returningCustomerTxt, String newCustomerTxt) {
        loginPage = new LoginPage(driver);
        boolean status_returningCustomer = loginPage.getReturningCustomerTxt().equalsIgnoreCase(returningCustomerTxt);
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = loginPage.getNewCustomerTxt().equalsIgnoreCase(newCustomerTxt);
        AssertionHelper.updateTestStatus(status_newCustomer);

    }

    @And("I can see {string}, {string}, {string}, {string}, {string} and {string} buttons are displayed")
    public void iCanSeeAndButtonsAreDisplayed(String editShippingTxt, String editPayTxt, String editCoupTxt, String editCartTxt, String backArrowBtnTxt, String confirmOrderBtnTxt) {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditShippingButtonText().trim().contains(editShippingTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditPaymentButtonText().trim().contains(editPayTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCouponButtonText().trim().contains(editCoupTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getEditCartButtonText().trim().contains(editCartTxt));
        Assert.assertTrue(checkoutConfirmationPage.getBackArrowButtonText().contains(backArrowBtnTxt));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().trim().contains(confirmOrderBtnTxt));
    }

    @And("I click on confirm order button")
    public void iClickOnConfirmOrderButton() throws IOException {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().contains("Confirm"));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @And("I tap on {string}")
    public void iTapConfirmOrderButtonCheckoutConfirmationPage(String confirmOrderButtonText) throws IOException {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().contains(confirmOrderButtonText));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @And("I am presented with {}")
    public void iAmPresentedWithAnOderNumber(String orderNumberMsg) {
        boolean status = checkoutSuccessPage.getOrderNumberText().contains(orderNumberMsg);
        AssertionHelper.updateTestStatus(status);

    }

    @And("I click on continue Button")
    public void iClicksOnContinueAndLogoutButton() throws IOException {
        System.out.println(checkoutSuccessPage.getContinueButtonText());
        homePage = checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();

    }

    @And("I click on {} button")
    public void iClicksOnContinueAndLogoutButton(String continueButton) throws IOException {
        AssertionHelper.updateTestStatus(checkoutSuccessPage.getContinueButtonText().contains(continueButton));
        homePage = checkoutSuccessPage.clickOnContinueCheckoutSuccessButton();


    }

    @And("I am back to home page")
    public void iAmBackToHomePage() {
        naviPage = new TopMenuPage(driver);


    }

    @And("I tap on checkout button")
    public void iTapOnCheckoutButton() {
        loginPage = shoppingCartPage.clickOnCheckoutButton();

    }

    @And("I tap {} button")
    public void iTapCheckoutButton(String checkoutBtn) throws IOException {
        Assert.assertEquals(shoppingCartPage.getCheckoutButtonText(), checkoutBtn);
        loginPage = shoppingCartPage.clickOnCheckoutButton();
        takeSnapShot(driver);

    }

    @And("I login with {string} and {string} as a returning customer")
    public void iLoginWithAsAReturningCustomer(String loginname, String password) throws IOException {
        loginPage.enterLoginName(loginname);
        loginPage.enterPassword(password);
        checkoutConfirmationPage = loginPage.clickLoginButton();
    }

    @Given("I can see {} and {} in login page")
    public void i_can_see_returning_customer_and_i_am_a_new_customer(String returning_customer, String new_customer) {
        Assert.assertEquals(loginPage.getReturningCustomerTxt(), returning_customer);
        Assert.assertEquals(loginPage.getNewCustomerTxt(), new_customer);

    }

    @And("I should be on {} in the Checkout Confirmation page")
    public void iShouldBeOnCheckoutConfirmationPage(String headerTxt) {
        Assert.assertEquals(checkoutConfirmationPage.getPageHeadingText(), headerTxt);

    }

    @And("I can see {} is Displayed")
    public void iCanSeeYourOrderHasBeenProcessedDisplayed(String yourOrderHasBeenProcessedText) throws InterruptedException {
        Assert.assertTrue(checkoutSuccessPage.getYourOrderHasBeenProcessedText().trim().contains(yourOrderHasBeenProcessedText));
        System.out.println(checkoutSuccessPage.getYourOrderHasBeenProcessedText());
    }


}



