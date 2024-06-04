package pages;

import base.BasePage;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class FooterPage extends BasePage {

    private final WebDriver driver;
    final static Logger log = LogManager.getLogger(FooterPage.class);
    @FindBy(css = ".footer-info-heading")
    public List<WebElement> footerLinks;

    @FindBy(xpath = "//h3[contains(text(),'Navigate')]")
    public WebElement navigate;
    @FindBy(xpath = "//h3[contains(text(),'Categories')]")
    public WebElement categories;
    @FindBy(xpath = "//h3[contains(text(),'Popular Brands')]")
    public WebElement popularBrands;
    @FindBy(xpath = "//h3[contains(text(),'Info')]")
    public WebElement info;
    @FindBy(xpath = "//h3[contains(text(),'Subscribe to our newsletter')]")
    public WebElement subscribeNewsletter;
    @FindBy(css = "#nl_email")
    public WebElement subscribeEmailBox;
    @FindBy(xpath = "/html/body/footer/div[1]/section/article[5]/form/fieldset/div/div/input[2]")
    public WebElement subscribeBtn;
    @FindBy(css = ".info_links_footer > li:nth-of-type(5) > a")
    public WebElement contactusLink;

    public FooterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ContactUsPage clickOnContactusLink() throws IOException {
        new JavaScriptHelper(driver).scrollIntoViewAndClick(contactusLink);
        return new ContactUsPage(driver);
    }

    public void clickOnFooterTextName(String textName) {
        List<WebElement> textNames = footerLinks;
        Iterator<WebElement> itr = textNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim();
            if (text.equals(textName)) {
                c.click();
                break;
            }
        }
    }

}
