package com.demo.searchpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchPageSteps {


    private SearchPage searchPage;

    public SearchPageSteps() {
        this.searchPage = new SearchPage();
    }
    
    
    @Given("A user navigates to SearchPage")
    public void a_user_navigates_to_SearchPage() {
    	this.searchPage.goToSearchPage();
    }

    @Then("SearchBox is displayed")
    public void searchbox_is_displayed() {
    	this.searchPage.checkSearchBoxDisplay();
    }

    @When("Send {string} key to get restaurants")
    public void send_key_to_get_restaurants(String searchFilter) {
    	this.searchPage.setSearchFilter(searchFilter);
    }

    @Then("SubmitButton is displayed")
    public void submitbutton_is_displayed() {
    	this.searchPage.checkSubmitButtonDisplay();
    }

    @When("A user click SubmitButton")
    public void a_user_click_SubmitButton() {
    	this.searchPage.search();
    }

    @Then("WarningMessage is displayed")
    public void warningmessage_is_displayed() {
    	this.searchPage.checkWarningMessageDisplay();
    }

    @Then("CountMessage is displayed")
    public void countmessage_is_displayed() {
    	this.searchPage.checkResultMessageDisplay();
    }
    
    @Then("Count in countMessage equals to listed restaurants count")
    public void count_in_countMessage_equals_to_listed_restaurants_count() {
    	this.searchPage.checkResultCountEqualsToListedItemsCount();
    }

    @Then("Listed restaurants count equals to map markers count on map")
    public void listed_restaurants_count_equals_to_map_markers_count_on_map() {
    	this.searchPage.checkMapMarkersCountEqualsToResultCount();
    }
    
}