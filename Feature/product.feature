
Feature: product

Scenario: Go to product
		Given User is on Home Page
		When User hower over Products button and then clicks on "Accessories"
		And User clicks on "Magic Mouse"
		Then User is on "Magic Mouse" product page
		
Scenario: Go to also bought product
		Given User is on Home Page
		When User Navigate to A Random Product
		And Clicks on a AlsoBought product
		Then User is on that AlsoBought products page
		
Scenario: Rate product
		Given User is on Home Page
		When User Navigate to A Random Product
		And rate that product with 1
		Then a message should pop up