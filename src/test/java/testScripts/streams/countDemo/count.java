package testScripts.streams.countDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class count {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        List<WebElement> menuList = driver.findElements(By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li/a"));
        System.out.println("Count :: "
                + menuList
                .stream()
                .filter(s->s.getText().length() > 5)
                .count());

        driver.quit();
    }

}
