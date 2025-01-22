package com.parabank.steps;

import com.parabank.pages.LoginPage;
import io.cucumber.java.en.*;
import com.parabank.base.BaseTest;

public class LoginSteps extends BaseTest {
    private LoginPage loginPage;

    @Given("I am on the ParaBank homepage")
    public void i_am_on_parabank_homepage() {
        setUp();
        navigateToHomePage();
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in() {
        // Add verification logic
        tearDown();
    }
}

