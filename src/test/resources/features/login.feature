Feature: ParaBank Login
  As a ParaBank customer
  I want to log in to my account
  So that I can access my banking services

  Scenario: Successful login with valid credentials
    Given I am on the ParaBank homepage
    When I enter username "john" and password "demo"
    Then I should be successfully logged in