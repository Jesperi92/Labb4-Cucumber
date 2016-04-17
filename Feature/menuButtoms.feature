		
Feature: menuButtoms
		
Scenario: HomeButtons works
		Given User is on Home Page
		When User Navigate to A Random Product
		And User Clicks on The MenuHomeButton
		Then The user is on the HomePage
		When User Navigate to A Random Product
		And User Clicks on The LogoHomeButton
		Then The user is on the HomePage
		When User Navigate to A Random Product
		And User Clicks on The BottomHomeButton
		Then The user is on the HomePage
		
Scenario: SampleButton works
		Given User is on Home Page
		When User Clicks on the SampleButton
		Then The user is on the SamplePage
		
Scenario: CategoriesButtons works
		Given User is on Home Page
		When User clicks on the AllProductsButton
		Then User is on a new page with the title "Product Category"
		When User hower over Products button and then clicks on "Accessories"
		Then User is on a new page with the title "Accessories"
		When User hower over Products button and then clicks on "iMacs"
		Then User is on a new page with the title "iMacs"
		When User hower over Products button and then clicks on "iPads"
		Then User is on a new page with the title "iPads"
		When User hower over Products button and then clicks on "iPhones"
		Then User is on a new page with the title "iPhones"
		When User hower over Products button and then clicks on "iPods"
		Then User is on a new page with the title "iPods"
		When User hower over Products button and then clicks on "MacBooks"
		Then User is on a new page with the title "MacBooks"
		
Scenario: GoToMyAccountButtons works
		Given User is on Home Page
		When User clicks on the upper MyAccountButton
		Then User is on the MyAccountPage
		And User Clicks on The LogoHomeButton
		Then The user is on the HomePage
		When User clicks on the bottom MyAccountButton
		Then User is on the MyAccountPage 
		
Scenario: Search no match
		Given User is on Home Page
		When User Search on "aaaaaaa"
		Then There is no match on the search
		
Scenario: Search match
		Given User is on Home Page
		When User Search on "magic mouse"
		Then There is a match on the search "magic mouse"