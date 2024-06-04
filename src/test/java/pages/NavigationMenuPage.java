package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class NavigationMenuPage extends BasePage{
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(NavigationMenuPage.class);

    public NavigationMenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li/a")
    private List<WebElement> categories;

    @FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li/div/ul/li")
    private List<WebElement> subCategoriesDropdownList;

    @FindBy(css = ".active.menu_home")
    private WebElement homeDropdownButton;



    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[2]/a")
    private WebElement apparelAccessoriesDropdownButton;
    @FindBy(xpath = "//*[@id=   nk-=-0721q  a'categorymenu']/nav/ul/li[3]/a")
    private WebElement makeupDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[4]/a")
    private WebElement skincareDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[5]/a")
    private WebElement fragranceDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[6]/a")
    private WebElement menDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[7]/a")
    private WebElement hairCareDropdownButton;
    @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[8]/a")
    private WebElement booksDropdownButton;


    public List<WebElement> getCategories() {
        return categories;
    }


    public ProductCategoryPage hoverOverProductCategoryAndClickItemFromDropdownList(String category, String item) throws InterruptedException, IOException {

        List<WebElement>
                element = getCategories()
                .stream()
                .parallel()
                .filter(cat -> cat.getText().contains(category)).toList();
        WebElement desiredCategory =
                element.stream()
                        .parallel()
                        .filter(cat -> cat.getText().contains(category))
                        .findFirst()
                        .orElse(null);
        moveToElement(desiredCategory);
        log.info("Hover over the product category :: " +category);
        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+item+"')]"));
        ele.click();
        log.info("Click on an item product category dropdown :: " +item);
        return new ProductCategoryPage(driver);
    }




}