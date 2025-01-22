package com.parabank.steps;

import com.parabank.base.BaseTest;
import com.parabank.pages.AccountPage;
import com.parabank.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class AccountSteps extends BaseTest {
    private AccountPage accountPage;
    private LoginPage loginPage;

    @Given("I am logged in")
    public void i_am_logged_in() {
        setUp();
        navigateToHomePage();
        loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");
    }

    @When("I open a new {string} account")
    public void open_new_account(String accountType) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccount(accountType);
    }

    @Then("a new account should be created")
    public void verify_new_account_created() {
        // Add verification logic
        Assert.assertTrue("New account not created", driver.getPageSource().contains("Account Opened"));
        tearDown();
    }

    @When("I transfer {string} from {string} to {string}")
    public void transfer_funds(String amount, String fromAccount, String toAccount) {
        accountPage = new AccountPage(driver);
        accountPage.transferFunds(fromAccount, toAccount, amount);
    }

    @Then("funds should be transferred successfully")
    public void verify_funds_transfer() {
        Assert.assertTrue("Transfer failed", driver.getPageSource().contains("Transfer Complete"));
        tearDown();
    }
}
