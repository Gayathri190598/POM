package steps;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageTitle;
import pageObjects.Register;
import utilities.CommonUtils;
import utilities.ConstantsVariable;

public class PageTitleStep {
	
	Logger logger=Logger.getLogger(PageTitleStep.class);
	String actualTitle;
	
	@Given("the user gets the actual and expected title")
	public void theUserGetsTheActualAndExpectedTitle() {
		 actualTitle=PageTitle.getInstance().getPageTitle();
		 logger.info("The actual page title is : "+actualTitle+"\n");
	}
	
	
	@Then("the user verifies the {string}")
	public void the_user_verifies_the(String title) {
		logger.info("The expected page title is : "+title+"\n");
		try {
			//if(title.equals(actualTitle)) 
			 Assert.assertEquals(actualTitle, title);
		     logger.info("The actual and expected page title is same.\n");
			
			}
			catch (Exception e) {
				logger.error(e);
				//CommonUtils.getInstance().takesScreenshot();
				logger.info("The actual and expected page title is not same.\n");
			}
	}
	    
	}


