package testScripts.streams.iterate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class iterate {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void IntStream_Test(){
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        IntStream.range(1,8)
                .forEach(i -> System.out.println(i + " :: " + menuList.get(i).getText()));

    }

    @Test
    public void IntStream_ClosedTest(){
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        IntStream.rangeClosed(1,7)
                .forEach(i -> System.out.println(i + " :: " + menuList.get(i).getText()));

    }


}
