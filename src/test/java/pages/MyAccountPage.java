package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class MyAccountPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(MyAccountPage.class);
    @FindBy(css = ".maintext")
    public WebElement userProfileMyAccountTxt;
    @FindBy(css = "h1.heading")
    public WebElement myAccountTxt;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/div/ul/li[1]")
    public WebElement accountDashboardTxt;
    @FindBy(css = "a > .fa.fa-unlock")
    public WebElement logoffBtn;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]")
    public List<WebElement> sideWidgetAccountDashboardLinks;
    @FindBy(xpath = "//a[@data-original-title='Edit account details']")
    public WebElement editAccountDetailsLink;
    @FindBy(id = "customer_menu_top")
    public WebElement welcomeBackTxt;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/ul/li[9]/a/i")
    public WebElement logout;
    @FindBy(css = ".alert.alert-success")
    public WebElement successYourAccountSuccessfullyUpdatedTxt;
    EditProfilePage editProfilePage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public String getAccountDashboardTxt() {
        return accountDashboardTxt.getText();

    }

    public LogoutPage clickOnLogoffBtn() throws IOException {
        logoffBtn.click();
        return new LogoutPage(driver);
    }

    public boolean assertLogoffButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logoffBtn);

    }

    public void verifyAllSideWidgetElementsInAccountPageLinks() {
        List<WebElement> links = sideWidgetAccountDashboardLinks;
        for (int i = 0; i < links.size(); i = i++) {
            String listOfElements = links.get(i).getText();
            log.info("Size Of Side Widget List => " + links.size());
            break;
        }

    }

    public void ClickOnLogOffLinkInSideWidgetList() {
        List<WebElement> ListSideWidget = driver.findElements(By.cssSelector(".side_account_list"));
        for (int i = 0; i < ListSideWidget.size(); i = i++) {
            String listName = ListSideWidget.get(i).getText();
            if (listName.contains("Logoff")) {
                driver.findElements(By.linkText("Logoff")).get(i).click();
                break;
            }

        }

    }

    public String getAccountText() {
        return myAccountTxt.getText();

    }

    public String userProfileInfoMessageTxt() {
        return userProfileMyAccountTxt.getText();

    }

    public String getWelcomeMessageTxt() {
        return verificationHelper.getText(welcomeBackTxt);

    }

    public String accountDashboardMessage() {
        return verificationHelper.getText(accountDashboardTxt);


    }

    public void clickOnLogoutButton() {
        logout.click();

    }

    public EditProfilePage clickOnEditAccountDetailsLink() throws IOException, InterruptedException {
        Thread.sleep(3000);
        editAccountDetailsLink.click();
        editProfilePage = new EditProfilePage(driver);
        return editProfilePage;

    }

    public String getAccountProfileSuccessfulUpdateMessage() {
        return successYourAccountSuccessfullyUpdatedTxt.getText();
    }

    public boolean assertMyAccountPageIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(myAccountTxt);

    }
}