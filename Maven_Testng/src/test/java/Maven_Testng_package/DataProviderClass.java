package Maven_Testng_package;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.DataUtils;

public class DataProviderClass {
	public WebDriver driver;
	public String baseUrl="https://www.google.com";

	@Test(dataProvider = "search", dataProviderClass = DataUtils.class)
	public void search(String data[]) {

		System.err.println(data[0]);
		//System.err.println(data[1]);

	
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.navigate().to(baseUrl);
		  
		  driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(data[0]);
		  System.err.println("The search value is: "+data[0]);
		  driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		  driver.quit();
		

	}
}
