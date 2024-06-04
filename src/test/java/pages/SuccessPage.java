package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class SuccessPage extends BasePage {

    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(SuccessPage.class);

    public SuccessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    public WebElement myAccountText;
    @FindBy(css = ".btn.btn-default.mr10")
    public WebElement continueAccountSuccessBtn;
    @FindBy(css = ".maintext")
    public WebElement yourAccountHasBeenCreatedHeadingTxt;
    @FindBy(css = ".mb40")
    private WebElement congratulationsMsg;
    @FindBy(css = "//*[@id='maincontainer']/div/div[1]/div/div/section/p[2]")
    private WebElement accountSuccessfullyCreatedMsg;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

    @FindBy(xpath = "//*[@id='content']/div/a")
    private WebElement continueBtn;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;


    public String getMyAccountText() {
        return myAccountText.getText();
    }

    public String getAccountHasBeenCreatedHeadingText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public MyAccountPage clickOnContinueAccountSuccessButton() {
        continueAccountSuccessBtn.click();
        return new MyAccountPage(driver);

    }


    public String getContinueButtonText() {
        return continueAccountSuccessBtn.getText();

    }


    public String getYourAccountHasBeenCreatedText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public String getYourAccountHasBeenCreatedHeadingText() {
        return yourAccountHasBeenCreatedHeadingTxt.getText();

    }

    public boolean assertYourAccountHasBeenCreatedHeadingTextDisplayed() {
        return accountSuccessfullyCreatedMsg.isDisplayed();

    }

    public boolean assertCongratulationsAccountSuccessfullyCreatedTextIsDisplayed() {
        return congratulationsMsg.isDisplayed();

    }

    public String getCongratulationsAccountSuccessfullyCreatedText() {
        return congratulationsMsg.getText();

    }

    public String getAccountSuccessPageHeading() {
        return getPageHeaderText();

    }

    public boolean assertContinueButtonIsEnabledAndDisplayed() {
        return new VerificationHelper(driver).isDisplayedAndEnabled(continueButton);
    }


    public ShoppingCartPage clickContinueButton() {
        new JavaScriptHelper(driver).scrollToElementAndClick(continueButton);
        return new ShoppingCartPage(driver);
    }

    public MyAccountPage clickContinueButtonInSuccessPage() throws IOException {
        new JavaScriptHelper(driver).executeScript("arguments[0].click();", continueButton);
        return new MyAccountPage(driver);
    }


}
