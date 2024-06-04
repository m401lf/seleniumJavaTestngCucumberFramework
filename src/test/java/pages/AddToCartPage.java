package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='quickSearch']/div/section/ul/li[2]")
    public WebElement addToCartByIndex;
    //Logger log = LoggerHelper.getLogger(AddToCartPage.class);
    @FindBy(id = "quantity_wanted")
    private WebElement quantity;
    @FindBy(name = "group_1")
    private WebElement size;
    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//*[@id='layer_cart']//h2/i")
    private WebElement addToCartMessage;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;


    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
