package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class RegisterPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String URL = "https://automationteststore.com/index.php?rt=account/create";

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerLinkText;
    @FindBy(css = ".heading1")
    public WebElement createAccountTxt;

    // URL, LOGO, TEXTS//
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    public WebElement ifYouAlreadyHaveAnAccountWithUs;

    @FindBy(css = "#AccountFrm")
    public WebElement form;
    @FindBy(css = "label.control-label.col-sm-4")
    public List<WebElement> labels;
    @FindBy(xpath = "//h4[contains(text(),'Your Personal Details')]")
    public WebElement yourPersonalDetailsTxt;


    //**************Your Personal Details**************//
    @FindBy(id = "AccountFrm_firstname")
    public WebElement firstNameTextBox;
    @FindBy(id = "AccountFrm_lastname")
    public WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public WebElement telephoneTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public WebElement faxTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Your Address')]")
    public WebElement yourAddressText;
    @FindBy(css = "#AccountFrm_company")
    public WebElement companyTextBox;
    //**************Your Address*****************//
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1TextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public WebElement address2TextBox;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    public WebElement regionStateDropdownBtn;
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public WebElement zipCodeTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    public WebElement countryDropdownBtn;
    @FindBy(xpath = "//h4[contains(text(),'Login Details')]")
    public WebElement loginDetailsSectionText;
    @FindBy(css = "#AccountFrm_loginname")
    public WebElement loginNameTextBox;

    //**************Login Details**************//
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordTextBox;
    @FindBy(css = "#AccountFrm_confirm")
    public WebElement passwordConfirmTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    public WebElement newsletterText;
    @FindBy(id = "AccountFrm_newsletter1")
    public WebElement subscribeYesRadioButton;
    @FindBy(css = "label[for='AccountFrm_newsletter1']")
    public WebElement subscribeYesRadioButtonLabel;


    //**************Newsletter**********************//
    @FindBy(css = "[type='radio']")
    public List<WebElement> subscribeRadioButtonList;


    @FindBy(xpath = "//label[@for='AccountFrm_newsletter1']")
    public WebElement subscribeYesRadioButtonText;

    @FindBy(css = "#AccountFrm_newsletter0")
    public WebElement subscribeNORadioButton;
    @FindBy(xpath = "//*[@id=\"AccountFrm_agree\"]")
    public WebElement agreeToPrivacyPolicyButton;
    @FindBy(css = "label[class='col-md-6 mt20 mb40'] a b")
    public WebElement agreeToPrivacyPolicyText;
    // Summit button //
    @FindBy(css = "button[title='Continue']")
    public WebElement continueBtn;
    @FindBy(css = "#AccountFrm_firstname")
    public WebElement firstNameErrorTxt;
    @FindBy(css = "#AccountFrm_lastname")
    public WebElement lastNameErrorTxt;

    //**********ERRORS ********************//
    @FindBy(css = "#AccountFrm_email")
    public WebElement emailErrorTxt;


    @FindBy(css = "div.alert.alert-error.alert-danger")
    public WebElement allAlertErrorDangerSummaryList;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]")
    public WebElement alertErrorDangerItemized;
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1ErrorTxt;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityErrorTxt;
    @FindBy(css = "#AccountFrm_zone_id")
    public WebElement regionStateErrorTxt;
    @FindBy(css = "#AccountFrm_postcode")
    public WebElement zipCodeErrorTxt;
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordErrorTxt;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyErrorTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement youMustAgreeToThePrivacyPolicyErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'')]")
    public List<WebElement> allHighlightedWarningRedMessageErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public WebElement firstNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public WebElement lastNameRedMessages;

    //**********RED WARNING MESSAGES**********//
    @FindBy(xpath = "//span[contains(text(),'Email Address does not appear to be valid!')]")
    public WebElement emailRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
    public WebElement address1RedMessages;
    @FindBy(xpath = "//span[contains(text(),'City must be between 3 and 128 characters!')]")
    public WebElement cityRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Zip/postal code must be between 3 and 10 characters!')]")
    public WebElement zipCodeRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Please select a region / state!')]")
    public WebElement StateProvinceRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Login name must be alphanumeric only and between 5')]")
    public WebElement loginNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Password must be between 4 and 20 characters!')]")
    public WebElement passwordRedMessages;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    public WebElement agreeToPrivacyPolicyRedMessages;

    @FindBy(xpath = "//*[contains(text(),'*')]")
    public List<WebElement> asterisks;
    @FindBy(css = "span.input-group-addon")
    public List<WebElement> mandatoryfields;


    SuccessPage accountSuccessPage;
    String email = System.currentTimeMillis() + "Gen";
    @FindBy(how = How.ID, using = "esr-costcentre-confirm-option-yes")
    private WebElement yesRadio;

    @FindBy(how = How.ID, using = "esr-costcentre-confirm-option-no")
    private WebElement noRadio;


    public void clickYesNoRadio(String radioOption) {
        switch (radioOption.toLowerCase()) {
            case "Yes":
                yesRadio.click();
                break;
            case "No":
                noRadio.click();
                break;
        }
    }


    public String getCreateAccountTxt() {
        return new VerificationHelper(driver).getText(createAccountTxt);

    }

    public boolean assertLabelCountAndSizeAndPositions(int labels_Count, String firstLabel, String secondLabel) {
        int size = labels.size();
        System.out.println("Size of labels: " + size);
        for (int i = 0; i < size; i++) {
            String labelsText = labels.get(i).getText();
            System.out.println(labelsText);
            if (size == labels_Count || labels.get(0).getText().trim().contains(firstLabel) || labels.get(15).getText().trim().contains(secondLabel)) {
                return true;

            }
        }
        return false;
    }

    public String getIfYouAlreadyHaveAnAccountWithUs() {
        return new VerificationHelper(driver).getText(ifYouAlreadyHaveAnAccountWithUs);

    }

    public String getYourPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsTxt);

    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName);
        log.info("Entered first name : " +firstName);

    }

    public void enterLastName(String lastName) {
        lastNameTextBox.sendKeys(lastName);
        log.info("Entered last name : " +lastName);

    }

    public void enterEmailAddress() {
        String email = System.currentTimeMillis() + "@gmail.com";
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        log.info("Entered email : " +email);
    }

    public void enterEmail(String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        log.info("Entered email : " +email);
    }

    public void enterTelephoneNumber(String telephone) {
        telephoneTextBox.sendKeys(telephone);
        log.info("Entered telephone : " +telephone);

    }

    public void enterFaxNumber(String fax) {
        faxTextBox.sendKeys(fax);
        log.info("Entered fax : " +fax);

    }

    public void enterYourPersonalDetailsSection(String firstName, String lastName, String telephone, String fax) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress();
        enterTelephoneNumber(telephone);
        enterFaxNumber(fax);

    }

    public String getYourAddressText() {
        return new VerificationHelper(driver).getText(yourAddressText);

    }

    public void enterCompanyName(String companyName) {
        companyTextBox.sendKeys(companyName);
        log.info("Entered company name : " +companyName);

    }

    public void enterAddress1(String address1) {
        address1TextBox.sendKeys(address1);
        log.info("Entered address 1 : " +address1);

    }

    public void enterAddress2(String address2) {
        address2TextBox.sendKeys(address2);
        log.info("Entered address 2 : " +address2);

    }

    public void enterCity(String cityName) {
        cityTextBox.sendKeys(cityName);
        log.info("Entered city : " +cityName);

    }

    public void selectRegionOrState(String regionOrStateName) {
        selectByVisibleText(regionOrStateName, regionStateDropdownBtn);
        log.info("Selected region or state : " +regionOrStateName);

    }

    public void enterPostalOrZipCode(String ZipOrPostalCode) {
        zipCodeTextBox.sendKeys(ZipOrPostalCode);
        log.info("Entered zip or postal code : " +ZipOrPostalCode);

    }

    public void selectCountry(String countryName) {
        selectByVisibleText(countryName, countryDropdownBtn);
        log.info("Selected country : " +countryName);

    }

    public void selectCountryName(String countryName) {
        Select se = new Select(this.countryDropdownBtn);
        se.selectByVisibleText(countryName);
        log.info("Selected country : " +countryName);
    }

    public String getLoginDetailsSectionTxt() {
        return new VerificationHelper(driver).getText(loginDetailsSectionText);
    }

    public void enterLoginName() {
        loginNameTextBox.clear();
        loginNameTextBox.sendKeys(email);
        log.info("Entered login name : " +email);

    }

    public void inputLoginName(String loginname) {
        loginNameTextBox.clear();
        loginNameTextBox.sendKeys(loginname);
        log.info("Entered login name : " +loginname);

    }

    public void inputUniqueLoginName() {
        loginNameTextBox.clear();
        String loginname = System.currentTimeMillis() + "Gen";
        loginNameTextBox.sendKeys(loginname);
        log.info("Entered login name : " +loginname);
        System.out.println("Keys successfully sent to UserLogin name field :: " + loginname);

    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
        log.info("Entered password : " +password);

    }

    public void enterConfirmPassword(String passwordConfirm) {
        passwordConfirmTextBox.sendKeys(passwordConfirm);
        log.info("Entered password confirm : " +passwordConfirm);

    }

    public String getNewsletterTxt() {
        return new VerificationHelper(driver).getText(newsletterText);

    }

    public void tickOnSubscribeAsYes() {
        new JavaScriptHelper(driver).scrollToElement(subscribeYesRadioButton);
        subscribeYesRadioButton.click();
        log.info("Ticked on subscribe as yes");

    }

    public String getSubscribeYesRadioButton() {
        return subscribeRadioButtonList.get(0).getText();

    }

    public String getSubscribeYesRadioButtonLabel() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonLabel);

    }

    public boolean assertSubscribeYesIsSelected() {
        return new VerificationHelper(driver).isSelected(subscribeYesRadioButton);

    }

    public boolean assertSubscribeNoIsSelected() {
        return new VerificationHelper(driver).isSelected(subscribeNORadioButton);

    }

    public void clickOnSubscribeAsNo() {
        subscribeNORadioButton.click();
        log.info("Clicked on subscribe as no");

    }

    public void checkOnIAgreeToPrivacyPolicyRadioButton() {
        agreeToPrivacyPolicyButton.click();
        log.info("Checked on I agree to privacy policy radio button");

    }
    public boolean assertPrivacyPolicyIsSelected() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }

    public String getAgreeToPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyText);

    }

    public SuccessPage clickOnContinueButtonInRegistrationPage() throws InterruptedException {
        continueBtn.click();
        log.info("Clicked on continue button in registration page");
        accountSuccessPage = new SuccessPage(driver);
        return accountSuccessPage;
    }


    //===========Errors===============================//

    public String getFirstNameRedMessages() {
        waitFor(firstNameRedMessages);
        return new VerificationHelper(driver).getText(firstNameRedMessages);

    }

    public String getLastNameRedMessages() {
        return new VerificationHelper(driver).getText(lastNameRedMessages);

    }

    public String getEmailRedMessages() {
        return new VerificationHelper(driver).getText(emailRedMessages);

    }

    public String getAddress1RedMessages() {
        return new VerificationHelper(driver).getText(address1RedMessages);

    }

    public String getCityRedMessages() {
        return new VerificationHelper(driver).getText(cityRedMessages);

    }

    public String getZipCodeRedMessages() {
        return new VerificationHelper(driver).getText(zipCodeRedMessages).trim();

    }

    public String getStateProvinceRedMessages() {
        waitFor(StateProvinceRedMessages);
        return new VerificationHelper(driver).getText(StateProvinceRedMessages);

    }

    public String getLoginNameRedMessages() {
        return new VerificationHelper(driver).getText(loginNameRedMessages);

    }

    public String getPasswordRedMessages() {
        return new VerificationHelper(driver).getText(passwordRedMessages);

    }

    public String getAgreeToPrivacyPolicyRedMessages() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyRedMessages);

    }

    public String getContinueBtnTxt() {
        return new VerificationHelper(driver).getText(continueBtn);

    }

    public void tapContinueButton() {
        continueBtn.click();
        log.info("Click on continue button in registration page");

    }

    public int getCountOfAllMandatoryRedIcons() {
        int size = mandatoryfields.size();
        System.out.println("Size of labels: " + size);
        System.out.println("Size of labels: " + size);
        return size;
    }

    public boolean assertForAlertErrorDangerTxt() {
        return new VerificationHelper(driver).isDisplayed(alertErrorDangerItemized);

    }


    public Boolean isSubscribeAsYesTicked() {
        return new VerificationHelper(driver).isSelected(subscribeYesRadioButton);

    }

    public boolean isPrivacyPolicyIsTicked() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }

    public String getSubscribeAsYes() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButton);

    }

    public String getContinueButtonTxt() {
        return new VerificationHelper(driver).getText(continueBtn);

    }


    public SuccessPage clickContinueButtonInRegisterPage() throws IOException {
        //screenshotFullPage();
        //getRectHeightAndWidthOfAnElement(continueBtn);
        continueBtn.click();
        log.info("Click on continue button in registration page");
        return new SuccessPage(driver);
    }

    public SuccessPage navigateToAccountSuccessPage() {
       continueBtn.click();
        log.info("clicked on Continue button");
        return new SuccessPage(driver);
    }

    public boolean assertCountrySelectedByIPGeoLocationIsDisplayed(){
        return new VerificationHelper(driver).isDisplayed(countryDropdownBtn);

    }

    public String getCountrySelectedByIPGeoLocationText() {
        return new VerificationHelper(driver).getText(countryDropdownBtn);

    }

    public String getSubscribeYesRadioButtonText() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonText);
    }

    public boolean assertAllAlertErrorDangerSummaryText() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(allAlertErrorDangerSummaryList));
        return new VerificationHelper(driver).isDisplayed(allAlertErrorDangerSummaryList);
    }

    public String getPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicyText);
    }

    public String getSubscribeYesOptionText() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonText);

    }

    public List<WebElement> getAsterisks() {
        return asterisks;

    }
}