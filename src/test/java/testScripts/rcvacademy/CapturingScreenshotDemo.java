package testScripts.rcvacademy;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CapturingScreenshotDemo {

	public static void main(String[] args) throws IOException {

		Date currentdate = new Date();
		// System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com.au/");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));

	}

}
