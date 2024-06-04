package testScripts.rcvacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
		  WebElement ddown = driver.findElement(By.name("employees_c")); Select select
		  = new Select(ddown);
		  
		  WebElement firstOption = select.getFirstSelectedOption();
		  System.out.println(firstOption.getText());
		  
		  select.selectByValue("level1"); Thread.sleep(2000);
		  
		  select.selectByVisibleText("51 � 100 employees"); Thread.sleep(2000);
		  
		  select.selectByIndex(5); Thread.sleep(2000);
		  
		  
		 

		/*
		 * WebElement ddown = driver.findElement(By.id("multi-select")); Select select =
		 * new Select(ddown); select.selectByValue("California"); Thread.sleep(2000);
		 * select.selectByIndex(5); Thread.sleep(2000); List<WebElement> allItems =
		 * select.getAllSelectedOptions(); System.out.println(allItems.size());
		 * select.deselectAll(); Thread.sleep(2000); select.selectByValue("California");
		 * Thread.sleep(2000); select.selectByIndex(5); Thread.sleep(2000);
		 * select.deselectByIndex(5); Thread.sleep(2000); List<WebElement> allItems1 =
		 * select.getAllSelectedOptions(); System.out.println(allItems1.size());
		 */
		  

	}

}
