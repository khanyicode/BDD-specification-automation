Feature: Customer Profile
  Scenario: Update Profile Information
    Given I am logged in
    When I navigate to "Update Profile"
    And I modify personal details
    And I click "Update"
    Then profile should be updated successfully

  Scenario: Change Account Settings
    Given I am logged in
    When I navigate to "Account Settings"
    And I modify notification preferences
    And I click "Save"
    Then settings should be saved
