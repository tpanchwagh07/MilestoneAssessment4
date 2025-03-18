package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomeLoanPage;

public class HomeLoanSteps {
	
	WebDriver driver = Hooks.driver;
	HomeLoanPage homeloanPage = new HomeLoanPage(driver);

	@When("User enters the following Home Loan details:")
	public void user_enters_the_following_home_loan_details(DataTable dataTable) {
		homeloanPage.openHomeLoanTab();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		int amount = Integer.parseInt(data.get(0).get("Loan Amount"));
		int interestRate = Integer.parseInt(data.get(0).get("Interest Rate"));
	    int tenure = Integer.parseInt(data.get(0).get("Loan Tenure"));
	    
	    homeloanPage.setLoanAmount(amount);
	    homeloanPage.setInterestRate(interestRate);
	    homeloanPage.setLoanTenure(tenure);
	    
	}
	@Then("User validates the Home Loan EMI details displayed")
	public void user_validates_the_home_loan_emi_details_displayed() {
		homeloanPage.getEmiAmount();
		homeloanPage.getTotalInterest();
		homeloanPage.getTotalPayment();
	}

}
