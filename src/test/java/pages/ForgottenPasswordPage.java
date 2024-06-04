package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage extends BasePage {
    final static Logger log = LogManager.getLogger(ForgottenPasswordPage.class);

    private WebDriver driver;
    public LoginPage loginPage;
    @FindBy(id = "forgottenFrm_email")
    public WebElement emailTxtField;
    @FindBy(id = "forgottenFrm_loginname")
    public WebElement forgottenFrmLoginname;
    @FindBy(css = "a[title='Back']")
    public WebElement backButton;
    @FindBy(css = ".maintext")
    public WebElement heading;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/form/h4")
    public WebElement hintHeading;
    @FindBy(css = "button[title='Continue'] > .fa.fa-check")
    public WebElement continueButton;

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String getHintHeadingText() {
        return hintHeading.getText();

    }

    public boolean isHeadingDisplayed() {
        return heading.isDisplayed();

    }

    public boolean isHintHeadingDisplayed() {
        return hintHeading.isDisplayed();

    }

    public String getContinueButtonTxt() {
        return continueButton.getText();

    }

    public LoginPage clickOnBackButton() {
        backButton.click();
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();

    }

    public void enterEmail(String email) {
        emailTxtField.sendKeys(email);

    }

    public void enterLoginname(String loginname) {
       forgottenFrmLoginname. sendKeys(loginname);

    }

    public LoginPage clicksOnContinueButton() {
        continueButton.click();
        loginPage = new LoginPage(driver);
        return loginPage;
    }


}
