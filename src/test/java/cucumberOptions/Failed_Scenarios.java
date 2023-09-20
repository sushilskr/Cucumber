package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue="stepDefinitions", 
		monochrome=true,
		plugin= {"html:target/cucumber.html"},
		tags="@OffersPage"
		)
//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
public class Failed_Scenarios extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
