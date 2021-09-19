package com.whenIWork.step_definitions;

import com.github.javafaker.Faker;
import com.whenIWork.pages.BasePage;
import com.whenIWork.pages.SchedulerPage;
import com.whenIWork.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class AddEmployeeStepDef {
    SchedulerPage schedulerPage = new SchedulerPage();
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
    static String fullName;

    @When("user goes to Scheduler page")
    public void userGoesToSchedulerPage() {
        BasePage basePage = new BasePage();
        basePage.schedulerPage.click();
    }

    @And("user clicks Add Employees button")
    public void userClicksAddEmployeesButton() {
        wait.until(ExpectedConditions.visibilityOf(schedulerPage.addEmployeeButton));
        schedulerPage.addEmployeeButton.click();
    }

    @And("user fills out profile")
    public void userFillsOutProfile() {
        Faker faker = new Faker();
        fullName = faker.name().firstName() + " " + faker.name().lastName();
        schedulerPage.firstName.sendKeys(fullName.split("\\s+")[0]);
        schedulerPage.lastName.sendKeys(fullName.split("\\s+")[1]);
        schedulerPage.email.sendKeys(faker.internet().emailAddress());
        schedulerPage.phoneNumber.sendKeys("347" + faker.number().digits(7));
    }

    @And("user clicks Add and Invite Employee button")
    public void userClicksAddAndInviteEmployeeButton() {
        schedulerPage.inviteEmployeeButton.click();
    }

    @Then("new employee is added")
    public void newEmployeeIsAdded() {
        wait.until(ExpectedConditions.visibilityOf(schedulerPage.newEmployee(fullName)));
        assertTrue(schedulerPage.getEmployeesNames(schedulerPage.employees).contains(fullName));
    }
}
