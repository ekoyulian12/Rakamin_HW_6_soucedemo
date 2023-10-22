@logout
Feature:Logout
  Scenario: User logout
    Given User on dashboard page
    When User click burger menu
    And User click Logout button
    Then User success logout