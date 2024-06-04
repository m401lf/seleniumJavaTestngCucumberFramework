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

public class LoginPage extends BasePage {
    private WebDriver driver;
    private final static Logger log = LogManager.getLogger(LoginPage.class);


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "label[for='accountFrm_accountregister']")
    private WebElement registerAccountCheckBox;
    private ForgottenPasswordPage forgottenPasswordPage;
    private ForgottenLoginnamePage forgottenLoginnamePage;
    @FindBy(xpath = "//input[@id='loginFrm_loginname']")
    private WebElement loginNameTxtField;
    @FindBy(xpath = "//input[@id='loginFrm_password']")
    private WebElement passwordTxtField;
    @FindBy(css = "button[title='Login']")
    private WebElement loginBtn;
    @FindBy(xpath = "//form[@id='loginFrm']//button[@title='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='accountFrm']/fieldset/button")
    private WebElement continueBtn;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertAlertSuccessMsg;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    private WebElement loginWithBlanksCredentialsTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]/text()")
    private WebElement loginWithBadPasswordTxt;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]")
    private WebElement errorIncorrectLoginOrPasswordProvidedTxt;

    @FindBy(css = ".form-group.mb40.mt20")
    private WebElement byCreatingAnAccountTxt;

    // successful Login Variables declaration //
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    private WebElement returningCustomerTxt;

    @FindBy(css = ".col-sm-6.newcustomer > .heading2")
    private WebElement newCustomerTxt;
    @FindBy(css = "fieldset > a:nth-of-type(1)")
    private WebElement forgotYourPasswordLink;
    @FindBy(xpath = "//a[normalize-space()='Forgot your login?']")
    private WebElement forgotYourLoginLink;

    // Registration Variables declaration //
    @FindBy(css = "[class='col-sm-6 newcustomer'] .heading4")
    private WebElement checkoutOptionTxt;

    @FindBy(xpath = "//*[@id='email_create']")
    private WebElement registrationEmailAddress;


    public boolean isAccountRegisterChecked() {
        return verificationHelper.isSelected(registerAccountCheckBox);

    }

    public String getContinueButtonTxt() {
        new JavaScriptHelper(driver).scrollToElement(continueBtn);
        waitFor(continueBtn);
        return new VerificationHelper(driver).getText(continueBtn);

    }

    private String getRegisterAccountCheckBox() {
        return new VerificationHelper(driver).getText(registerAccountCheckBox);

    }

    public void enterLoginName(String loginName) {
        loginNameTxtField.sendKeys(loginName);

    }

    public void enterPassword(String password) {
        passwordTxtField.sendKeys(password);
    }

    public MyAccountPage clickOnLoginButtonInAccountLoginPage() throws IOException {
        loginButton.click();
        return new MyAccountPage(driver);
    }

    public void clickLoginButtonInAccountLoginPage() throws IOException {
        loginButton.click();
    }

    public CheckoutConfirmationPage clickLoginButton() {
        loginButton.click();
        return new CheckoutConfirmationPage(driver);
    }

    public String getLoginBtnText() {
        return loginBtn.getText();

    }

    public MyAccountPage ClickLoginButton() throws IOException {
        loginBtn.click();
        return new MyAccountPage(driver);
    }

    public MyAccountPage loginApplication(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickLoginButton();
        return new MyAccountPage(driver);
    }

    public CheckoutConfirmationPage loginApplicationAsReturningCustomer(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickLoginButton();
        return new CheckoutConfirmationPage(driver);
    }

    public void clickForgetYourLogin() {
        forgotYourLoginLink.click();

    }

    public ForgottenLoginnamePage clickForgetYourLoginLink() {
        forgottenLoginnamePage = new ForgottenLoginnamePage();
        forgotYourLoginLink.click();
        return forgottenLoginnamePage;
    }

    public ForgottenPasswordPage clickForgetYourPasswordLink() {
        forgotYourPasswordLink.click();
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
        return forgottenPasswordPage;
    }

    public void clickForgotYourPasswordLink() {
        forgotYourPasswordLink.click();

    }


    public String getForgotYourPasswordLinkTxt() {
        return new VerificationHelper(driver).getText(forgotYourPasswordLink);

    }


    public String getForgotYourLoginLinkTxt() {
        return new VerificationHelper(driver).getText(forgotYourLoginLink);

    }

    public String getSuccessMsg() {
        return new VerificationHelper(driver).getText(alertAlertSuccessMsg);

    }


    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
        return new VerificationHelper(driver).getText(errorIncorrectLoginOrPasswordProvidedTxt);
    }

    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt() {
        return new VerificationHelper(driver).getText(errorIncorrectLoginOrPasswordProvidedTxt);

    }

    public String getReturningCustomerTxt() {
        return new VerificationHelper(driver).getText(returningCustomerTxt);

    }

    public boolean isReturningCustomerNotDisplayed() {
        return new VerificationHelper(driver).isNotDisplayed(returningCustomerTxt);

    }

    public String getCheckoutOptionTxt() {
        return new VerificationHelper(driver).getText(checkoutOptionTxt);

    }

    public boolean isCheckoutOptionSelected() {
        return new VerificationHelper(driver).isSelected(checkoutOptionTxt);

    }

    public String getNewCustomerTxt() {
        return new VerificationHelper(driver).getText(newCustomerTxt);

    }

    public RegisterPage navigateToRegisterPage() {
        new JavaScriptHelper(driver).scrollToElementAndClick(continueBtn);
        return new RegisterPage(driver);

    }
    public RegisterPage clickOnContinueButtonInLoginPage() {
        waitAndClick(continueBtn);
        return new RegisterPage(driver);

    }

    public boolean assertRegisterAccountRadioButtonChecked() {
        return new VerificationHelper(driver).isSelected(registerAccountCheckBox);

    }

    public String getRegisterAccountRadioButtonTxt() {
        return new VerificationHelper(driver).getText(registerAccountCheckBox);

    }

    public String getByCreatingAccountToShopFasterText() {
        return new VerificationHelper(driver).getText(byCreatingAnAccountTxt);

    }


    public RegisterPage clickOnContinueButtonInAccountLoginPage() {
        continueBtn.click();
        return new RegisterPage(driver);
    }

    public boolean assertRegisterAccountIsSelectedByDefault() {
        return new VerificationHelper(driver).isSelected(registerAccountCheckBox);
    }
}
