package testScripts.SeleniumWebDriverBasic.WebElementInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class findElementby_R {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium Project\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.co.in/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void findElement() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("btnG")).click();  // Click on the search button
        driver.findElement(By.linkText("Selenium WebDriver")).click(); // Click on the 'Selenium WebDriver link text'
        Thread.sleep(3000);
        assertEquals(driver.getTitle(), "Selenium WebDriver");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}


