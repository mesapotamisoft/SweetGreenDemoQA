package com.demo.loginpage;

import com.demo.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_URL = "https://order.sweetgreen.com/login";
    
    private static final String USER_NAME_SELECTOR = "//*[contains(@id,'ember') and @type='email']";
    private static final String PASSWORD_SELECTOR = "//*[contains(@id,'ember') and @type='password']";
    private static final String SUBMIT_BUTTON_SELECTOR = "//*[contains(@id,'ember') and @type='submit']";
    private static final String ACCOUNT_BUTTON_SELECTOR = "//*[contains(@class,'account-button')]";
    
    private static final String USER_NAME_ELEMENT_NAME = "UserName";
    private static final String PASSWORD_ELEMENT_NAME = "Password";
    private static final String SUBMIT_BUTTON_ELEMENT_NAME = "SubmitButton";
    private static final String ACCOUNT_BUTTON_ELEMENT_NAME = "AccountButton";


    @FindBy(xpath = USER_NAME_SELECTOR)
    private WebElement userNameInput;

    @FindBy(xpath = PASSWORD_SELECTOR)
    private WebElement passwordInput;
    
    @FindBy(xpath=SUBMIT_BUTTON_SELECTOR)
    private WebElement submitButton;
    
    @FindBy(className=ACCOUNT_BUTTON_SELECTOR)
    private WebElement accountButton;

    LoginPage() {
        PageFactory.initElements(driver, this);
    }

    void goToLoginPage(){
        driver.get(LOGIN_PAGE_URL);
        wait.forLoading(5);
    }

    void checkSubmitButtonDisplay() {
        wait.forElementToBeDisplayed(5, this.submitButton, SUBMIT_BUTTON_ELEMENT_NAME);
    }

    void checkUserNameDisplay() {
        wait.forElementToBeDisplayed(5, this.userNameInput, USER_NAME_ELEMENT_NAME);
    }
    
    void checkPasswordDisplay() {
        wait.forElementToBeDisplayed(5, this.passwordInput, PASSWORD_ELEMENT_NAME);
    }

    void setLoginValues(String userName , String password) {
    	this.userNameInput.sendKeys(userName);
    	this.passwordInput.sendKeys(password);
    }
    
    void doLogin() {
    	this.submitButton.click();
    	this.wait.forElementToBeDisplayed(5, this.accountButton, ACCOUNT_BUTTON_ELEMENT_NAME);
    }
}