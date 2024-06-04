package testScripts.TestngDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleAndTextTest {
	
	@Test
	public void titleTest() throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		String expectedtitle = "Electronics, ertt Cars, Fashion, Collectibles & More | eBay";
		String expectedtext = "Searchdfgdf";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String actualtitle = driver.getTitle();
		System.out.println("Verifying title");
		softassert.assertEquals(actualtitle, expectedtitle, "Title verification failed");
		String actualtext = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
		System.out.println("Verifying text");
		softassert.assertEquals(actualtext, expectedtext, "Text verification failed");
		System.out.println("Closing browser");
		driver.close();
		softassert.assertAll();
	}


}
