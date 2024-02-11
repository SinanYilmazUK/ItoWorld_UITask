@feature
Feature: Proceed to checkout

  Background:
    Given a demoBlaze home page is open

  Scenario: Add items to the cart
    Given the user selects a item
    When the user adds the item to the cart
    Then the item should be added to the cart

  Scenario: Remove item from the cart
    Given the user has items in the cart
    When the user removes an item from the cart
    Then the item should be removed from the cart

  Scenario: Proceed to checkout
    Given the user has items in the cart
    When the user proceeds to checkout
    Then a successful checkout confirmation should be displayed