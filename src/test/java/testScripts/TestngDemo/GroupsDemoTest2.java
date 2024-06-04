package testScripts.TestngDemo;

import org.testng.annotations.Test;

import common.CommonDataSetup;



public class GroupsDemoTest2 extends CommonDataSetup{

	@Test(priority = 1, groups = "regression")
	public void aTest1()

	{
		System.out.println("atest1");

	}

	@Test(priority = 2, groups = "regression")
	public void bTest2() {
		System.out.println("btest2");

	}

	@Test(groups = { "regression", "bvt" })
	public void bTest3() {
		System.out.println("ctest3");

	}

	@Test(groups = "bvt")
	public void bTest4() {
		System.out.println("dtest4");

	}

}
