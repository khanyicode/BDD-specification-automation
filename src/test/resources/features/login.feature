Feature: Login Functionality
  Scenario: Successful login with valid credentials
    Given I am on the ParaBank homepage
    When I enter username "john" and password "demo"
    Then I should be logged in successfully


