package testScripts.streams.minAndmax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class minmax {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void filter1() {

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
