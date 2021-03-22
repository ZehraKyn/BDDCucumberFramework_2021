package com.swaglabs.stepdefinitions;

import com.swaglabs.base.ConfigReader;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSD {

    @Given("I am on the login page")
    public void verifyTitle() {
        Assert.assertEquals("Swag Labs", LoginPage.verifyTitle());
    }

    @When("I enter correct username in the username field")
    public void enterValidUsername() {
        LoginPage.enterUserName(ConfigReader.getProperty("username"));

    }

    @And("I enter correct password in the password field")
    public void enterValidPassword() {
        LoginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("i click on the login button")
    public void clickOnLogin() {
        LoginPage.clickLoginBtn();

    }

    @Then("I see the home page")
    public void verifyHomePageTitle() {
        Assert.assertEquals("Swag Labs", HomePage.verifyTitle());

    }

    @When("I enter incorrect username in the username field")
    public void enterInvalidUserName() {
        LoginPage.enterUserName(ConfigReader.getProperty("invalidusername"));
    }

    @And("I enter incorrect password in the password field")
    public void enterInvalidPassword() {
        LoginPage.enterPassword(ConfigReader.getProperty("invalidpassword"));
    }

    @Then("I see the error message on the login page")
    public void verifyErrorMessage() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",LoginPage.getErrorMessage());
    }
}