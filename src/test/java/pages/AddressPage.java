package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {

     final static Logger log = LogManager.getLogger(AddressPage.class);
    private final WebDriver driver;


    public AddressPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
