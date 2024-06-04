package testScripts.TestngDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.BaseTest;

public class ListenerDemoTest extends BaseTest{
	
	@Test
	public void launchApp()
	{
		
		Reporter.log("Test is starting");
		driver.get("https://ebay.com");
		Assert.assertTrue(false);
		
		
	}
	

}
