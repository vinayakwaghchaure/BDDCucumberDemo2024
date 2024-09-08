package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * @CratedBy Vinayak 
 * @date 21-08-2024
 * 
 */
@CucumberOptions(features = ("src\\test\\java\\feature"),
			//tags = "@tc_abc1",
			glue = { "stepDefination" },                
			plugin = {
					 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				 	 "timeline:test-output-thread/",	
			}

		, monochrome = true
//		, dryRun = true
			
)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}