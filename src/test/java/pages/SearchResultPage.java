package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class SearchResultPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    public List<WebElement> allProductsList;

    @FindBy(id="keyword")
    private WebElement SearchBox;

    @FindBy(id="category_id")
    private WebElement allCategoriesDropdown;

    @FindBy(id="/html/body/div/div[2]/div/div/div/div/div[1]/fieldset/div[2]/div/select/option")
    private List<WebElement> allSubCategoriesDropdownList;

    @FindBy(css="label[for='description']")
    private WebElement searchProductDescriptionsRadioButton;

    @FindBy(css="label[for='model']")
    private WebElement searchProductModelRadioButton;

    @FindBy(css="label[for='price']")
    private WebElement searchProductPriceRadioButton;

    @FindBy(css="#search_button")
    private WebElement searchButton;

    @FindBy(css="label[for='viewed']")
    private WebElement searchProductViewedRadioButton;

    @FindBy(xpath="//h4[normalize-space()='Search Criteria']")
    private WebElement SearchCriteriaText;

    @FindBy(xpath="//h4[normalize-space()='Products meeting the search criteria']")
    private WebElement productsMeetingSearchCriteriaText;

    @FindBy(css = ".fa.fa-th-list.icon-white")
    private WebElement listIconWhiteIcon;

    @FindBy(css = ".fa.fa-th")
    private WebElement listGridIcon;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[1]/form/select/option")
    private List<WebElement> sortByDropdownList;

    @FindBy(id = "sort")
    private WebElement sortByDropdown;

    @FindBy(css = "select#limit")
    private WebElement perPageDropdown;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[5]/form/select/option")
    private List<WebElement> perPageDropdownList;

    @FindBy(xpath="i.fa.fa-cart-plus.fa-fw")
    private List<WebElement> addToCartButtonList;
    @FindBy(xpath="(//a[@title='Add to Cart'])")
    private WebElement addToCartButton;

    @FindBy(css = "span.nostock")
    private List<WebElement> outOfStockButtons;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div/div/div/div/div/div")
    private List<WebElement> onePriceList;




    public void clickPerPageDropdown() {
        waitForWebElementAndClick(perPageDropdown);

    }

    public List<WebElement> perPageDropdownList() {
        return perPageDropdownList;

    }


    public void addToCart() {
        addToCartButton.click();
        log.info("Product added to cart successfully");
    }


    public boolean isProductExist(String productName) {
        boolean flag=false;
        for(WebElement product: allProductsList)
        {
            if(product.getAttribute("title").equals(productName))
            {
                flag=true;
                break;
            }
        }

        return flag;

    }

    public void selectProduct(String productName)
    {
        for(WebElement product: allProductsList)
        {
            if(product.getAttribute("title").equals(productName))
            {
                product.click();
            }
        }

    }


    public WebElement getSearchBox() {
        return SearchBox;
    }

    public WebElement getAllCategoriesDropdown() {
        return allCategoriesDropdown;
    }

    public List<WebElement> getAllSubCategoriesDropdownList() {
        return allSubCategoriesDropdownList;
    }

    public WebElement getSearchProductDescriptionsRadioButton() {
        return searchProductDescriptionsRadioButton;
    }

    public WebElement getSearchProductModelRadioButton() {
        return searchProductModelRadioButton;
    }

    public WebElement getSearchProductPriceRadioButton() {
        return searchProductPriceRadioButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchProductViewedRadioButton() {
        return searchProductViewedRadioButton;
    }

    public WebElement getSearchCriteriaText() {
        return SearchCriteriaText;
    }

    public WebElement getProductsMeetingSearchCriteriaText() {
        return productsMeetingSearchCriteriaText;
    }

    public WebElement getListIconWhiteIcon() {
        return listIconWhiteIcon;
    }

    public WebElement getListGridIcon() {
        return listGridIcon;
    }

    public List<WebElement> getSortByDropdownList() {
        return sortByDropdownList;
    }

    public WebElement getSortByDropdown() {
        return sortByDropdown;
    }

    public WebElement getPerPageDropdown() {
        return perPageDropdown;
    }

    public List<WebElement> getPerPageDropdownList() {
        return perPageDropdownList;
    }

    public List<WebElement> getAddToCartButtonList() {
        return addToCartButtonList;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public List<WebElement> getOutOfStockButtons() {
        return outOfStockButtons;
    }

    public List<WebElement> getOnePriceList() {
        return onePriceList;
    }
}
