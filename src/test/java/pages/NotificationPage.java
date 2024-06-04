package pages;

import base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class NotificationPage extends BasePage {
    private final WebDriver driver;
    private final static Logger log = LogManager.getLogger(NotificationPage.class);

    public NotificationPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
