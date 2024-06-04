package testScripts.rcvacademy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SliderDemo {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement category = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[3]/span"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement subcategory = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[4]/a"));	
		subcategory.click();
		

		WebElement slider = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[3]/div[1]/div[1]/div"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[3]/div[2]/div[2]"));
		action.dragAndDrop(slider, drop).perform();
		//action.dragAndDropBy(slider, 220, 472).perform();

		
		
	}

}
