package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AsideWidgetPage extends BasePage{
    final static Logger log = LogManager.getLogger(AsideWidgetPage.class);
    private final WebDriver driver;
    BasePage basePage;
    @FindBy(xpath = "/html/body/div[1]/div[5]/div[1]/div/aside/div/a")
    private List<WebElement> asideWidgetLinks;

    public AsideWidgetPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getAsideWidgetLinks() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(asideWidgetLinks));
    }

    public void tapOnAsideWidgetLinkByName(String linkName) throws IOException {
        driver.findElements(By.xpath("//a[contains(text(),'" + linkName + "')]"));
    }

    public void clickSideWidgetLinkByName(String linkName) {
        asideWidgetLinks.stream()
                .parallel()
                .filter(s -> s.getText().contains(linkName))
                .findFirst()
                .ifPresent(WebElement::click);
        log.info("Taped on "+linkName+" link");
    }

    public MyAccountPage tapMyAccountLink() throws IOException {
        clickSideWidgetLinkByName(" My Account");
        return new MyAccountPage(driver);
    }

    public EditProfilePage tapEditAccountLink() throws IOException {
        clickSideWidgetLinkByName(" Edit Account");
        
        return new EditProfilePage(driver);
    }

    public RegisterPage tapOnRegisterLink() throws IOException {
        clickSideWidgetLinkByName("Register");
        return new RegisterPage(driver);
    }

    public ForgottenPasswordPage tapOnPasswordLink() throws IOException {
        clickSideWidgetLinkByName(" Password");
        log.info("clicked Forgotten Password link");
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new ForgottenPasswordPage(driver);
    }

    public AddressPage tapOnAddressBookLink() throws IOException {
        clickSideWidgetLinkByName("Address Book");
        log.info("clicked Address Book link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new AddressPage(driver);
    }

    public WishListPage tapOnWishListLink() throws IOException {
        clickSideWidgetLinkByName("Wish List");
        log.info("clicked Wish List link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new WishListPage(driver);
    }

    public OrderHistoryPage tapOnOrderHistoryLink() throws IOException {
        clickSideWidgetLinkByName("Order History");
        log.info("clicked Order History link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new OrderHistoryPage(driver);
    }

    public DownloadsPage tapOnDownloadLink() {
        clickSideWidgetLinkByName(" Download");
        log.info("clicked Order Download link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new DownloadsPage(driver);
    }

    public NotificationPage tapOnNewsletterLink() throws IOException {
        clickSideWidgetLinkByName(" Newsletter");
        log.info("clicked Newsletter link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new NotificationPage(driver);
    }

    public TransactionsPage tapOnTransactionsLink() throws IOException {
        clickSideWidgetLinkByName(" Transactions");
        log.info("clicked Transactions link");
        basePage = PageFactory.initElements(driver, BasePage.class);
        log.info("current page url :: " + basePage.getThisPageUrl());
        log.info("current page title:: " + basePage.getThisPageTitle());
        return new TransactionsPage(driver);
    }

    public LogoutPage tapLogoffLink() throws IOException {
        clickSideWidgetLinkByName("Logout");
        return new LogoutPage(driver);
    }

    public List<String> getAsideWidgetList() {
        List<String> asideWidgetList =
                asideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
        log.info("Aside Widget List: " + asideWidgetList);
        return asideWidgetList;
    }

    public int getCountAsideWidgetList() {
        List<String> asideWidgetList =
                asideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .toList();
        return asideWidgetList.size();
    }

    public boolean assertAsideWidgetItemsCountAndFirstAndLastIndex(int labelsCount, int firstIndex, int lastIndex) {
        List<WebElement> asideWidgetList = asideWidgetLinks;
        int size = asideWidgetList.size();
        for (int i = 0; i < size; i++) {
            if (asideWidgetList.get(i).getText().equals(String.valueOf(labelsCount))) {
                if (i == firstIndex) {
                    log.info("First Index: " + firstIndex);
                    log.info("First Index: " + firstIndex);
                }
                if (i == lastIndex) {
                    log.info("Last Index: " + lastIndex);
                    log.info("Last Index: " + lastIndex);
                }

            }

        }

        return true;

    }

}

