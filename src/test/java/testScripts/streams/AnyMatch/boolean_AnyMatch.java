package testScripts.streams.AnyMatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class boolean_AnyMatch {
    WebDriver driver = new ChromeDriver();

    @Test
    public void boolean_anyMatch(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        boolean flag = menuList.stream().anyMatch(i -> i.getText().trim().equalsIgnoreCase("Makeup"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        //driver.quit();
    }

    @Test
    public void boolean_anyMatch1(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        boolean flag = menuList.stream().anyMatch(i -> i.getText().trim().equalsIgnoreCase("Books"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        //driver.quit();
    }

    @Test
    public void boolean_anyMatch2(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        boolean flag = menuList.stream().anyMatch(i -> i.getText().trim().contains("SKINCARE"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        //driver.quit();
    }

    @Test
    public void boolean_anyMatch3(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        boolean flag = menuList.stream().anyMatch(i -> i.getText().toUpperCase().trim().equals("SKINCARE"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        driver.quit();
    }


}
