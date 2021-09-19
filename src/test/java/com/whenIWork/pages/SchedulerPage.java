package com.whenIWork.pages;

import com.whenIWork.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulerPage {

    public SchedulerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='row no-gutters mt-2']")
    public WebElement addEmployeeButton;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "phone_number")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement inviteEmployeeButton;

    @FindBy(xpath = "//div[@class='text-truncate pl-2']")
    public List<WebElement> employees;

    public List<String> getEmployeesNames(List<WebElement> employees) {
        return employees.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement newEmployee(String fullName) {
        return Driver.getDriver().findElement(By.xpath("//div[.='" + fullName + "']"));
    }
}
