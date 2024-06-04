package pages;

import base.BasePage;
import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {


    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(ShoppingCartPage.class);

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    @FindBy(css = "h1.page-title.mb-3.h3") // MyAccount BasePage heading
    private WebElement headerTxt;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement errorAlertForDesiredQuantityOrNotInStock;

    @FindBy(xpath = "//td[2]")
    private List<WebElement> productNames;

    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr")
    private List<WebElement> products;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]")
    private List<WebElement> productList;

    @FindBy(xpath = "//*[@id='cart']/div/div/table/tbody/tr/td[1]")
    private List<WebElement> productImages;

    @FindBy(xpath = "//*[@id='cart']/div/div/table/tbody/tr/td[3]")
    private List<WebElement> productModels;

    @FindBy(css = "div.input-group.input-group-sm")
    private List<WebElement> quantityBox;

    @FindBy(css = "#cart_update")
    private WebElement updateButton;

    @FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty')]")
    WebElement emptyShoppingCartMsg;


    @FindBy(css = "i.fa.fa-trash-o.fa-fw")
    private List<WebElement> removeItems;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[1]")
    private List<WebElement> product_Images;


    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]")
    private List<WebElement> product_Names;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[3]")
    private List<WebElement> product_Models;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[4]")
    private List<WebElement> product_Quantities;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[5]")
    private List<WebElement> product_Prices;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[6]")
    private List<WebElement> product_TotalPrices;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[7]")
    private List<WebElement> product_RemoveButtons;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td")
    private List<WebElement> allTds_Tr;

    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[6]")
    private List<WebElement> totalPrices;

    @FindBy(xpath = "//table/tbody/tr/td[6]")
    private List<WebElement> unitPrices;
    @FindBy(xpath="//div[@innertext='Your shopping cart is empty!']")
    private WebElement cart_empty;
    @FindBy(xpath="//input[@id='coupon_coupon']")
    private WebElement couponBox;

    @FindBy(css="#apply_coupon_btn")
    private WebElement applyCouponBtn;

    @FindBy(css="#estimate_country")
    private WebElement estimateCountryDropdown;

    @FindBy(css="#estimate_country_zones")
    private WebElement countryZonesDropdown;

    @FindBy(xpath="//input[@id='estimate_postcode']")
    WebElement estimatePostcodeBox;

    @FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;

    @FindBy(xpath="//select[@id='shippings']")
    private WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath="//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;

    @FindBy(id="cart_quantity50")
    private WebElement quantity;

    @FindBy(id="cart_update")
    private WebElement updateBtn;

    @FindBy(css=".mb20.pull-right > a[title='Checkout']")
    private WebElement checkoutBtn;



    public void EnterCouponNumberOnCouponBox(String CouponNumber) {
        sendKeysToWebElement(couponBox, CouponNumber);

    }

    public void clickOnApplyCouponBtn() {
        applyCouponBtn.click();

    }

    public void selectEstimateCountryDropdown(String countryName) {
        selectByVisibleText(countryName, estimateCountryDropdown);
    }

    public void selectCountryZonesDropdown(String countryZonesName) {
        selectByVisibleText(countryZonesName, countryZonesDropdown);

    }

    public void enterOnEstimatePostcodeBox(String postCode) {
        sendKeysToWebElement(estimatePostcodeBox, postCode);

    }

    public void clickOnEstimateCalculatorBtn() {
        estimateCalculatorBtn.click();

    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        selectByVisibleText(flatRateShipment, FlatRateShipmentsDropdown);

    }

    public void updateQuantityOfProductInTheCart(String productName, int qty) throws InterruptedException {
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                productList.get(i).findElement(By.xpath("following-sibling::td[3]//div//input")).clear();
                productList.get(i).findElement(By.xpath("following-sibling::td[3]//div//input")).sendKeys(String.valueOf(qty));
                break;
            }
        }

    }

    public String assertProductNameAndModelOfProductInTheCart(String productName) {
        String productModel = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                productModel = productList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText();
                break;
            }
        }
        return productModel;

    }

    public WebElement getProductName(String nameOfProduct) {
        return productList.stream()
                .parallel()
                .filter(p -> p.getText().equalsIgnoreCase(nameOfProduct))
                .findFirst()
                .orElse(null);
    }

    public String getProductNameInTheCart(String productName) {
        WebElement prod = getProductName(productName);
        return prod.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    public String getModelOfProductInTheCart(String productName) {
        String productModel = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                productModel = productList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText();
                break;
            }
        }
        return productModel;
    }

    public String getUnitPriceOfProductInTheCart(String productName) {
        String unitPerPrice = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                unitPerPrice = productList.get(i).findElement(By.xpath("following-sibling::td[2]")).getText();
                break;
            }
        }
        return unitPerPrice;
    }

    public String getTotalPriceOfProductInTheCart(String productName) {
        String totalPrice = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                totalPrice = productList.get(i).findElement(By.xpath("following-sibling::td[4]")).getText();
                break;
            }
        }
        return totalPrice;
    }

    public String getNameOfProductsInTheCart(String productName) {
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        return productList
                .stream()
                .parallel()
                .filter(p -> p.getText().equalsIgnoreCase(productName))
                .map(WebElement::getText)
                .findFirst()
                .orElse(null);
    }

    public String getProductModelNumberInTheCart(String productName) {
        return productList
                .stream()
                .parallel()
                .filter(p -> p.getText().equalsIgnoreCase(productName))
                .map(p -> getProductModelNumber(p))
                .findFirst().orElse(null);
    }

    private static String getProductModelNumber(WebElement p) {
        return p.findElement(By.xpath("following-sibling::td[1]")).getText();
    }


    public void removeProductFromCart(String productName) {
        List<WebElement> products = productList.stream().parallel().filter(p -> p.getText().equalsIgnoreCase(productName)).toList();
        products.stream().parallel().findFirst().ifPresent(product -> product.findElement(By.xpath("following-sibling::td[5]")).click());
    }


    public void clickOnUpdateButton() {
        updateBtn.click();

    }

    public LoginPage clickOnCheckoutButton() {
        checkoutBtn.click();
        return new LoginPage(driver);
    }

    public void inputItemQuantity(int number) {
        quantity.clear();
        quantity.sendKeys(String.valueOf(number));
    }


    public String getUpdateButtonText() {
        return new VerificationHelper(driver).getText(updateBtn);

    }

    public String getCheckoutButtonText() {
        return new VerificationHelper(driver).getText(checkoutBtn);

    }
    public boolean verifyEmptyShoppingCartMessage() {
        return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
    }

    public String getProductModelInTheCart(String productName) {
        String productModel = null;
        List<WebElement> productList = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[2]"));
        int size = productList.size();
        for(int i = 0; i < size; i++){
            if(productList.get(i).getText().equalsIgnoreCase(productName)){
                productModel = productList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText();
                break;
            }
        }
        return productModel;
    }
}
