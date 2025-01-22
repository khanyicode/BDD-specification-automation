package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillPayPage {
    private WebDriver driver;

    @FindBy(name = "payee.name")
    private WebElement payeeNameField;

    @FindBy(name = "payee.address.street")
    private WebElement payeeAddressField;

    @FindBy(name = "payee.city")
    private WebElement payeeCityField;

    @FindBy(name = "payee.state")
    private WebElement payeeStateField;

    @FindBy(name = "payee.zipCode")
    private WebElement payeeZipCodeField;

    @FindBy(name = "payee.phoneNumber")
    private WebElement payeePhoneField;

    @FindBy(name = "payee.accountNumber")
    private WebElement payeeAccountNumberField;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccountField;

    @FindBy(name = "amount")
    private WebElement billAmountField;

    @FindBy(name = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Send Payment']")
    private WebElement sendPaymentButton;

    @FindBy(xpath = "//div[contains(@class, 'error')]")
    private WebElement errorMessageElement;

    @FindBy(xpath = "//div[contains(text(), 'Bill Payment Complete')]")
    private WebElement successMessageElement;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void payBill(String payeeName, String address, String amount, String fromAccount) {
        // Basic bill payment
        payeeNameField.sendKeys(payeeName);
        payeeAddressField.sendKeys(address);
        billAmountField.sendKeys(amount);

        Select accountDropdown = new Select(fromAccountDropdown);
        accountDropdown.selectByVisibleText(fromAccount);

        sendPaymentButton.click();
    }

    public void payBillWithFullDetails(
        String payeeName, String address, String city, 
        String state, String zipCode, String phone, 
        String accountNumber, String amount, String fromAccount) {
        
        payeeNameField.sendKeys(payeeName);
        payeeAddressField.sendKeys(address);
        payeeCityField.sendKeys(city);
        payeeStateField.sendKeys(state);
        payeeZipCodeField.sendKeys(zipCode);
        payeePhoneField.sendKeys(phone);
        payeeAccountNumberField.sendKeys(accountNumber);
        verifyAccountField.sendKeys(accountNumber);
        billAmountField.sendKeys(amount);

        Select accountDropdown = new Select(fromAccountDropdown);
        accountDropdown.selectByVisibleText(fromAccount);

        sendPaymentButton.click();
    }

    public boolean isBillPaymentSuccessful() {
        return successMessageElement.isDisplayed();
    }

    public boolean hasInsufficientFundsError() {
        return errorMessageElement.getText().contains("Insufficient Funds");
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }
}

