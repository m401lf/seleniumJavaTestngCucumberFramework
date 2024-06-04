package testScripts.streams.mapDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class map_forEachOrdered{

@Test
    public void map() throws IOException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://automationteststore.com/");
    List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
                menuList
                .stream()
                .parallel()
                .filter(l -> l.isDisplayed() && l.isEnabled())
                .map(WebElement::getText)
                //.skip(1)
                .limit(8)
                .sorted()
                .forEachOrdered(System.out::println);
    }

}
