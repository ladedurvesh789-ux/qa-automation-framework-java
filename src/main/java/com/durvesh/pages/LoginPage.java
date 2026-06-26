package com.durvesh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.durvesh.utils.WaitUtils;
import com.durvesh.base.BasePage;

public class LoginPage extends BasePage {
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
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

        logger.info("Waiting for Username field");

        WaitUtils.waitForElementVisible(driver, txtUsername);

        logger.info("Entering Username");
        txtUsername.sendKeys(username);

        logger.info("Entering Password");
        txtPassword.sendKeys(password);

        logger.info("Clicking Login button");
        btnSubmit.click();

        logger.info("Login button clicked");
    }

    }

