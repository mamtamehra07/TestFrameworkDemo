package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, 
				  glue = { "steps", "hooks" },
		plugin = {"pretty","json:target/cucumber/Cucumber.json","junit:target/cucumber/Cucumber.xml","html:target/cucumber/Cucumber.html"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failedrerun.txt"},
		//tags = "@Dev",
		dryRun = false,
		publish = true,	
		monochrome = true)

//runner class to execute all scenarios 
public class TestRunnerCucumber extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
