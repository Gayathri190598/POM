package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/feature" , 
		glue="steps",
		//dryRun = !true,
		monochrome=true,
		snippets = SnippetType.CAMELCASE,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)

public class Runner {

}
	
	
