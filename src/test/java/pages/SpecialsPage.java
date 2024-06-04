package pages;

import base.BasePage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SpecialsPage extends BasePage {
    private WebDriver driver;
    private final Logger log = LogManager.getLogger(SpecialsPage.class);


    public SpecialsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}