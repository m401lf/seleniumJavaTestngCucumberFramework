package testScripts.streams.Java_Screams.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ForEach_click_Screams{
    WebDriver driver = new ChromeDriver();

    @Test
    public void filter_Screams(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        menuList.stream()
                .filter(WebElement::isEnabled)
                .forEach(i -> System.out.println(i.getText()));

    }
    @Test
    public void filter1_Screams(){
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        List<WebElement> list = menuList.stream().filter(l -> l.isDisplayed() &&  l.isEnabled()).toList();
        System.out.println(list);
        list.stream()
                .filter(l -> l.isDisplayed() && l.isEnabled())
                .map(a -> a.getText())
                .forEach(l -> System.out.println());
        list.stream()
                .parallel()
                .filter(l -> l.isDisplayed() && l.isEnabled())
                .forEach(System.out::println);

    }
@Test
    public void forEach_click(){
    driver = new ChromeDriver();
    driver.get("https://automationteststore.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();
    List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
    menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().startsWith("A"))
                .filter(s -> s.getText().equalsIgnoreCase("APPAREL & ACCESSORIES"))
                .forEach(WebElement::click);
    }

    @Test
    public void  click(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase("MAKEUP"))
                .findFirst()
                .ifPresent(WebElement::click);

    }

    @Test
    public void  findFirst_ifPresent_click(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().startsWith("M"))
                .filter(s -> s.getText().equalsIgnoreCase("MAKEUP"))
                .forEach(WebElement::click);
        }

        @Test
        public void  filter_startsWith_click(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://automationteststore.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
            menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase("ACCESSORIES"))
                .filter(s -> s.getText().startsWith("A"))
                .forEach(WebElement::click);


    }

 }


