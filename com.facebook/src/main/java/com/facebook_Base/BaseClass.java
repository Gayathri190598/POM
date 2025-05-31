package com.facebook_Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.ReadDataFromExcel;

public class BaseClass {

	protected static String baseurl="https://www.facebook.com/reg/";
	String driverPath="C:\\Selenium Webdriver\\chromeDriver\\chromedriver-win64\\chromedriver.exe";
	protected WebDriver driver;	


	protected static ExtentSparkReporter sparkReport; 
	protected static ExtentReports extentReports;
	public static ExtentTest test;

	protected static String testName=""; 
	protected static String author=""; 
	protected static String category="";


	public String fileName="";

	@DataProvider(name = "userData")
	public String[][] dataProvider() throws IOException {
		String[][] excelData=ReadDataFromExcel.getDataFromExcel(fileName);
		return excelData;
	}

	@BeforeClass
	public void browserSetUp() {
		test = extentReports.createTest(testName);
		test.assignAuthor(author); 
		test.assignCategory(category); 

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		test.log(Status.PASS, "Chrome driver initialised");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.log(Status.PASS, "Open the facebook register page");
		driver.get(baseurl);

	}


	@AfterClass public void tearDown() { 
		driver.quit();
	}


	@BeforeSuite protected void startExtentReport() { 
		sparkReport=new ExtentSparkReporter("./TestReport.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReport); 
		}

	@AfterSuite
	protected void stopExtentReport() {
		extentReports.flush(); 
	}

	/*
	 * @BeforeClass void createTest() { test = extentReports.createTest(testName);
	 * test.assignAuthor(author); test.assignCategory(category); }
	 */
	
	//}




}
