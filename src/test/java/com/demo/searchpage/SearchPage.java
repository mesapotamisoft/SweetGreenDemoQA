package com.demo.searchpage;

import com.demo.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends BasePage{

    private static final String Search_PAGE_URL = "https://order.sweetgreen.com";

    @FindBy(xpath = "//*[contains(@id,'ember') and @type='email']")
    private WebElement userNameInput;

    @FindBy(xpath = "//*[contains(@id,'ember') and @type='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath="//*[contains(@id,'ember') and @type='submit']")
    private WebElement submitButton;
    
    @FindBy(className="account-button")
    private WebElement accountButton;



    SearchPage() {
        PageFactory.initElements(driver, this);
    }

    void goToSearchPage(){
        driver.get(Search_PAGE_URL);
        wait.forLoading(5);
    }
}