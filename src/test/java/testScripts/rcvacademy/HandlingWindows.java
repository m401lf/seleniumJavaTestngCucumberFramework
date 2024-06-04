package testScripts.rcvacademy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/au/");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/div[6]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/a")).click();
		Thread.sleep(4000);
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out.println(parentwindow);
		String childwindow = iterator.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("RCV");
		driver.findElement(By.name("UserLastName")).sendKeys("Academy");
		driver.switchTo().window(parentwindow);


	}

}
