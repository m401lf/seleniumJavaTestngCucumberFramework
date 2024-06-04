package testScripts.streams.forEachDemoClick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class forEach_click {

    WebDriver driver = new ChromeDriver();

    @Test
    public void forEachThenClick(){
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().contains("APPAREL & ACCESSORIES"))
                .forEach(WebElement::click);
    }
}
