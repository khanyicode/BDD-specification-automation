package com.parabank.steps;

import com.parabank.base.BaseTest;
import com.parabank.pages.BillPayPage;
import com.parabank.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class BillPaySteps extends BaseTest {
    private BillPayPage billPayPage;
    private LoginPage loginPage;

    @Given("I am logged in for bill payment")
    public void i_am_logged_in_for_bill_payment() {
        setUp();
        navigateToHomePage();
        loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");
    }

    @When("I pay bill to {string} at {string} for {string} from {string}")
    public void pay_bill(String payeeName, String address, String amount, String fromAccount) {
        billPayPage = new BillPayPage(driver);
        billPayPage.payBill(payeeName, address, amount, fromAccount);
    }

    @Then("bill payment should be successful")
    public void verify_bill_payment() {
        Assert.assertTrue("Bill payment failed", driver.getPageSource().contains("Bill Payment Complete"));
        tearDown();
    }

    @Then("I should see insufficient funds error")
    public void verify_insufficient_funds() {
        Assert.assertTrue("No insufficient funds error", driver.getPageSource().contains("Insufficient Funds"));
        tearDown();
    }
}

