package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class L11_Parameters {

	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
	}

	@Parameters({ "email", "password" })
	@Test
	public void signin(String email, String password) throws InterruptedException {
		driver.get("http://teststore.automationtesting.co.uk/");
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("user has logged in");
		Thread.sleep(2000);
	}

	@AfterSuite
	public void end() {
		driver.close();
		driver.quit();
	}

}
