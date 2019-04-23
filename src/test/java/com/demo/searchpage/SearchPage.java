package com.demo.searchpage;

import com.demo.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SearchPage extends BasePage {

	private static final String SEARCH_PAGE_URL = "https://order.sweetgreen.com";
	private static final String EMPTY_RESULT_WARNING_MESSAGE = "We couldn't find any sweetgreens in your area.";
	private static final String EMPTY_RESULT_TEST_FAIL_MESSAGE = "Empty result message wasn't displayed";
	private static final String RESULT_MESSAGE_FORMAT = "There are %d sweetgreens nearby.";
	private static final String RESULT_MESSAGE_TEST_FAIL_MESSAGE = "Result message wasn't displayed";
	private static final String LISTED_ITEMS_COUNT_TEST_FAIL_MESSAGE = "Listed items weren't displayed";
	private static final String MAP_MARKERS_COUNT_TEST_FAIL_MESSAGE = "Map markers weren't displayed";


	private static final String SEARCH_BOX_SELECTOR = "//*[contains(@name,'search')]";
	private static final String SUBMIT_BUTTON_SELECTOR = "locator-submit";
	private static final String SEARCH_RESULT_MESSAGE_SELECTOR = "//*[@id='zip-search-info']/p";
	private static final String LISTED_ITEMS_SELECTOR = "card-content";
	private static final String MAP_MARKERS_SELECTOR = "//*[@class='ember-view google-map']/div/div/div/div[1]/div[3]/div/div[3]/div";

	private static final String SEARCH_BOX_ELEMENT_NAME = "SearchBox";
	private static final String SUBMIT_BUTTON_ELEMENT_NAME = "SubmitButton";

	@FindBy(xpath = SEARCH_BOX_SELECTOR)
	private WebElement searchBoxInput;

	@FindBy(className = SUBMIT_BUTTON_SELECTOR)
	private WebElement submitButton;

	@FindBy(xpath = SEARCH_RESULT_MESSAGE_SELECTOR)
	private WebElement searchResultMessage;

	SearchPage() {
		PageFactory.initElements(driver, this);
	}

	void goToSearchPage() {
		driver.get(SEARCH_PAGE_URL);
		wait.forLoading(5);
	}

	void checkSearchBoxDisplay() {
		wait.forElementToBeDisplayed(5, searchBoxInput, SEARCH_BOX_ELEMENT_NAME);
	}

	void setSearchFilter(String searchFilter) {
		this.searchBoxInput.sendKeys(searchFilter);
	}

	void checkSubmitButtonDisplay() {
		wait.forElementToBeDisplayed(5, submitButton, SUBMIT_BUTTON_ELEMENT_NAME);
	}

	void search() {
		this.submitButton.click();
	}

	void checkWarningMessageDisplay() {
		ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> this.searchResultMessage.getText()
				.equals(EMPTY_RESULT_WARNING_MESSAGE);

		this.wait.waitUntilCondition(elementTextEqualsString, EMPTY_RESULT_TEST_FAIL_MESSAGE, 5);
	}

	void checkResultMessageDisplay() {

		ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> {
			int countInMessage = getCountInMessage(false);

			String messageContent = this.searchResultMessage.getText();

			String expectedMessage = String.format(RESULT_MESSAGE_FORMAT, countInMessage);

			return messageContent.equals(expectedMessage);
		};

		this.wait.waitUntilCondition(elementTextEqualsString, RESULT_MESSAGE_TEST_FAIL_MESSAGE, 5);
	}

	void checkResultCountEqualsToListedItemsCount() {

		ExpectedCondition<Boolean> controlListedItems = arg0 -> {
			int countInMessage = getCountInMessage(true);
			int listedItemCount = driver.findElements(By.className(LISTED_ITEMS_SELECTOR)).size();
			return countInMessage > 0 && countInMessage == listedItemCount;
		};

		this.wait.waitUntilCondition(controlListedItems, LISTED_ITEMS_COUNT_TEST_FAIL_MESSAGE, 5);
	}

	void checkMapMarkersCountEqualsToResultCount() {

		ExpectedCondition<Boolean> mapMarkersControl = arg0 -> {
			int countInMessage = getCountInMessage(true);
			int mapMarkersCount = driver.findElements(By.xpath(MAP_MARKERS_SELECTOR)).size();
			return countInMessage > 0 && countInMessage == mapMarkersCount;
		};

		this.wait.waitUntilCondition(mapMarkersControl, MAP_MARKERS_COUNT_TEST_FAIL_MESSAGE, 5);
	}

	private int getCountInMessage(Boolean assertionEnabled) {
		String messageContent = this.searchResultMessage.getText();

		int count = getFirstIntegerInString(messageContent);
		if (assertionEnabled)
			Assert.assertEquals(true, count > 0);

		return count;

	}

}