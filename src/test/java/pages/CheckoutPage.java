package pages;


import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BasePage {
    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(CheckoutPage.class);

    @FindBy(xpath = "//h2[contains(text(),'Customer')]")
    public WebElement customerHeadingTxt;
    @FindBy(css = ".product-column.product-figure")
    public WebElement itemImage;
    @FindBy(xpath = "//button[contains(text(),'Sign Out')]")
    public WebElement signOutBtn;
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    public WebElement billingAddrEditBtn;
    @FindBy(xpath = "//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    public WebElement shippingAddressEditBtn;
    @FindBy(css = ".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    public WebElement fullCustomerHeadingTxt;
    @FindBy(id = "addressToggle")
    public WebElement shippingAddressTxt;
    @FindBy(xpath = "//label[contains(text(),'My billing address is the same as my shipping addr')]")
    public WebElement myBillingAddressSameShippingAddressTxt;
    @FindBy(xpath = "//h2[contains(text(),'Customer')]")
    public WebElement shippingMethodTxt;
    @FindBy(css = "#checkout-shipping-continue")
    public WebElement customerContinueBtn;
    @FindBy(xpath = "//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;
    @FindBy(css = "#cart-edit-link")
    public WebElement editCartLinkTxt;
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/div/aside/article/section[3]/div/div")
    public WebElement totalPrice;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String customerHeadingTxt() {
        return customerHeadingTxt.getText();

    }

    public WebElement itemImage() {
        return itemImage;

    }

    public void clickOnSignOutButton() {
        signOutBtn.click();

    }

    public WebElement signOutBtn() {
        return signOutBtn;

    }

    public void clickOnBillingAddEditButton() {
        billingAddrEditBtn.click();

    }

    public WebElement billingAddEditButton() {
        return billingAddrEditBtn;

    }

    public WebElement shippingAddEditButton() {
        return shippingAddressEditBtn;

    }

    public String getFullCustomerHeadingText() {
        return verificationHelper.getText(fullCustomerHeadingTxt);

    }

    public String getShippingAddressText() {
        return new VerificationHelper(driver).getText(shippingAddressTxt);

    }

    public String getMyBillingAddressSameShippingAddressText() {
        return new VerificationHelper(driver).getText(myBillingAddressSameShippingAddressTxt);

    }

    public String getShippingMethodText() {
        return new VerificationHelper(driver).getText(shippingMethodTxt);

    }

    public void clickOnCustomerContinueButton() {
        customerContinueBtn.click();

    }

    public String getOrderSummaryText() {
        return new VerificationHelper(driver).getText(orderSummaryTxt);

    }

    public void clickOnEditCartLink() {
        editCartLinkTxt.click();

    }

    public String getEditCartLinkText() {
        return new VerificationHelper(driver).getText(editCartLinkTxt);

    }

    public String getTotalPrice() {
        return new VerificationHelper(driver).getText(totalPrice);

    }


}
