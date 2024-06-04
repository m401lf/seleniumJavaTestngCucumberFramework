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

public class SubscribePage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(SubscribePage.class);

    public SubscribePage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="appendedInputButton")
    private WebElement subscribeToNewsletterBox;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement subscribeButton;


}
