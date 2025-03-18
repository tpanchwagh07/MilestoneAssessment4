package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarLoanPage;

public class CarLoanSteps {
	
	WebDriver driver = Hooks.driver;
	CarLoanPage carloanPage = new CarLoanPage(driver);

	@When("User enter the following Car Loan details:")
	public void user_enter_the_following_car_loan_details(DataTable dataTable) {
		carloanPage.openCarLoanTab();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		int amount = Integer.parseInt(data.get(0).get("Loan Amount"));
		int interestRate = Integer.parseInt(data.get(0).get("Interest Rate"));
	    int tenure = Integer.parseInt(data.get(0).get("Loan Tenure"));
	    
	    carloanPage.setLoanAmount(amount);;
	    carloanPage.setInterestRate(interestRate);
	    carloanPage.setLoanTenure(tenure);
	}
	@Then("User validates the Car Loan EMI details displayed")
	public void user_validates_the_car_loan_emi_details_displayed() {
		carloanPage.getEmiAmount();
		carloanPage.getTotalInterest();
		carloanPage.getTotalPayment();
	}

}
