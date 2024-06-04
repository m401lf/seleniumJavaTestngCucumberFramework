package testScripts.TestngDemo;


import org.testng.Assert;
import org.testng.annotations.Test;


public class DependencyTest {

	@Test
	public void userRegistration()

	{
		System.out.println("This is test1");
		Assert.assertTrue(false);

	}

	@Test(dependsOnMethods="userRegistration",alwaysRun=true)
	public void userSearch() {

		System.out.println("This is test2");

	}

	@Test
	public void reporterTest3() {

		System.out.println("This is test3");

	}

	@Test
	public void reporterTest4() {
		System.out.println("This is test4");

	}

}
