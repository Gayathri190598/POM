package Maven_Testng_package;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google_Search {
	public WebDriver driver;
	public String baseUrl="https://www.google.com";
	String chromedriverPath="C:\\Selenium Webdriver\\chromeDriver\\chromedriver-win64\\chromedriver.exe";
	String firefoxdriverPath="C:\\Selenium Webdriver\\FireFoxDriver\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe";
	String title;
	
	@Parameters({"search" , "browser"})
	@Test()
	public void launchBrowser(String value , String browser) throws InterruptedException {
		switch (browser) {
		case "Chrome": {
			//System.setProperty("webdriver.chrome.driver", chromedriverPath);
			driver=new ChromeDriver();
			break;
		}
		case "Firefox": {
			//System.setProperty("webdriver.gecko.driver", firefoxdriverPath);
			driver= new FirefoxDriver();
			break;
		}
		default:
			System.err.println("browser is not defined");
		}
	
    driver.get(baseUrl);
   // WebDriverWait wait=new WebDriverWait (driver, Duration.ofSeconds(20));
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(value);
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		driver.quit();
	}
}
