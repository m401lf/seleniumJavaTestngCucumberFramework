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

public class ContactUsPage extends BasePage {

    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(ContactUsPage.class);


    @FindBy(css = ".element_error.has-error")
    public List<WebElement> errorList;
    @FindBy(css = "#field_13 > .help-block > .element_error")
    WebElement inquiryBoxError;
    @FindBy(css = "#ContactUsFrm_first_name")
    WebElement firstNameBox;
    @FindBy(css = "#ContactUsFrm_email")
    WebElement emailBox;
    @FindBy(css = "#ContactUsFrm_enquiry")
    WebElement inquiryBox;
    @FindBy(css = ".col-md-1 > .btn")
    WebElement resetBtn;
    @FindBy(css = ".col-md-6 > .btn")
    WebElement submitBtn;
    @FindBy(css = "#field_11 > .help-block > .element_error")
    WebElement firstNameError;
    @FindBy(css = "#field_12 > .help-block > .element_error")
    WebElement emailBoxError;
    @FindBy(css = "div:nth-of-type(3)  .element_error.has-error")
    WebElement inquiryBoxErrorTxt;
    @FindBy(css = ".col-md-6.pull-right")
    WebElement phoneNumber;
    @FindBy(css = ".col-md-6.pull-left")
    WebElement address;
    @FindBy(css = ".heading3")
    WebElement contactUsFormTxt;
    @FindBy(css = ".required")
    WebElement requiredRedColorSign;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getInquiryBoxError() {
        return inquiryBoxError;

    }

    public List<WebElement> getErrorList() {
        return errorList;

    }

    public boolean assertFirstNameIsDisplayedAndEnabled() {
        boolean isEnabled = firstNameBox.isEnabled();
        boolean isDisplayed = firstNameBox.isDisplayed();
        return isDisplayed && isEnabled;
    }

    public void inputFirstName(String firstname) {
        firstNameBox.sendKeys(firstname);

    }

    public WebElement emailBox() {
        return this.emailBox;

    }

    public void inputEmail(String email) {
        emailBox.sendKeys(email);

    }

    public WebElement inquiryBox() {
        return inquiryBox;

    }

    public void inputInquiry(String msg) {
        inquiryBox.sendKeys(msg);

    }

    public WebElement resetButton() {
        return resetBtn;

    }

    public void clickOnResetButton() {
        resetBtn.click();

    }

    public String getSubmitButtonText() {
        return submitBtn.getText();

    }

    public ContactUsSuccessPage tapOnSubmitBtn() throws IOException {
        submitBtn.click();
        return new ContactUsSuccessPage(driver);
    }

    public String getErrorFirstNameBoxMsg() {
        return firstNameError.getText();

    }

    public String getErrorEmailBoxMsg() {
        return emailBoxError.getText();

    }

    public String getErrorInquiryBoxMsg() {
        return inquiryBoxErrorTxt.getText();

    }

    public boolean assertPhoneNumberIsDisplayed() {
        return verificationHelper.isDisplayed(phoneNumber);

    }

    public String getPhoneNumberTxt() {
        return verificationHelper.getText(phoneNumber);

    }

    public WebElement address() {
        return address;

    }

    public String getAddressText() {
        return address.getText();

    }

    public WebElement contactUsFormText() {
        return this.contactUsFormTxt;

    }

    public WebElement requiredRedColorSign() {
        return this.requiredRedColorSign;

    }

    public String getContactDetailsText() {
        return verificationHelper.getText(contactUsFormTxt);
    }

}



