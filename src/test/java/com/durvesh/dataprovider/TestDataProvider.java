package com.durvesh.dataprovider;

import org.testng.annotations.DataProvider;

import com.durvesh.utils.ExcelUtils;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelUtils.getTestData("Login");

    }

}