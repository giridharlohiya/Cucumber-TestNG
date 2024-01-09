package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", // Feature file location
				glue = {"stepdefs","AppHooks"},						// Stepdef file location
				plugin = {"pretty", "html:C:/Users/GiridharLohiya/Cucumber_TestNG/target/cucumber-reports"}, // Cucumber report file location
				monochrome = true,							// Output/Report should be in Nice & allign format
				publish = true								// Publish reports On Cloud
				)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
