package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogoutPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(LogoutPage.class);

    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    public WebElement saveToLogoutTxt;
    @FindBy(css = ".mb40 > a[title='Continue']")
    public WebElement logoutAccountContinueBtn;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/a")
    public WebElement logoutAccountContinueButton;
    @FindBy(css = ".heading1")
    public WebElement accountLogoutTxt;
    HomePage homePage;


    public LogoutPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLogoutAccountContinueButtonText() {
        return verificationHelper.getText(logoutAccountContinueBtn);

    }

    public String getAccountLogoutText() {
        return verificationHelper.getText(accountLogoutTxt);

    }

    public HomePage clickOnLogoutContinueButton() {
        waitForElementToBeClickableAndClick(logoutAccountContinueButton);
        log.info("Clicked logout continue button..");
        driver.quit();
        homePage = new HomePage(driver);
        return new HomePage(driver);

    }

    public String getLogoutContinueButtonTxt() {
        return verificationHelper.getText(logoutAccountContinueButton);

    }

    public boolean assertContinueButtonIsDisplayed() {
        return verificationHelper.isDisplayed(logoutAccountContinueButton);

    }

}
