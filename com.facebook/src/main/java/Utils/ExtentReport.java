package Utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	 ExtentSparkReporter sparkReport;
	 ExtentReports extentReports;
	 ExtentTest test;
	
	String testDesc="";
	String author="";
	String category="";
	
	@BeforeSuite
	protected void startExtentReport() {	
		sparkReport=new ExtentSparkReporter("./TestReport.html");	
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReport);	
	}
	
	@AfterSuite
	protected void stopExtentReport() {
		extentReports.flush();
	}
	@BeforeClass
	 void createTest() {
		test = extentReports.createTest(testDesc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	  void stepReport(String status, String description) {
		switch(status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		case "info":
			test.info(description);
			break;
		case "warning":
			test.warning(description);
			break;
		default:
			System.err.println("Status is not defined");
			break;
		}
		
	}

}
