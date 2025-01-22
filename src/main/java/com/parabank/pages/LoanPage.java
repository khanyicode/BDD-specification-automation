package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoanPage {
    private WebDriver driver;

    @FindBy(id = "amount")
    private WebElement loanAmountField;

    @FindBy(id = "downPayment")
    private WebElement downPaymentField;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Apply Now']")
    private WebElement applyButton;

    @FindBy(id = "loanStatus")
    private WebElement loanStatusElement;

    @FindBy(xpath = "//div[contains(@class, 'error')]")
    private WebElement errorMessageElement;

    public LoanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void applyForLoan(String loanAmount, String downPayment, String fromAccount) {
        loanAmountField.clear();
        loanAmountField.sendKeys(loanAmount);

        downPaymentField.clear();
        downPaymentField.sendKeys(downPayment);

        Select accountDropdown = new Select(fromAccountDropdown);
        accountDropdown.selectByVisibleText(fromAccount);

        applyButton.click();
    }

    public String getLoanStatus() {
        return loanStatusElement.getText();
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }

    public boolean isLoanApplicationSuccessful() {
        return loanStatusElement.isDisplayed() && 
               !getLoanStatus().toLowerCase().contains("denied");
    }

    public boolean isLoanDenied() {
        return getLoanStatus().toLowerCase().contains("denied");
    }
}
