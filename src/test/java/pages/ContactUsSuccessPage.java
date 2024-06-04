package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsSuccessPage extends BasePage {

    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(ContactUsSuccessPage.class);

    HomePage homePage;
    @FindBy(css = ".mb40 > p:nth-of-type(2)")
    WebElement successfullySentMsg;
    @FindBy(css = ".mb40 > a[title='Continue']")
    WebElement continueBtn;

    public ContactUsSuccessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getContinueButtonText() {
        return new VerificationHelper(driver).getText(continueBtn);

    }
    public String getSuccessfullySentMessage() {
        waitFor(successfullySentMsg);
        return new VerificationHelper(driver).getText(successfullySentMsg);
    }

    public LoginPage clickOnContinueButton() {
        continueBtn.click();
        return new LoginPage(driver);
    }

}



