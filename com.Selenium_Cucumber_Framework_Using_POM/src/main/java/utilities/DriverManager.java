package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver=null;
	
	public static WebDriver getDriver() {
		return driver;
	}

	private static Logger logger=Logger.getLogger(DriverManager.class);

	public static void launchBrowser() {
		
		try {
			switch(ConstantsVariable.browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				logger.info("Chrome browser is instantiated");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				logger.info("Firefox browser is instantiated");
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();	
				break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
