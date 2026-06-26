package com.durvesh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.durvesh.utils.WaitUtils;
import com.durvesh.base.BasePage;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "submit")
    WebElement btnSubmit;

    public void login(String username, String password) {

        WaitUtils.waitForElementVisible(driver, txtUsername);

        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.click();

    }

    }

