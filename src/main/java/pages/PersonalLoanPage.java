package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PersonalLoanPage {

	WebDriver driver;

	By personalLoanTab = By.id("personal-loan");
	By loanAmountSlider = By.id("loanamountslider");
	By interestRateSlider = By.id("loaninterestslider");
	By loanTenureSlider = By.id("loantermslider");
    By emiResult = By.id("emiamount");
    By totalInterest = By.id("emitotalinterest");
    By totalPayment = By.id("emitotalamount");

    public void openPersonalLoanTab() {
		driver.findElement(personalLoanTab).click();
	}
    
    public PersonalLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLoanAmount(int amount) {
        WebElement slider = driver.findElement(loanAmountSlider);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, amount / 100000, 0).perform();
    }

    public void setInterestRate(int rate) {
        WebElement slider = driver.findElement(interestRateSlider);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, rate, 0).perform();
    }

    public void setLoanTenure(int tenure) {
        WebElement slider = driver.findElement(loanTenureSlider);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, tenure, 0).perform();
    }

    public String getEmiAmount() {
        return driver.findElement(emiResult).getText();
    }

    public String getTotalInterest() {
        return driver.findElement(totalInterest).getText();
    }

    public String getTotalPayment() {
        return driver.findElement(totalPayment).getText();
    }
}
