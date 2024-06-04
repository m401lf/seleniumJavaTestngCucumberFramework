package testNG;

import org.testng.annotations.Test;

public class L10b_TestngXml {

	@Test (groups= {"smoke", "regression"})
	public void method3() {
		System.out.println("Hello World from method 3");
	}

	@Test (groups= {"regression"})
	public void method4() {
		System.out.println("Hello World from method 4");
	}
	
	@Test (groups= {"regression"})
	public void method5() {
		System.out.println("Hello World from method 5");
	}

}
