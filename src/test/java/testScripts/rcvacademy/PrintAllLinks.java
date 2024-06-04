package testScripts.rcvacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class PrintAllLinks {

	WebDriver driver;

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/au/form/signup/freetrial-elf-v2/?d=70130000000EqoP");
		driver.manage().window().maximize();
		
		List<WebElement> alltags = driver.findElements(By.tagName("option"));
		System.out.println("Total tags are: "+alltags.size());
		
		
		for(int i=0;i<alltags.size();i++)
		{
			System.out.println("Links on page are "+alltags.get(i).getText());
		}

	}

}
