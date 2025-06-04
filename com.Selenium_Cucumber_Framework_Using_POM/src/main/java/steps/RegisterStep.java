package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Register;
import utilities.CommonUtils;
import utilities.ConstantsVariable;
import utilities.DriverManager;

public class RegisterStep {
	
	Logger logger=Logger.getLogger(RegisterStep.class);
	
	
	
	@Given("check the pagetitle {string}")
	public void checkThePagetitle(String expectedTitle) {
		String actualtitle = Register.getInstance().getPageTitle();
	    logger.info("The actual page title is : "+actualtitle+"\n");
	    logger.info("The expected page title is : "+ConstantsVariable.expectedTitle+"\n");
	    Assert.assertEquals(actualtitle, expectedTitle);
	    logger.info("The actual and expected page title is not same.\n");
		//CommonUtils.getInstance().takesScreenshot();
	}
	
	@When("enter first name {string}")
	public void enterFirstName(String fName) {
		Register.getInstance().enterFirstName(ConstantsVariable.fName);
		logger.info("The user enters the first name as : "+ConstantsVariable.fName+"\n");
	}
	
	@When("enter last name  {string}")
	public void enterLastName(String lName) {
		Register.getInstance().enterLastName(ConstantsVariable.lName);
	    logger.info("The user enters the last name as : "+ConstantsVariable.lName +"\n");

	}
	
	@When("enter day is {string}")
	public void enterDayIs(String day) {
		Register.getInstance().enterDay(ConstantsVariable.day);
	    logger.info("The user enters the day as : "+ConstantsVariable.day +"\n");
	}
	
	@When("enter month is {string}")
	public void enterMonthIs(String month) {
		Register.getInstance().enterMonth(ConstantsVariable.month);
		logger.info("The user enters the month as : "+ConstantsVariable.month+"\n");
	}
	
	@When("enter year is {string}")
	public void enterYearIs(String year) {
		Register.getInstance().enterYear(ConstantsVariable.year);
		logger.info("The user enters the year as : "+ConstantsVariable.year +"\n");
	}
	
	@When("enter gender is {string}")
	public void enterGenderIs(String gender) {
		Register.getInstance().selectGender(ConstantsVariable.gender);
		logger.info("The user enters the gender as : "+ConstantsVariable.gender +"\n");
	}
	
	@When("enter email is {string}")
	public void enterEmailIs(String email) {
		Register.getInstance().enterEmail(ConstantsVariable.email);
	    logger.info("The user enters the email as : "+ConstantsVariable.email +"\n");
	}
	
	@When("enter password is {string}")
	public void enterPasswordIs(String password) {
		Register.getInstance().enterPassword(ConstantsVariable.password);
		logger.info("The user enters the password as : "+ConstantsVariable.password +"\n");
	}
	
	@Then("click on the submit button")
	public void clickOnTheSubmitButton() {
		Register.getInstance().clickSubmit();
		logger.info("The user clicks the submit button...\n");
	}

}
