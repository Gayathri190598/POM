package test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonFunction.Base;
import pageObjects.AddToCart;
import pageObjects.MobilePage;
import pageObjects.SonyXperia;
import pageObjects.TechpandaHomePage;

public class TC001_TestClass extends Base{
	
	TechpandaHomePage homepageObj;
	MobilePage mobileObj;
	SonyXperia sonyObj;
	AddToCart cartObj;
	
	TakesScreenshot screenshot;
	
	Logger logger=Logger.getLogger(TC001_TestClass.class);
	
	
	@Test(priority=1)
	public void test_Homepage() throws IOException {
		getPropertyFile();
		PropertyConfigurator.configure("log4j.properties");
		String actualHomePageTitle=properties.getProperty("actualHomePageTitle");
		homepageObj=new TechpandaHomePage(driver);
		logger.info("The actual home page title is : "+actualHomePageTitle+"\n");
		String expectedHomePageTitle=homepageObj.getPageTitle();
		logger.info("The expected home page title is : "+expectedHomePageTitle+"\n");
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle.toUpperCase());
		logger.info("The actual tile and expected title of home page are same.\n");
		test.log(Status.PASS, "The actual and expected home page title are same.");
	}
	
	@Test(priority=2)
	public void clickOnMobileMenu() {
		PropertyConfigurator.configure("log4j.properties");
		homepageObj.clickMobileMenu();
		logger.info("The mobile menu is clicked.\n");
		test.log(Status.PASS, "The mobile menu is clicked.");
	}
	
	@Test(priority=3)
	public void test_MobileMenuPage() throws IOException{
		getPropertyFile();
		PropertyConfigurator.configure("log4j.properties");
		mobileObj=new MobilePage(driver);
	    String actualMobilePageTitle=properties.getProperty("actualMobilePageTitle");
	    logger.info("The actual Mobile page title is : "+actualMobilePageTitle+"\n");
		String expectedMobilePageTitle=mobileObj.getPageTitle();
		logger.info("The expected home page title is : "+expectedMobilePageTitle+"\n");
		Assert.assertEquals(actualMobilePageTitle, expectedMobilePageTitle.toUpperCase());
		logger.info("The actual tile and expected title of Mobile page are same.\n");
		test.log(Status.PASS, "The actual and expected mobile page title are same.");
	}
	
	@Test(priority=4)
	public void sortByName() throws IOException {
		getPropertyFile();
		PropertyConfigurator.configure("log4j.properties");
		String sortByName=properties.getProperty("sortBy");
		String value=mobileObj.sortingOptions(sortByName);
		Assert.assertEquals(sortByName, value);
		logger.info("The mobiles are sorted by Name.\n");
		test.log(Status.PASS, "The mobiles are sorted by Name.");
	}
	
	@Test(priority=5)
	public void checkPriceOfSonyXperia() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		sonyObj=new SonyXperia(driver);
		String listPrice=sonyObj.getListPagePrice();
		sonyObj.clickOnSonyXperia();
		String detailPrice=sonyObj.getDetailPagePrice();
		Assert.assertEquals(listPrice, detailPrice);
		logger.info("The listing page price and the detail page price of Sony Xperia is same.\n");
		test.log(Status.PASS, "The listing and detail page price of Sony Xperia are same.");	
		
		screenshot=(TakesScreenshot)driver; 
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("SonyXperia.png");
		FileHandler.copy(sourceFile,destinationFile);
		test.addScreenCaptureFromPath("SonyXperia.png");
		logger.info("A screenshot of SonyXperia is taken.\n");
	}
	
	@Test(priority=6)
	public void clickOnAddToCart() throws IOException {
		getPropertyFile();
		PropertyConfigurator.configure("log4j.properties");
		String qty=properties.getProperty("qty");
		cartObj=new AddToCart(driver);
		cartObj.setQuantity(qty);
		logger.info("The number of Sony Xperia quantity to be added to cart is : "+qty+"\n");
		cartObj.clickAddToCart();
		logger.info("The products are added to cart.\n");
		test.log(Status.PASS, "The products are added to cart.");
	}

}
