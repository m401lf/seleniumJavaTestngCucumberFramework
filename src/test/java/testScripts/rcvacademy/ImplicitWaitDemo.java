package testScripts.rcvacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[6]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("RCV Academy: This is custom message");
				

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id='mainContent']/div[1]/ul/li[6]/div[2]/div[1]/div[2]/ul/li[1]/a/jhfgjhf"))).click();

	}

}
