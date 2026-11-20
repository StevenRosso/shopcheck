@delivery
Feature: Delivery charges

  Rule: Orders of 50.00 or more get free standard delivery

    Background:
      Given the shopper chooses standard delivery

    Scenario Outline: Standard delivery charge by basket value
      Given a basket with a subtotal of <subtotal>
      When the delivery charge is calculated
      Then the delivery charge is <charge>

      Examples: Typical baskets
        | subtotal | charge |
        | 20.00    | 4.00   |
        | 120.00   | 0.00   |

      @boundary
      Examples: Around the limit
        | subtotal | charge |
        | 49.99    | 4.00   |
        | 50.00    | 0.00   |
        | 50.01    | 0.00   |

  Rule: Express delivery always costs 9.00

    Scenario: Express delivery is charged even on a large basket
      Given the shopper chooses express delivery
      And a basket with a subtotal of 200.00
      When the delivery charge is calculated
      Then the delivery charge is 9.00
