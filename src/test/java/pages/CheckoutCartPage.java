package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CheckoutCartPage extends BasePage {

    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(CheckoutCartPage.class);

    public CheckoutCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr")
    private List<WebElement> products;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> productNames;
    @FindBy(xpath = "//input[@id='estimate_postcode']")
    WebElement estimatePostcodeBox;
    @FindBy(xpath = "//div[@innertext='Your shopping cart is empty!']")
    private WebElement cart_empty;
    @FindBy(xpath = "//input[@id='coupon_coupon']")
    private WebElement couponBox;
    @FindBy(css = "#apply_coupon_btn")
    private WebElement applyCouponBtn;
    @FindBy(css = "#estimate_country")
    private WebElement estimateCountryDropdown;
    @FindBy(css = "#estimate_country_zones")
    private WebElement countryZonesDropdown;
    @FindBy(xpath = "//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;
    @FindBy(xpath = "//select[@id='shippings']")
    private WebElement FlatRateShipmentsDropdown;
    @FindBy(xpath = "//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[5]/div/input")
    private WebElement quantity;
    @FindBy(id = "cart_update")
    private WebElement updateBtn;
    @FindBy(xpath = "//*[@id='cart']/div/div[3]/div/a[1]")
    private WebElement continueShippingBtn;
    @FindBy(css = ".mb20.pull-right > a[title='Checkout']")
    private WebElement checkoutBtn;
    @FindBy(css = "a[title='Continue']")
    private WebElement ContinueBtn;
    public void assertProductNameAndUnitPriceIsDisplayed(String productname) {
                List<Double> unitPrice = itemNames
                        .stream()
                        .parallel()
                        .filter(s -> s.getText().contains(productname))
                        .map(CheckoutCartPage::getUnitPrice).toList();
                unitPrice.forEach(System.out::println);

    }

    private static double getUnitPrice(WebElement s) {
        String unitPz = s.findElement(By.xpath("following-sibling::td[2]")).getText().trim();
        String unitPz2 = unitPz.replace("$", "").replace(" ", "");
        double unitPz3 = Double.parseDouble(unitPz2);
        if (unitPz3 < 1000.0 || unitPz3 > 00.0) {
            System.out.println("UnitPrice: " + unitPz3);
            System.out.println("---------------------");
        }
        return unitPz3;


    }

    public void assertProductNameAndTotalPriceIsDisplayed(String productName) {
        List<Double> totalPrice = productNames
                .stream()
                .parallel()
                .filter(s -> s.getText().contains(productName))
                .map(s -> getTotalPrice(s)).toList();
        totalPrice.forEach(System.out::println);

    }

    private static double getTotalPrice(WebElement s) {
        String totalPz = s.findElement(By.xpath("following-sibling::td[4]")).getText().trim();
        String totalPz2 = totalPz.replace("$", "").replace(" ", "");
        double totalPz3 = Double.parseDouble(totalPz2);
        if (totalPz3 < 1000.0 || totalPz3 > 00.0) {
            System.out.println("TotalPrice: " + totalPz3);
            System.out.println("-------------------------");
        }

        return totalPz3;
    }

    public void increaseOrDecreaseQuantityOfItemsInTheCart(String productInCart, int qty) {
        // //tr/td[2]/following-sibling::td[3]/div/input
        for (int i = 1; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().contains(productInCart)) {
                WebElement element = itemNames.get(i).findElement(By.xpath("following-sibling::td[3]/div/input"));
                element.clear();
                element.sendKeys(String.valueOf(qty));
            }
        }

    }

    public void removeItemFromShippingCart(String productname){
        // //tr/td[2]/following-sibling::td[5]/a
        for (int i = 1; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().contains(productname)) {
                WebElement element =  itemNames.get(i).findElement(By.xpath("following-sibling::td[5]/a"));
                element.click();
            }
        }

    }


    //==============================================

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

    public WebElement removeIconBtn() {
        return removeItemBtn;

    }

    public void clickOnRemoveIconButton() {
        removeItemBtn.click();

    }

    public void clickOnUpdateButton() {
        updateBtn.click();

    }

    public HomePage clickOnContinueShippingBtn() {
        continueShippingBtn.click();
        return new HomePage(driver);
    }

    public LoginPage clickOnCheckoutButton() throws IOException {
        checkoutBtn.click();
        return new LoginPage(driver);
    }

    public WebElement continueBtn() {
        return ContinueBtn;

    }

    public HomePage clickContinueBtn() throws IOException {
        ContinueBtn.click();
        return new HomePage(driver);
    }

    public void tapContinueBtn() {
        ContinueBtn.click();

    }
}