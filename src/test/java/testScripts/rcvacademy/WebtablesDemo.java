package testScripts.rcvacademy;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtablesDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.asx.com.au/");

		// Step 1 - Switch to frame which has that particular table
		// Step 2 - Get the number of rows
		// Step 3 - Get the number of columns
		// Step 4 - iterate rows and columns and get text and print it

		WebElement frame1 = driver.findElement(By.id("announcements-frame"));
		driver.switchTo().frame(frame1);

		List<WebElement> rowelements = driver
				.findElements(By.xpath("//*[@id=\"announcement_data_widget\"]/table/tbody/tr"));
		System.out.println(rowelements.size());
		int rowsize = rowelements.size();

		List<WebElement> columnelements = driver
				.findElements(By.xpath("//*[@id=\"announcement_data_widget\"]/table/tbody/tr[1]/td"));
		System.out.println(columnelements.size());
		int colsize = columnelements.size();

		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= colsize; j++) {

				System.out.print(driver.findElement(
						By.xpath("//*[@id=\"announcement_data_widget\"]/table/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText()+ "  ");

			}
			System.out.println();
		}

	}

}
