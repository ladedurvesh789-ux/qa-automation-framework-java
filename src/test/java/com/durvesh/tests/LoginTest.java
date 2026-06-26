package com.durvesh.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.durvesh.base.BaseTest;
import com.durvesh.dataprovider.TestDataProvider;
import com.durvesh.listeners.ExtentListener;
import com.durvesh.pages.LoginPage;

@Listeners(ExtentListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
          dataProviderClass = TestDataProvider.class)
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {

        LoginPage login = new LoginPage(driver);

        login.login(username, password);

        String actualUrl = driver.getCurrentUrl();

        boolean loginSuccess =
                actualUrl.contains("logged-in-successfully");

        if (expectedResult.equalsIgnoreCase("PASS")) {

            Assert.assertTrue(loginSuccess,
                    "Expected Login to PASS");

        } else {

            Assert.assertFalse(loginSuccess,
                    "Expected Login to FAIL");
        }
    }
}