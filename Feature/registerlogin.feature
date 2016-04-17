
Feature: registerlogin

Scenario: Go to register page
		Given User is on Home Page
		When User clicks on the upper MyAccountButton
		And navigates to the register page
		Then User is on the register page
		
Scenario: Invalid login
		Given User is on Home Page
		When User clicks on the upper MyAccountButton
		And navigates to the login page
		And enter username: "aaaaaaa" and password: "aaaaaaa"
		Then a invalid login message appears