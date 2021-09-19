package com.whenIWork.step_definitions;

import com.whenIWork.pages.BasePage;
import com.whenIWork.pages.LoginPage;
import com.whenIWork.utilities.ConfigurationReader;
import com.whenIWork.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class LoginStepDef {
    private LoginPage loginPage = new LoginPage();
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    @When("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        wait.until(ExpectedConditions.urlContains("wheniwork"));
    }

    @When("user enters correct email and password")
    public void user_enters_correct_email_and_password() {
        loginPage.email.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("user clicks LogIn button")
    public void userClicksLogInButton() {
        loginPage.logInButton.click();
    }

    @Then("user logged in successfully")
    public void user_logged_in_successfully() {
        wait.until(ExpectedConditions.urlContains("appx"));
        assertTrue(Driver.getDriver().getCurrentUrl().contains("appx.wheniwork.com" ));
        BasePage basePage = new BasePage();
        assertTrue(basePage.dashboardPage.isDisplayed());
    }

    @And("user enters incorrect {string} or {string}")
    public void userEntersIncorrectOr(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }

    @And("user is on the same page")
    public void userIsOnTheSamePage() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorElement));
        assertTrue(Driver.getDriver().getCurrentUrl().contains("login.wheniwork.com"));
        assertTrue(loginPage.logInButton.isDisplayed());
    }

}
