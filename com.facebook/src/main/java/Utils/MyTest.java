package Utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends ExtentReport{
	
	@BeforeTest
	public void setData() {
		testDesc="TC001";
		author="Gayathri";
		category="Sanity";
	}
	
	@Test
	public void myTest() {
		System.out.println("Test begins");
		stepReport("pass","The test case passed");
		System.out.println("Test Ends");
	}

}
