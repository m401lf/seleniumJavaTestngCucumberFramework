package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class OrderConfirmationPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(OrderConfirmationPage.class);

    @FindBy(id = "cart-print-link")
    public WebElement printIcon;
    @FindBy(xpath = "//h3[contains(text(),'Order Summary')]")
    public WebElement summaryOrder;
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    public WebElement thankYouTxt;
    @FindBy(xpath = "//*[@id='checkout-app']/div/div/div/section/p[1]")
    public WebElement yourOrderNumberTxt;
    @FindBy(xpath = "//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;
    @FindBy(xpath = "//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;
    @FindBy(css = ".cart-priceItem.optimizedCheckout-contentPrimary.cart-priceItem--total")
    public WebElement totalAmountTxt;
    @FindBy(xpath = "//h3[contains(text(),'Items')]")
    public WebElement totalItems;
    @FindBy(xpath = "//span[contains(text(),'Shipping')]")
    public WebElement shippingPrice;
    @FindBy(xpath = "//button[contains(text(),'Continue Shopping »')]")
    public WebElement continueShoppingBtn;
    //Logger log = LoggerHelper.getLogger(OrderConfirmationPage.class);
    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderConfirmationPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean VerifyOrderDisplay(String productName) {
        return productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));

    }


}
