package testScripts.DemoPractice.Selenium_WebDriver_Basic.TimeOutsInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class setScriptTimeout_W {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testVerifytitle() throws Exception {

        long start = System.currentTimeMillis();
        driver.get("http://localhost/whizTrial/");
        assertEquals("WhizTrial Registration", driver.getTitle());


        long current = System.currentTimeMillis();
        long TimeDiff = current - start;

        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

        System.out.println("Elapsed time: " + TimeDiff);


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(7000);
        driver.quit();
    }
}

