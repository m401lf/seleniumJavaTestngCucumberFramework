package testScripts.streams.Java_Screams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class Loop_InScream{
 WebDriver driver;

    @Test
    public void IntStream_Test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));

        IntStream.range(1,21)
                .forEach(i -> System.out.println(i + " :: " + menuList.get(i).getText()));

    }

    @Test
    public void IntStream_ClosedTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));

        IntStream.rangeClosed(1,20)
                .forEach(i -> System.out.println(i + " :: " + menuList.get(i).getText()));

    }
}
