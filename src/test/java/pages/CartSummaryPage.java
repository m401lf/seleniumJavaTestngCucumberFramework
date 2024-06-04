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

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class CartSummaryPage extends BasePage {

    private final WebDriver driver;
    final static Logger log = LogManager.getLogger(CartSummaryPage.class);

    @FindBy(css = ".maintext")
    WebElement yourShoppingCart;
    @FindBy(css = "i.fa.fa-trash-o.fa-fw")
    List<WebElement> quantity_delete;
    @FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty')]")
    WebElement emptyShoppingCartMsg;
    @FindBy(css = "a[title='Continue']")
    WebElement continueBtn;


    public CartSummaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContinueButton() throws IOException {
        waitForWebElementAndClick(continueBtn);
    }

    public boolean assertProduct(String prod) {
        System.out.println("selecting product.." + prod);
        WebElement product = driver.findElement(By.xpath("//*[contains(text(),'" + prod + "')]"));
        return new VerificationHelper(driver).isDisplayed(product);
    }

    public void deleteProductFromShoppingCart() throws InterruptedException {
        // Delete all items from cart
        System.out.println("Deleting all products from cart..");
        List<WebElement> deletes = quantity_delete;
        Iterator<WebElement> itr = deletes.iterator();
        while (itr.hasNext()) {
            itr.next().click();
            Thread.sleep(2000);
        }
    }

    public boolean assertEmptyShoppingCartMessageIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
    }

}
