package testScripts.streams.Java_Screams;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Filter_Screams{


    @Test
    public void filter_Screams() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));

        menuList.stream()
                .filter(l -> l.isDisplayed() && l.isEnabled())
                .forEach(i -> System.out.println(i.getText()));

    }
    public void filter_Screams1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));

        List<WebElement> mmm = menuList.stream().filter(l -> l.isDisplayed() &&  l.isEnabled()).toList();
        //System.out.println(mmm);
        //mmm.stream().filter(l -> l.isDisplayed() && l.isEnabled()).forEach(l -> System.out.println(l.getText()));
        mmm.stream().filter(l -> l.isDisplayed() && l.isEnabled()).forEach(System.out::println);

    }


}
