package steps;


import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CommonUtils;
import utilities.ConstantsVariable;
import utilities.DriverManager;


public class BaseStep {
	
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
		
	}
	
	Logger logger=Logger.getLogger(BaseStep.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		logger.info("Execution started");

		try {
			scenarioName=scenario.getName();
			CommonUtils.getInstance().loadProperty();		
			logger.info("Checking the driver is null or not.\n");
			if(DriverManager.getDriver()==null) {
				logger.info("The driver is null.Instantiating it.\n");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElements();	
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			logger.info("Get the baseUrl : "+ConstantsVariable.baseUrl+"\n");
			DriverManager.getDriver().get(ConstantsVariable.baseUrl);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * @AfterStep public void attachScreenshot(Scenario scenario) {
	 * if(scenario.isFailed()) { byte[] screenshot=((TakesScreenshot)
	 * DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	 * scenario.attach(screenshot, "image/png", getScenarioName()); } }
	 */

	
	@After
	public void tearDown() {
		DriverManager.getDriver().quit();
	}

}
