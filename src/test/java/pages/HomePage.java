package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;


public class HomePage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(LoginPage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String url = "https://automationteststore.com/";

    @FindBy(css = ".welcome_msg h4")
    public WebElement welcome_msg;
    @FindBy(xpath = "///h2[@innertext='Fast shipping']")
    public WebElement fastShipping;
    @FindBy(xpath = "///h2[@innertext='Easy Payments']")
    public WebElement easyPayments;
    @FindBy(xpath = "///h2[@innertext='Shipping Options']")
    public WebElement shippingOptions;
    @FindBy(xpath = "///h2[@innertext='Large Variety']")
    public WebElement largeVariety;
    @FindBy(xpath = "span.maintext")
    public List<WebElement> headingLists;
    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    public List<WebElement> allProductsList;

    @FindBy(css = ".info_links_footer > li:nth-of-type(5) > a")
    public WebElement contactusLink;
    By addToCart = By.cssSelector("[title='Add to Cart']");

    public String getFastShipping() {
        return fastShipping.getText();

    }

    public String getEasyPayments() {
        return easyPayments.getText();

    }

    public String getShippingOptions() {
        return shippingOptions.getText();

    }

    public String getLargeVarietyLargeVariety() {
        return largeVariety.getText();

    }

    public List<WebElement> getHeadingLists() {
        return headingLists;

    }


    public String getUrl() {
        return url;

    }

    public List<WebElement> getProductList() {
        return allProductsList;

    }

    public void addProductsToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
    }

    public WebElement getProductByName(String productName) {
        return allProductsList
                .stream()
                .parallel()
                .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText().contains(productName))
                .findFirst()
                .orElse(null);
    }

    public WebElement addToCart(String productName) {
            WebElement prod = getProductList()
                    .stream()
                    .parallel()
                    .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText().equals(productName))
                    .findFirst()
                    .orElse(null);
            return prod;
    }



    public void addProductToCart(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));
        new JavaScriptHelper(driver).scrollToElement(products.get(0));
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait())).until(ExpectedConditions.visibilityOf(products.get(0)));
        WebElement prod = products.stream().parallel()
                .filter(product -> product.findElement(By.cssSelector("a")).getText().contains(productName))
                .findFirst().orElse(null);
        assert prod != null;
        prod.findElement(By.cssSelector("a.productcart")).click();

    }

    public String getWelcomeMessage() {
        return new VerificationHelper(driver).getText(welcome_msg);
    }


    public boolean assertWelcomeMessage() {
        return new VerificationHelper(driver).isDisplayed(welcome_msg);
    }


}
