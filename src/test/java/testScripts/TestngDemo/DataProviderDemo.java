package testScripts.TestngDemo;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {

	@DataProvider(name = "create")

	public Object[][] dataSet1(Method m) {

		Object[][] testdata = null;

		if (m.getName().equals("test")) 
		{
			testdata = new Object[][] 
				{ 
				{ "username", "password" }, 
				{ "username1", "password1" },	
				{ "username2", "password2" }, 
				{ "username3", "password3" } 
				};
		}
 
		else if (m.getName().equals("test1")) 
		{
			testdata = new Object[][]
			{ 
			{ "username", "password", "third" }, 
			{ "username1", "password1", "third1" },		
			{ "username2", "password2", "third2" }, 
			{ "username3", "password3", "third3" }
			};
		}
		
		else if (m.getName().equals("test2")) 
		{
			testdata = new Object[][]
			{ 
			{ "username", "password", "third", "fourth" }, 
			{ "username1", "password1", "third1", "fourth" },		
			{ "username2", "password2", "third2", "fourth" }, 
			{ "username3", "password3", "third3", "fourth" }
			};
		}
		
		return testdata;

	}

}
