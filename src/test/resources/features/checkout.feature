@checkout
Feature:Checkout Your Information
  Scenario: User filled the field and continue
    Given User on inventory page
    When User click add to cart button
    And User move to cart page
    And User move to checkout your information page
    And User input first name
    And User input last name
    And User input postal code
    And User click continue button
    Then User on checkout overview page