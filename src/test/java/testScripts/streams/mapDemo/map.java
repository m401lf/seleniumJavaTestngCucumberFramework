package testScripts.streams.mapDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class map {
    WebDriver driver;

    @Test
    public void filter1() {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        List<WebElement> topMenuList = driver.findElements(By.xpath("/html/body/nav/div/div/ul/li"));

        List<String> originalList = topMenuList.stream()
                .parallel()
                //.filter(s-> s.getText().startsWith("My"))
                .filter(s-> s.isDisplayed() && s.isEnabled())
                .map(WebElement::getText)
                .toList();

        List<String> sortedList = originalList.stream().sorted().toList();

        topMenuList.stream().parallel().map(WebElement::getText).forEach(System.out::println);
        System.out.println("======================originalList===========================");
        System.out.println(originalList);

    }



}
