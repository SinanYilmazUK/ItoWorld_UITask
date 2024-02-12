@homepage @feature
Feature: Home page related scenarios

  Scenario: Checking right list of product(Sample)
    Given a demoBlaze home page is open
    When the user select the 'Monitors' category
    Then the list of product should be displayed as below:
      | Apple monitor 24 |
      | ASUS Full HD     |