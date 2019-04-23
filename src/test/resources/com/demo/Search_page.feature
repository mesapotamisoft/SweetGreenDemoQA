Feature: Search Restaurants

  Scenario: Empty Result Search
    Given A user navigates to SearchPage
    Then SearchBox is displayed
    When Send "sadasd" key to get restaurants
	Then SubmitButton is displayed
	When A user click SubmitButton
	Then WarningMessage is displayed
	
	
  Scenario: Not Empty Result Search
  	Given A user navigates to SearchPage
  	Then SearchBox is displayed
  	When Send "Los Angeles" key to get restaurants
  	Then SubmitButton is displayed
  	When A user click SubmitButton
  	Then CountMessage is displayed
  	And Count in countMessage equals to listed restaurants count
  	And Listed restaurants count equals to map markers count on map 
	