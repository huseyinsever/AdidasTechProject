@ParallelTest
Feature: AdidasTech Project
  Scenario: AdidasTech Project
    Given Navigate to basqar
    When  Customer navigation through product categories: Phones, Laptops and Monitors
    And   Navigate to Laptop → SonyVaio-iEight and click on AddToCart Accept pop up confirmation.
    And   Navigate to Laptop → Dell-iSeven-Eightgb and click on AddToCart Accept pop up confirmation.
    And   Navigate to Cart → Delete Dell-iSeven-Eightgb from cart.
    And   Click on Place order
    And   Fill in all web form fields.
    And   Click on Purchase
    And   Capture and log purchase Id and Amount.
    And   Assert purchase amount equals expected.
    Then  Click on Ok