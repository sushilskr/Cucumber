package cucumberOptions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinitions", 
		monochrome=true,
		dryRun = false,
		plugin= {"html:target/cucumber.html","rerun:target/failed_scenarios.txt"},
		tags="@MulitpleItemOrder"
		)
//tags="@MulitpleItemOrder" "@PlaceOrder"  "@OffersPage"
//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
	

}
