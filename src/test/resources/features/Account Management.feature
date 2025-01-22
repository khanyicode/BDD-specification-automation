Feature: Account Management
  Scenario: Open New Bank Account
    Given I am logged in
    When I navigate to "Open New Account"
    And I select account type
    And I click "Open New Account"
    Then a new account should be created

  Scenario: Transfer Funds Between Accounts
    Given I am logged in
    When I navigate to "Transfer Funds"
    And I select source account
    And I select destination account
    And I enter transfer amount
    And I click "Transfer"
    Then funds should be transferred successfully

  Scenario: View Account Activity
    Given I am logged in
    When I select an account
    Then I should see transaction history
