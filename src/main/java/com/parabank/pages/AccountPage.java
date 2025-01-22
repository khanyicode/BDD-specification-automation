package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
    private WebDriver driver;

    @FindBy(id = "newAccountType")
    private WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(id = "toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(id = "amount")
    private WebElement transferAmountField;

    @FindBy(xpath = "//input[@value='Transfer']")
    private WebElement transferButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openNewAccount(String accountType) {
        Select dropdown = new Select(accountTypeDropdown);
        dropdown.selectByVisibleText(accountType);
    }

    public void transferFunds(String fromAccount, String toAccount, String amount) {
        Select fromDropdown = new Select(fromAccountDropdown);
        fromDropdown.selectByVisibleText(fromAccount);

        Select toDropdown = new Select(toAccountDropdown);
        toDropdown.selectByVisibleText(toAccount);

        transferAmountField.sendKeys(amount);
        transferButton.click();
    }
}
