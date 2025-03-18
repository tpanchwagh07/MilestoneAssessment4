Feature: EMI Calculator Testing

  Background: 
    Given User is on the EMI Calculator homepage

  @HomeLoan
  Scenario: Calculate Home Loan EMI
    When User enters the following Home Loan details:
      | Loan Amount | Interest Rate | Loan Tenure |
      | 5000000     | 10            | 20          |
    Then User validates the Home Loan EMI details displayed

  @PersonalLoan
  Scenario: Calculate Personal Loan EMI
    When User enter the following Personal Loan details:
      | Loan Amount | Interest Rate | Loan Tenure |
      | 750000      | 15            | 5           |
    Then User validates the Personal Loan EMI details displayed

  @CarLoan
  Scenario: Calculate Car Loan EMI
    When User enter the following Car Loan details:
      | Loan Amount | Interest Rate | Loan Tenure |
      | 2000000     | 9             | 6           |
    Then User validates the Car Loan EMI details displayed
