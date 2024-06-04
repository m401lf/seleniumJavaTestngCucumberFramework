package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L13_DependsOnMethods {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://teststore.automationtesting.co.uk/login?back=my-account");
		Thread.sleep(3000);
	}

	@Test
	public void enterEmail() throws InterruptedException {
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		Thread.sleep(3000);
	}

	@Test
	public void enterPassword() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = { "enterPassword" })
	public void clickBtn() throws InterruptedException {
		driver.findElement(By.cssSelector("button#submit-login")).click();
	}

}
