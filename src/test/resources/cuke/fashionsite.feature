Feature: To select a dress on the fashion website

	Scenario: To navigate and find dresses on the fashionsite
	Given that I can access the fashionsite
	When I navigate to the search bar
	And I search for the word dress
	Then I should find some results for dress
