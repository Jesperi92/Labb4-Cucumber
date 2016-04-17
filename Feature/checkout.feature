
Feature: checkout

Scenario: Put two products in cart
		Given User is on Home Page
		When User clicks on the AllProductsButton
		And adds "iPhone 5" to the cart
		And User clicks on the AllProductsButton
		And User clicks on "Magic Mouse"
		And add it to the cart
		Then "iPhone 5" and "Magic Mouse" are in the cart
		
Scenario: Remove a product from the cart
		Given User is on Home Page
		When User clicks on the AllProductsButton
		And adds "iPhone 5" to the cart
		Then "iPhone 5" are in the cart
		When User removes "iPhone 5" from the cart
		Then The cart is empty