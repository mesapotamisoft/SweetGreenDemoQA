package com.demo.loginpage;

import com.demo.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_URL = "https://order.sweetgreen.com/login";

    @FindBy(xpath = "//*[contains(@id,'ember') and @type='email']")
    private WebElement userNameInput;

    @FindBy(xpath = "//*[contains(@id,'ember') and @type='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath="//*[contains(@id,'ember') and @type='submit']")
    private WebElement submitButton;
    
    @FindBy(className="account-button")
    private WebElement accountButton;



    LoginPage() {
        PageFactory.initElements(driver, this);
    }

    void goToLoginPage(){
        driver.get(LOGIN_PAGE_URL);
        wait.forLoading(5);
    }

    void checkSubmitButtonDisplay() {
        wait.forElementToBeDisplayed(5, this.submitButton, "SubmitButton");
    }

    void checkUserNameDisplay() {
        wait.forElementToBeDisplayed(5, this.userNameInput, "UserName");
    }
    
    void checkPasswordDisplay() {
        wait.forElementToBeDisplayed(5, this.passwordInput, "Password");
    }

    void setLoginValues(String userName , String password) {
    	this.userNameInput.sendKeys(userName);
    	this.passwordInput.sendKeys(password);
    }
    
    void doLogin() {
    	this.submitButton.click();
    	/*try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	this.wait.forElementToBeDisplayed(5, this.accountButton, "AccountButton");
    }
}