package testScripts.streams.filterDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class filter_collector {
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

    @Test
    public void filterDouble() {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        //List<WebElement> topMenuList = driver.findElements(By.xpath("/html/body/nav/div/div/ul/li"));

            List<String> topMenuList = Arrays.asList("123456789", "My Account", "Wish List (0)", "Shopping Cart", "Checkout");

        List<String> longTopList = new ArrayList<String>();

        longTopList = topMenuList.stream().filter(s->s.length() > 7).toList();

        System.out.println(longTopList);



    }

    @Test
    public void filter2() {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        List<WebElement> topMenuList = driver.findElements(By.xpath("/html/body/nav/div/div/ul/li"));

        topMenuList.stream().filter(s->s.getText().length() > 7)
                .forEach(s-> System.out.println(s.getText()));



    }@Test
    public void filter_any_item_out() {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<String> topMenuList = Arrays.asList("123456789", "My Account", "Wish List (0)", "Shopping Cart", "Checkout");
        List<String> list = topMenuList.stream().filter(s-> !Objects.equals(s, "123456789")).toList();
        System.out.println(list);

    }



}
