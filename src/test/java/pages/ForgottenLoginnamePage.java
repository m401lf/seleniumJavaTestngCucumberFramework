package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenLoginnamePage{
    WebDriver driver;

    final static Logger log = LogManager.getLogger(FooterPage.class);

    public LoginPage loginPage;
    @FindBy(id = "forgottenFrm_email")
    public WebElement emailTxtField;
    @FindBy(id = "forgottenFrm_lastname")
    public WebElement forgottenFrmLastName;
    @FindBy(css = ".maintext")
    public WebElement header;
    @FindBy(css = "h4.heading4")
    public WebElement hintHeading;
    @FindBy(css = "button[title='Continue']")
    public WebElement continueBtn;
    //Logger log = LoggerHelper.getLogger(ForgottenLoginnamePage.class);


    public boolean isHeaderDisplayed() {
        return header.isDisplayed();

    }

    public boolean isHintHeaderDisplayed() {
        return hintHeading.isDisplayed();

    }

    public void enterLastName(String lastname) {
        forgottenFrmLastName.clear();
        forgottenFrmLastName.sendKeys(lastname);

    }

    public String getContinueBtnTxt() {
        return continueBtn.getText();

    }

    public boolean isContinueBtnDisplayed() {
        return continueBtn.isDisplayed();

    }

    public void enterEmail(String email) {
        emailTxtField.sendKeys(email);

    }

    public LoginPage clicksOnContinueBtn() {
        continueBtn.click();
        loginPage = new LoginPage(driver);
        return loginPage;
    }


}
