package pages;

import base.BasePage;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage extends BasePage {
    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(EditProfilePage.class);
    @FindBy(xpath = "//*[@id='AccountFrm']/div[2]/div/button")
    public static WebElement continueEditBtn;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement myAccountInformationHeadingText;
    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id='AccountFrm_lastname']")
    public WebElement lastNameBox;
    @FindBy(id = "AccountFrm_email")
    public WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    public WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    public WebElement faxBox;

    public EditProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String userOnAccountEditPage() {
        return myAccountInformationHeadingText.getText();

    }

    public void enterFirstName(String firstName) {
        firstNameBox.clear();
        firstNameBox.sendKeys(firstName);
    }

    public void enterLastName(String lastname) {
        lastNameBox.clear();
        lastNameBox.sendKeys(lastname);
    }

    public void enterFreshEmail() {
        String email = System.currentTimeMillis() + "@gmail.com";
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneBox.clear();
        telephoneBox.sendKeys(telephone);
    }

    public void enterFax(String fax) {
        faxBox.clear();
        faxBox.sendKeys(fax);
    }

    public MyAccountPage clickOnContinueEditBtn() throws InterruptedException {
        new JavaScriptHelper(driver).scrollIntoViewAndClick(continueEditBtn);
        Thread.sleep(5000);
        return new MyAccountPage(driver);
    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) {
        System.out.println(" about editing Profile Details....");
        enterFirstName(firstname);
        enterLastName(lastname);
        enterFreshEmail();
        enterTelephone(telephone);
        enterFax(fax);
        System.out.println("edited Profile Details....");

    }

}
