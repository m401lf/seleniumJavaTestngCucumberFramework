package pages;

import base.BasePage;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CheckoutConfirmationPage extends BasePage {
    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(CheckoutConfirmationPage.class);

    @FindBy(css = "h2[class='heading2'] span")
    public WebElement orderSummaryText;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/h1/span[1]")
    public WebElement pageHeading;
    @FindBy(css = ".align_right.valign_top")
    public List<WebElement> orderSummaryUnitPriceList;
    @FindBy(css = "p > a > b")
    public WebElement returnPolicyLink;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[3]/tbody/tr/td[2]/a")
    public List<WebElement> itemsInYourCartList;
    @FindBy(linkText = "Items in your cart")
    public WebElement itemsInYourCartTxt;

    @FindBy(xpath = "//td[@class='align_left valign_top']//a[contains(text(),'Total Moisture Facial Cream')]")
    public WebElement orderSummaryProductName;
    @FindBy(css = ".bold.extra.totalamout")
    public WebElement totalPriceLabel;
    @FindBy(css = "[class='bold totalamout']")
    public WebElement totalAmt;
    @FindBy(linkText = "Sub-Total:")
    public WebElement subTotal;
    @FindBy(css = ".align_left.valign_top")
    public WebElement orderSummaryNoOfItems;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/table[2]/tbody/tr[2]/td[2]/span")
    public WebElement flatShippingRate;

    @FindBy(partialLinkText = "tota")
    public WebElement total;
    @FindBy(partialLinkText = "Edit Pay")
    public WebElement editPaymentBtn;
    @FindBy(partialLinkText = "Edit Ship")
    public WebElement editShippingBtn;
    @FindBy(partialLinkText = "Edit Ship")
    public WebElement editShippingButton;
    @FindBy(partialLinkText = "Edit Car")
    public WebElement editCartBtn;
    @FindBy(partialLinkText = "Edit Coup")
    public WebElement editCouponBtn;
    @FindBy(id = "back")
    public WebElement backArrowBtn;
    @FindBy(css = "[title='Confirm Order']")
    public WebElement confirmOrderButton;
    @FindBy(xpath = "//h4[normalize-space()='Payment']")
    public WebElement paymentHeader;
    @FindBy(xpath = "//h4[normalize-space()='Shipping']")
    public WebElement shippingHeader;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement qtyProductWithStockLocations;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    public List<WebElement> ShippingPaymentItemsInYourCartText;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[2]/ul/li")
    public WebElement currencyDropdownBtn;


//=========================================================
    @FindBy(css = "button#checkout_btn")
    public WebElement confirmOrder_button;
    @FindBy(css = "button.btn.btn-orange.pull-right.lock-on-click")
    public WebElement confirm_Order_button;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li/a")
    public WebElement itemsCartIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/h1/span[1]")
    public WebElement checkoutConfirmationHeadingTxt;
    @FindBy(css = "//*[@id='maincontainer']/div/div[1]/div/div[2]/p")
    public WebElement clickingConfirmOrderReturnPolicyText;
    @FindBy(xpath = "//b[contains(text(),'Return Policy')]")
    public WebElement returnPolicyTxtLink;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[1]/tbody/tr/td[4]/a")
    public WebElement editShipmentIcon;
    @FindBy(xpath = "//h4[contains(text(),'Shipping')]")
    public WebElement shippingTxt;
    @FindBy(css = "//h4[contains(text(),'Payment')]")
    public WebElement paymentTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[1]")
    public WebElement editPaymentIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[2]")
    public WebElement editCouponIcon;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/h4[3]/a")
    public WebElement editCartIcon;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div[2]/table[3]/tbody/tr/td[4]")
    public List<WebElement> items_In_Your_Cart_List;
    @FindBy(xpath = "/html//a[@id='back']")
    public WebElement backArrowButton;
    @FindBy(css = "span.bold.totalamout")
    public List<WebElement> totalPriceAndAmountTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[1]/span")
    public WebElement totalPriceTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[2]/span")
    public WebElement amountTxt;

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getOrderSummaryText() {
        return verificationHelper.getText(orderSummaryText);

    }
    public String getPageHeadingText() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(ExpectedConditions.visibilityOf(pageHeading));
        return new VerificationHelper(driver).getText(pageHeading);

    }

    public WebElement getQtyProductWithStockLocations() {
        return qtyProductWithStockLocations;

    }

    public List<WebElement> getShippingPaymentItemsInYourCartText() {
        return ShippingPaymentItemsInYourCartText;
    }

    public WebElement getCurrencyDropdownBtn() {
        return currencyDropdownBtn;

    }

    public String getConfirmOrderButtonTxt() {
        return verificationHelper.getText(confirmOrder_button);

    }

    public WebElement getItemsCartIcon() {
        return itemsCartIcon;

    }


    public WebElement getClickingConfirmOrderReturnPolicyText() {
        return clickingConfirmOrderReturnPolicyText;

    }

    public WebElement getReturnPolicyTextLink() {
        return returnPolicyTxtLink;

    }

    public WebElement getEditShipmentIcon() {
        return editShipmentIcon;

    }

    public WebElement getShippingText() {
        return shippingTxt;

    }

    public WebElement getPaymentText() {
        return paymentTxt;

    }

    public WebElement getEditPaymentIcon() {
        return editPaymentIcon;

    }

    public WebElement getEditCouponIcon() {
        return editCouponIcon;

    }

    public String getItemsInYourCartText() {
        return verificationHelper.getText(itemsInYourCartTxt);

    }

    public WebElement getEditCartIcon() {
        return editCartIcon;

    }


    public long getItems_In_Your_Cart_List() {
        return items_In_Your_Cart_List.size();

    }

    public WebElement getBackArrowButton() {
        return backArrowBtn;

    }

    public List<WebElement> getTotalPriceAndAmountText() {
        return totalPriceAndAmountTxt;

    }

    public WebElement getTotalPriceText() {
        return totalPriceTxt;

    }

    public WebElement getMountText() {
        return amountTxt;

    }

    //===============================================================

    public String getPaymentHeaderText() {
        return verificationHelper.getText(paymentHeader);

    }

    public String getShippingHeaderText() {
        return verificationHelper.getText(paymentHeader);

    }

    public String getOrderSummaryNoOfItemsText() {
        return verificationHelper.getText(orderSummaryNoOfItems);

    }

    public List<WebElement> getUnitPriceList() {
        return orderSummaryUnitPriceList;

    }

    public String getReturnPolicyLinkText() {
        return verificationHelper.getText(returnPolicyLink);

    }

    public ReturnPolicyPage clickOnReturnPolicyLink() throws IOException {
        waitForElementToBeClickableAndClick(returnPolicyLink);
        return new ReturnPolicyPage(driver);
    }

    public List<WebElement> getItemsInYourCartList() {
        return itemsInYourCartList;

    }

    public String getTotalPriceLabelText() {
        return verificationHelper.getText(totalPriceLabel);

    }

    public String getTotalAmountText() {
        return verificationHelper.getText(totalAmt);

    }

    public String getSubTotalText() {
        return verificationHelper.getText(subTotal);

    }

    public String getFlatShippingRateText() {
        return verificationHelper.getText(flatShippingRate);

    }

    public String getTotalText() {
        return verificationHelper.getText(total);
    }

    public CheckoutEditPaymentPage clickOnEditPaymentButton() {
        editPaymentBtn.click();
        return new CheckoutEditPaymentPage(driver);
    }

    public String getEditPaymentButtonText() {
        return verificationHelper.getText(editPaymentBtn);

    }

    public CheckoutShippingModeEditPage clickOnEditShippingButton() throws IOException {
        waitForElementToBeClickableAndClick(editShippingBtn);
        return new CheckoutShippingModeEditPage(driver);
    }

    public String getEditShippingButtonText() {
        return verificationHelper.getText(editShippingButton);

    }

    public CheckoutEditCartPage clickOnEditCartButton() throws IOException {
        waitForElementToBeClickableAndClick(editCartBtn);
        return new CheckoutEditCartPage(driver);
    }

    public String getEditCartButtonText() {
        return verificationHelper.getText(editCartBtn);

    }

    public CheckoutEditCouponPage clickOnEditCouponButton() throws IOException {
        waitForElementToBeClickableAndClick(editCouponBtn);
        return new CheckoutEditCouponPage(driver);
    }

    public String getEditCouponButtonText() {
        return verificationHelper.getText(editCouponBtn);

    }

    public CheckoutSuccessPage clickConfirmOrderButton() throws IOException {
        waitForElementToBeClickableAndClick(confirmOrderButton);
        return new CheckoutSuccessPage(driver);
    }

    public String getCheckoutConfirmationHeadingText() {
        return verificationHelper.getText(checkoutConfirmationHeadingTxt);

    }

    public CheckoutCartPage clickOnBackArrowButton() throws IOException {
        waitForElementToBeClickableAndClick(backArrowButton);
        return new CheckoutCartPage(driver);
    }

    public String getBackArrowButtonText() {
        return verificationHelper.getText(backArrowButton);

    }

    public String getAmountText() {
        return verificationHelper.getText(amountTxt);

    }

    public CheckoutSuccessPage clickOnConfirmOrderButton() throws IOException {
        waitForElementToBeClickableAndClick(confirmOrder_button);
        return new CheckoutSuccessPage(driver);
    }

    public String getConfirmOrderButtonText() {
        return verificationHelper.getText(confirmOrder_button);

    }


}
