package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Register;
import steps.BaseStep;


public class CommonUtils {
	
	private static CommonUtils commonUtilsInstance;
	
	private CommonUtils() {
		
	}
	
	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) 
			commonUtilsInstance=new CommonUtils();
		return commonUtilsInstance;
		
	}
	
	public void loadProperty() {
		Properties properties=new Properties();
			try {
				properties.load(getClass().getResourceAsStream("/Config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		ConstantsVariable.baseUrl=properties.getProperty("baseUrl");
		ConstantsVariable.driverPath=properties.getProperty("driverPath");
		ConstantsVariable.browser=properties.getProperty("browser");
		ConstantsVariable.expectedTitle=properties.getProperty("expectedTitle");
		ConstantsVariable.fName=properties.getProperty("fName");
		ConstantsVariable.lName=properties.getProperty("lName");
		ConstantsVariable.day=properties.getProperty("day");
		ConstantsVariable.month=properties.getProperty("month");
		ConstantsVariable.year=properties.getProperty("year");
		ConstantsVariable.gender=properties.getProperty("gender");
		ConstantsVariable.email=properties.getProperty("email");
		ConstantsVariable.password=properties.getProperty("password");

	}
	
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), Register.getInstance());
	}
	
	/*
	 * public void takesScreenshot() { File screenshot=((TakesScreenshot)
	 * DriverManager.getDriver()).getScreenshotAs(OutputType.FILE); try {
	 * FileUtils.copyFile(screenshot, new File(BaseStep.getScenarioName()+".png"));
	 * } catch (IOException e1) { e1.printStackTrace(); }
	 * 
	 * }
	 */
	
	

}
