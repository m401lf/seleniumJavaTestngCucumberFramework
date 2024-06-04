package testScripts.rcvacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ResizeDemo1 {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		/*
		 * driver.get("https://jqueryui.com/resizable/");
		 * driver.manage().window().maximize(); WebElement frame =
		 * driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		 * driver.switchTo().frame(frame); WebElement element =
		 * driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		 * 
		 * Actions action = new Actions(driver); action.dragAndDropBy(element, 300,
		 * 100).perform();
		 */
		
		
		  driver.get("https://jqueryui.com/slider/#colorpicker");
		  driver.manage().window().maximize(); 
		  WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		  driver.switchTo().frame(frame); 
		  WebElement greenslider = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
		  
		  Actions action = new Actions(driver); 
		  action.dragAndDropBy(greenslider, -100, 125).perform();
		  

		 
		
		
	}

}
