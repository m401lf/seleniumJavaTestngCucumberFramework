package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L08_Annotation_Pt1 {
	
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sbrun\\OneDrive - Learn Automation\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		Thread.sleep(2000);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.automationtesting.co.uk");
		Thread.sleep(2000);
	}

	@AfterSuite
	public void end() {
		driver.close();
		driver.quit();
	}

}
