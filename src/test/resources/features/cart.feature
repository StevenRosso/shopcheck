@cart
Feature: Shopping cart

  Scenario: Adding items updates the count and total
    Given an empty cart
    When I add 1 "Laptop" priced at 999.99
    And I add 2 "Mouse" priced at 25.00
    Then the cart contains 3 items
    And the cart total is 1049.99
