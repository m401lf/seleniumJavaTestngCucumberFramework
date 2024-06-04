package testScripts.SeleniumWebDriverBasic.differentWebDrivers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class chrome_W {

    WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("http://localhost/whizTrial/");
        assertEquals(driver.getTitle(), "WhizTrial Registration");
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
