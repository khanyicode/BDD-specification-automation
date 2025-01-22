Feature: Loan Application
  Scenario: Apply for Loan
    Given I am logged in
    When I navigate to "Request Loan"
    And I enter loan amount
    And I enter down payment
    And I select account
    And I click "Apply Now"
    Then loan application status should be displayed

  Scenario: Loan Application Denied
    Given I am logged in
    When I apply for loan with high risk profile
    Then loan should be denied
