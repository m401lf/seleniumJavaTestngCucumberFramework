package testScripts.TestngDemo;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonDataSetup;


public class LoginTest1 extends CommonDataSetup{
	
	@BeforeTest
	public void loginToApplication()
	{
		System.out.println("Login to application");
	}
	
	@AfterTest
	public void logoutFromApplication()
	{
		System.out.println("Logout from application");
	}

	@BeforeMethod
	public void connectToDB()
	{
		System.out.println("DB COnnected");
	}
	
	@AfterMethod
	public void disconnectFromDB()
	{
		System.out.println("Disconnect DB COnnected");
	}
	
	@Test(priority=1,description="This is a login test",groups="regression")
	public void aTest1()
	
	{
		System.out.println("test1");

	}
	
	@Test(priority=2,description="This is a logout test")
	public void aTest2()
	{
		System.out.println("test2");
				
	}

}
