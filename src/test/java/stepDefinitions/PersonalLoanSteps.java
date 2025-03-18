package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonalLoanPage;

public class PersonalLoanSteps {
	
	WebDriver driver = Hooks.driver;
	PersonalLoanPage personalloanPage = new PersonalLoanPage(driver);

	@When("User enter the following Personal Loan details:")
	public void user_enter_the_following_personal_loan_details(DataTable dataTable) {
		personalloanPage.openPersonalLoanTab();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		int amount = Integer.parseInt(data.get(0).get("Loan Amount"));
		int interestRate = Integer.parseInt(data.get(0).get("Interest Rate"));
	    int tenure = Integer.parseInt(data.get(0).get("Loan Tenure"));
	    
	    personalloanPage.setLoanAmount(amount);
	    personalloanPage.setInterestRate(interestRate);
	    personalloanPage.setLoanTenure(tenure);
	}	
	@Then("User validates the Personal Loan EMI details displayed")
	public void user_validates_the_personal_loan_emi_details_displayed() {
		personalloanPage.getEmiAmount();
		personalloanPage.getTotalInterest();
		personalloanPage.getTotalPayment();
	}

}
