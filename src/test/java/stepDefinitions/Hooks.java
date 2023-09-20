package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	public WebDriver driver;
	
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
		this.driver = testContextSetup.testBase.webDriverManager();
	}
	
	@After
	public void afterScenario() throws IOException {
		testContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourceFile);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
