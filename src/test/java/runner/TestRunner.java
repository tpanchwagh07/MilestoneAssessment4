package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepDefinitions",
		plugin = {"pretty", "html:target/cucumber-reports-html/cucumber.html", "json:target/cucumber-reports-json/cucumber.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
