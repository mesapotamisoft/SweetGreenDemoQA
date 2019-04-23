package com.demo.infrastructure.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

	private static final String CONTROL_READY_JAVASCRIPT = "return document.readyState=='complete';";
	private static final String DISPLAYED_TIMEOUT_MESSAGE_FORMAT = "%s wasn't displayed after %s seconds.";
	private static final String LOADING_TIMEOUT_MESSAGE_FORMAT = "Page didn't load after %s seconds.";
	private static final String LIST_DISPLAYED_TIMEOUT_MESSAGE_FORMAT  = "%s elements were not displayed after %s seconds.";


    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilCondition(ExpectedCondition<?> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(int timeout){
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue(CONTROL_READY_JAVASCRIPT);
        String timeoutMessage = String.format(LOADING_TIMEOUT_MESSAGE_FORMAT, Integer.toString(timeout));
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forElementToBeDisplayed(int timeout, WebElement webElement, String webElementName){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = String.format(DISPLAYED_TIMEOUT_MESSAGE_FORMAT, webElement,Integer.toString(timeout));
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void forPresenceOfElements(int timeout, By elementLocator, String elementName){
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = String.format(LIST_DISPLAYED_TIMEOUT_MESSAGE_FORMAT, elementName,Integer.toString(timeout));
        waitUntilCondition(condition, timeoutMessage, timeout);
    }
}
