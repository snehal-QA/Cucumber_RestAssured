Feature: Place Valications using API

Scenario: Validate if place are added when use Add place API
	Given we use Addplace payload with post request
	When user calls this "AddPlaceAPI"
	Then Response code 200 is returned
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
