#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Place an order from E-com Website
  I want to use this template for my feature file
  
  Background:
  Given User already landed on E-commerce page

  @tag1
  Scenario: Positive test of submitting order
    Given Logged in with username <name> and password <password>
    When I add product to the cart
    |IPHONE 13 PRO|
    And Checkout the product
    |IPHONE 13 PRO|
    Then Validate if the "Order : " is printed


    Examples: 
      | name  | password |
      |tikori@gmail.com|Tikori69$|
      
