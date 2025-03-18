package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;

public class CommonSteps {
	
	WebDriver driver = Hooks.driver;

	@Given("User is on the EMI Calculator homepage")
	public void user_is_on_the_emi_calculator_homepage() {
		driver.get("https://emicalculator.net/");
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
