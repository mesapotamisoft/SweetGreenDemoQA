Feature: Search Restaurants

  Scenario: Empty Result Search
    Given A user navigates to SearchPage
    Then SearchBox is displayed
    When Send "sadasd" key to get restaurants
	Then SubmitButton is displayed
	When A user click SubmitButton
	Then WarningMessage is displayed
	
	
  Scenario: Not Empty Result Search
  	Given A use navigates to SearchPage
  	Then SearchBox is displayed
  	When Send "Los Angeles" key to get restaurants
  	Then SubmitButton is displated
  	When A use click SubmitButton
  	Then CountMessage is displayed
  	And Count in CountMessage equals to listed restaurant's count
  	And Listed restaurant's count equals to map marker's count on map 
	