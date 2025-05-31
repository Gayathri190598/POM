package commonFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Base {
	
	public static WebDriver driver;
	protected Properties properties;
	
	protected static ExtentSparkReporter sparkReport; 
	protected static ExtentReports extentReports;
	protected static ExtentTest test;
	
	protected String testName="";
	protected String author="";
	protected String category="";
	
	Logger logger=Logger.getLogger(Base.class);
	
	public Properties getPropertyFile() throws IOException {
		FileInputStream file=new FileInputStream("Config.properties");
		properties=new Properties();
		properties.load(file);
		return properties;
	}

	@BeforeSuite
	public void setUpBrowser() throws IOException {
		
		sparkReport=new ExtentSparkReporter("./ExtentReport.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReport);
		
		getPropertyFile();
		String baseUrl=properties.getProperty("url");
		String driverPath=properties.getProperty("driverPath");
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		logger.info("The chrome driver is initialised.\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseUrl);
	}
	
	@BeforeTest
	public void setData() throws IOException {
		getPropertyFile();
		testName=properties.getProperty("testName");
		author=properties.getProperty("author");
		category=properties.getProperty("category");
	}
	
	
	@BeforeClass
	public void createtest() {
		test=extentReports.createTest(testName);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	@AfterSuite
	public void terminate() {
		extentReports.flush();
		driver.quit();
	}

}
