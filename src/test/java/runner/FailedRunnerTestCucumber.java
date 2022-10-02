package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	   // path of step definition	
		glue = { "steps", "hooks" }, 	
		plugin = { "pretty","html:target/cucumber/failed/Cucumber.html"},
			monochrome =true,
			features = { "@target/failedrerun.txt" }
			
			)

	public class FailedRunnerTestCucumber extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
}