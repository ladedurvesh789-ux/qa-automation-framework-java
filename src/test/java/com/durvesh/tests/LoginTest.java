package com.durvesh.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.durvesh.base.BaseTest;
import com.durvesh.pages.LoginPage;
import com.durvesh.utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Login Failed!");

        System.out.println("Login Successful");

    }

}