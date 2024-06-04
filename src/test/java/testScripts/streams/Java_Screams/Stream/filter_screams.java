package testScripts.streams.Java_Screams.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class filter_screams {


public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://automationteststore.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();

    List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
                menuList
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase("SKINCARE"))
                .forEach(WebElement::click);
                Thread.sleep(5000);
    driver.quit();
    }


}
