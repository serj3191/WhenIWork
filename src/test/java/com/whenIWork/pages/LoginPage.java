package com.whenIWork.pages;

import com.whenIWork.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInButton;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement errorElement;

    }

