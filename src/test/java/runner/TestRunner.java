package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "src/test/resources/features", // Feature file location
				// features = "src/test/resources/features/SignUp.feature",  
				// features = "src/test/resources/features/Login.feature",  
				glue = {"stepdefs","AppHooks"},						// Stepdef file location
				plugin = {
						"pretty",
						"html:target/cucumber-reports/html-report.html",
						"json:target/cucumber-reports/report.json",
				        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"  
						}, // Cucumber report file location
				monochrome = true,							// Output/Report should be in Nice & allign format
				publish = false								// Publish reports On Cloud
				)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
