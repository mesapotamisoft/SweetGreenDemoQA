package com.demo.loginpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {


    private LoginPage loginPage;

    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }

    @Given("A user navigates to LoginPage")
    public void a_user_navigates_to_LoginPage() {
        this.loginPage.goToLoginPage();
    }

    @Then("UserName input is displayed")
    public void username_input_is_displayed() {
        this.loginPage.checkUserNameDisplay();
    }

    @Then("Password input is displayed")
    public void password_input_is_displayed() {
        this.loginPage.checkPasswordDisplay();
    }

    @Then("Submit button is displayed")
    public void submit_button_is_displayed() {
        this.loginPage.checkSubmitButtonDisplay();
    }

    @Then("A user logins for {string} {string}")
    public void a_user_logins_for(String userName, String password) {
        this.loginPage.setLoginValues(userName, password);
    }
    
    @When("A user click to login button")
    public void a_user_click_to_login_button()
    {
    	this.loginPage.doLogin();
    }
    
    @Then("Account button is displayed")
    public void account_button_is_displayed()
    {
    	this.loginPage.doLogin();
    }

    
    
}