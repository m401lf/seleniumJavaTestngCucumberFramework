package testScripts.rcvacademy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MouseOver {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		
	}

}
