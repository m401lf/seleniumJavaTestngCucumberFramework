package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentModeEditPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(PaymentModeEditPage.class);

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;
    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;

    public PaymentModeEditPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
