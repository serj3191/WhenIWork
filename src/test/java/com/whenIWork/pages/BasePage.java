package com.whenIWork.pages;

import com.whenIWork.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/']/span")
    public WebElement dashboardPage;

    @FindBy(xpath = "//a[@href='/scheduler']/span")
    public WebElement schedulerPage;

}
