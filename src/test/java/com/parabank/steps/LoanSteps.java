package com.parabank.steps;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoanPage;
import com.parabank.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoanSteps extends BaseTest {
    private LoanPage loanPage;
    private LoginPage loginPage;

    @Given("I am logged in for loan application")
    public void i_am_logged_in_for_loan() {
        setUp();
        navigateToHomePage();
        loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");
    }

    @When("I apply for loan of {string} with down payment {string} from {string}")
    public void apply_for_loan(String loanAmount, String downPayment, String fromAccount) {
        loanPage = new LoanPage(driver);
        loanPage.applyForLoan(loanAmount, downPayment, fromAccount);
    }

    @Then("loan application status should be displayed")
    public void verify_loan_status() {
        String status = loanPage.getLoanStatus();
        Assert.assertNotNull("No loan status found", status);
        tearDown();
    }

    @Then("loan should be denied")
    public void verify_loan_denial() {
        String status = loanPage.getLoanStatus();
        Assert.assertTrue("Loan not denied", status.contains("Denied"));
        tearDown();
    }
}

