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
import org.testng.annotations.Test;

public class Gmail_Login {
	WebDriver driver;
	String baseUrl="https://www.google.com";
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@BeforeTest
	public void beforeTest() {
	//System.setProperty("webdriver.gecko.driver", "C:\\Selenium Webdriver\\FireFoxDriver\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.navigate().to(baseUrl);
	}
	
	@Test
	public void Open_gmail() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.findElement(By.xpath("//a[@href='https://www.google.co.in/intl/en/about/products']")).click();
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("No.of iframes are: "+size);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//html/body/div/c-wiz/div/div/c-wiz/div/div/div/div[2]/div/ul/li[6]/a//span)[2]")).click();
		Thread.sleep(3000); 
  }
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
