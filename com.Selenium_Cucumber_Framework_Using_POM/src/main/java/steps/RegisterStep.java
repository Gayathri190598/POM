package steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Register;
import utilities.CommonUtils;
import utilities.ConstantsVariable;
import utilities.DriverManager;

public class RegisterStep {
	
	Logger logger=Logger.getLogger(RegisterStep.class);


	@Given("the user enters the details")
	public void theUserEntersTheDetails(DataTable userCredentials) {
	   List<Map<String,String>> keyValuePair=userCredentials.asMaps(String.class, String.class);
	   Register.getInstance().enterFirstName(keyValuePair.get(0).get("fname"));
	   Register.getInstance().enterLastName(keyValuePair.get(0).get("lname"));
	   Register.getInstance().enterDay(keyValuePair.get(0).get("day"));
	   Register.getInstance().enterMonth(keyValuePair.get(0).get("month"));
	   Register.getInstance().enterYear(keyValuePair.get(0).get("year"));
	   Register.getInstance().selectGender(keyValuePair.get(0).get("gender"));
	   Register.getInstance().enterEmail(keyValuePair.get(0).get("email"));
	   Register.getInstance().enterPassword(keyValuePair.get(0).get("password"));
	}
	
	@Then("the user clicks on submit")
	public void clickOnTheSubmitButton() {
		Register.getInstance().clickSubmit();
		logger.info("The registration is successful...\n");
	}
		
	
	@Given("the user enters firstname {string}")
	public void theUserEntersFirstname(String fname) {
		Register.getInstance().enterFirstName(fname);
		
	}
	
	@And("the user enters lastname {string}")
	public void theUserEntersLastname(String lname) {
		Register.getInstance().enterLastName(lname);
	}
	
	@And("the user enters day {string}")
	public void theUserEntersDay(String day) {
		Register.getInstance().enterDay(day);
	}
	
	@And("the user enters month {string}")
	public void theUserEntersMonth(String month) {
		Register.getInstance().enterMonth(month);
	}
	
	@And("the user enters year {string}")
	public void theUserEntersYear(String year) {
		Register.getInstance().enterYear(year);
	}
	
	@And("the user enters gender {string}")
	public void theUserEntersGender(String gender) {
		Register.getInstance().selectGender(gender);
	}
	
	@And("the user enters email {string}")
	public void theUserEntersEmail(String email) {
		Register.getInstance().enterEmail(email);
	}
	
	@And("the user enters password {string}")
	public void theUserEntersPassword(String password) {
		Register.getInstance().enterPassword(password);
	}

}
