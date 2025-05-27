
@tag
Feature: Purchase Order from Ecommerce website
  I want to use this template for my feature file
 
 
  Background: 
  Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <name> and password <password>
    When I added product <productName> to cart 
    And Checkout <productName> and submit the order
    Then message is displayed on ConfirmationPage

    Examples: 
      | name                | password     | productName  |
      | opawar449@gmail.com | Omkar@1234   | ZARA COAT 3  |

