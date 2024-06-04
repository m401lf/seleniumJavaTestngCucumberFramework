package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutSuccessPage extends BasePage {
    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(CheckoutSuccessPage.class);

    public CheckoutSuccessPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String orderSuccessPageUrl = "https://com/index.php?rt=checkout/success";
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/h1/span[1]")
    public WebElement yourOrderHasBeenProcessedHeadingTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[2]")
    public WebElement OrderNumberText;
    @FindBy(partialLinkText = "Your order #")
    public WebElement OrderNumberTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[3]")
    public WebElement viewInvoiceText;
    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    public WebElement thankYouForShoppingWithUsText;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[3]")
    public WebElement invoicePageLink;
    @FindBy(css = ".mb40 > a[title='Continue']")
    public WebElement continueCheckoutSuccessBtn;


    public boolean assertYourOrderHasBeenProcessedDisplayed() {
        return verificationHelper.isDisplayed(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getYourOrderHasBeenProcessedText() throws InterruptedException {
        //Thread.sleep(5000);
        return verificationHelper.getText(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getOrderNumberText() {
        return verificationHelper.getText(OrderNumberText);

    }

    public String getViewInvoiceText() {
        return verificationHelper.getText(viewInvoiceText);

    }

    public String getThankYouForShoppingWithUsText() {
        return verificationHelper.getText(thankYouForShoppingWithUsText);
    }

    public String assertThankYouForShoppingWithUsText() {
        return verificationHelper.getText(thankYouForShoppingWithUsText);
    }

    public boolean assertThankYouForShoppingWithUsTextIsDisplayed() {
        return verificationHelper.isDisplayed(thankYouForShoppingWithUsText);
    }


    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForElementToBeClickableAndClick(invoicePageLink);
        return new InvoiceOrderPage(driver);
    }

    public HomePage clickOnContinueCheckoutSuccessButton() throws IOException {
        waitForElementToBeClickableAndClick(continueCheckoutSuccessBtn);
        return new HomePage(driver);
    }

    public String getContinueButtonText() {
        return verificationHelper.getText(continueCheckoutSuccessBtn);

    }
}
