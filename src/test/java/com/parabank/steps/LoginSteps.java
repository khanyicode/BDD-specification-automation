package com.parabank.steps;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends BaseTest {
    
    private LoginPage loginPage;
    
    @Before
    public void setup() {
        setUp(); // From BaseTest
        loginPage = new LoginPage(driver);
    }
    
    @Given("I am on the ParaBank homepage")
    public void i_am_on_the_parabank_homepage() {
        navigateToHomePage();
        // Verify we're on the login page
        WebElement loginPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#leftPanel")));
        assertTrue(loginPanel.isDisplayed(), "Login panel should be visible");
    }
    
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        // Find and fill in username field
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.clear();
        usernameField.sendKeys(username);
        
        // Find and fill in password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        
        // Click login button
        WebElement loginButton = driver.findElement(By.cssSelector("input.button[value='Log In']"));
        loginButton.click();
    }
    
    @Then("I should be successfully logged in")
    public void i_should_be_successfully_logged_in() {
        // Wait for and verify the accounts overview page is displayed
        WebElement accountsOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#rightPanel h1")));
        assertTrue(accountsOverview.getText().contains("Accounts Overview"), 
            "Should show Accounts Overview page after login");
        
        // Verify welcome message
        WebElement welcomeMessage = driver.findElement(By.cssSelector("#leftPanel .smallText"));
        assertTrue(welcomeMessage.getText().contains("Welcome"), 
            "Welcome message should be displayed");
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".error")));
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
    }
    
    @After
    public void cleanup() {
        tearDown();
    }
}