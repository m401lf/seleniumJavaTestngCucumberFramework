package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutEditPaymentPage extends BasePage{
    private final WebDriver driver;
    private final Logger log = LogManager.getLogger(CheckoutEditPaymentPage.class);

    public CheckoutEditPaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}