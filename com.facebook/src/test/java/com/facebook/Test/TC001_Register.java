package com.facebook.Test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebook_Base.BaseClass;
import com.facebookpackage.RegisterPage;


public class TC001_Register extends BaseClass {
	
	RegisterPage regpageObj;
	
	static Logger logger=Logger.getLogger(TC001_Register.class);
	
	@BeforeTest
	public void setData() {
		fileName="TC001";
		
		testName="Enter Facebook Register Credentials";
		author="Gayathri";
		category="Sanity";
		 
	}
	@Test(dataProvider = "userData")
	public void test_RegisterPage(String[] data) throws InterruptedException, IOException {
		regpageObj=new RegisterPage(driver);
		regpageObj.setFirstName(data[0]);
		regpageObj.setSurName(data[1]);
		regpageObj.setDay(data[2]);
		regpageObj.setMonth(data[3]);
		regpageObj.setYear(data[4]);
		regpageObj.setGender(data[5]);
		regpageObj.setEmail(data[6]);
		regpageObj.setPassword(data[7]);
		regpageObj.clickSignUp();
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("The registration for the user "+data[0]+"is created.\n");
		
		driver.navigate().to(baseurl);
		
		/*
		 * TakesScreenshot screenshot=(TakesScreenshot)driver; File
		 * sourceFile=screenshot.getScreenshotAs(OutputType.FILE); File
		 * destinationFile=new File("bing.png"); FileHandler.copy(sourceFile,
		 * destinationFile); test.addScreenCaptureFromPath("bing.png");
		 */
		
		
	}
	 
}
