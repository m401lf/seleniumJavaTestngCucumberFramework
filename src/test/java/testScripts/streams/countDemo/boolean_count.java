package testScripts.streams.countDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class boolean_count {

    @Test
    public void startWith(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        long d = menuList
                .stream()
                .map(WebElement::getText).filter(s -> {
                    s.startsWith("M");
                    return true;
                })
                .count();

        System.out.println("count-result :: " + d);

        driver.quit();


    }

    @Test
    public void startWith1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        long count = menuList
                .size();

        System.out.println("count-result :: " + count);

        driver.quit();


    }

}

