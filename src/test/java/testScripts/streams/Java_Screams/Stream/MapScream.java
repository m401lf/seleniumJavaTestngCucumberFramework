package testScripts.streams.Java_Screams.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MapScream{

    @Test
    public void mapTest()  {
    WebDriver driver = new ChromeDriver();
    driver.get("https://automationteststore.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();
    List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
    menuList.stream()
                .parallel()
                .filter(l -> l.isDisplayed() && l.isEnabled())
                //.filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .skip(1)
                .limit(8)
                .sorted()
                .forEachOrdered(System.out::println);

                driver.quit();
    }

}
