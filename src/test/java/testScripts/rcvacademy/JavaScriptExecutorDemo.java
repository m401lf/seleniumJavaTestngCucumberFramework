package testScripts.rcvacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		JavascriptExecutor jsexec = (JavascriptExecutor) driver;
		
		// Get page title
		String script = "return document.title;";
		String text = (String) jsexec.executeScript(script);
		System.out.println(text);

		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("/html/body/button"));
	
		// Highlighting the button
		jsexec.executeScript("arguments[0].style.border='5px solid green';", element);
		
		//Click button
		jsexec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		// Scroll element into view
		driver.navigate().to("https://www.w3schools.com/");	
		WebElement element1 = driver.findElement(By.xpath("//*[@id='certsection']/p/a"));
		jsexec.executeScript("arguments[0].scrollIntoView(true);", element1);
		
		


	}

}
