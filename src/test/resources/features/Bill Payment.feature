Feature: Bill Payment
  Scenario: Pay Bill Successfully
    Given I am logged in
    When I navigate to "Bill Pay"
    And I enter payee details
    And I enter payment amount
    And I select account to pay from
    And I click "Send Payment"
    Then bill should be paid successfully

  Scenario: Pay Bill with Insufficient Funds
    Given I am logged in
    When I navigate to "Bill Pay"
    And I enter payee details
    And I enter payment amount exceeding account balance
    And I click "Send Payment"
    Then I should see an insufficient funds error
