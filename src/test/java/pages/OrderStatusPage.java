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

public class OrderStatusPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(OrderStatusPage.class);
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement homeLinkTxt;
    @FindBy(xpath = "//span[contains(text(),'Your Account')]")
    public WebElement yourAccountLinkTxt;
    @FindBy(xpath = "//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;
    @FindBy(xpath = "//a[contains(text(),'Order #')]")
    public WebElement OrderNoTxt;
    @FindBy(xpath = "//p[contains(text(),' products totaling $')]")
    public WebElement productsTotalingPriceTxt;
    @FindBy(css = ".account-product-detail")
    public WebElement productDetailDateTxt;
    @FindBy(xpath = "//h6[contains(text(),'Awaiting Fulfillment')]")
    public WebElement awaitingFulfillmentTxt;
    @FindBy(css = ".breadcrumbs")
    public List<WebElement> allMenuLinksText;
    @FindBy(linkText = "Orders")
    public WebElement ordersMenuLinkTxt;
    @FindBy(linkText = "Returns")
    public WebElement returnsMenuLinkTxt;
    @FindBy(linkText = "Messages")
    public WebElement messagesMenuLinkTxt;
    @FindBy(linkText = "Addresses")
    public WebElement addressesMenuLinkTxt;
    @FindBy(linkText = "Wish Lists")
    public WebElement wishListsMenuLinkTxt;
    @FindBy(linkText = "Recently Viewed")
    public WebElement recentlyViewedLinkTxt;
    @FindBy(css = ".page-heading")
    public WebElement orderTitleTxt;
    @FindBy(css = ".navBar-section")
    public List<WebElement> navBarSection;
    @FindBy(css = ".alertBox-column.alertBox-message")
    public WebElement anyOrdersAlertBoxMessage;
    //Logger log = LoggerHelper.getLogger(OrderConfirmationPage.class);

    public OrderStatusPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
