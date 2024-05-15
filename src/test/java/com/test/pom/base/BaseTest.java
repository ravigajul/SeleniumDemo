package com.test.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.test.constants.MyConstants;
import com.test.pom.factory.DriverManager;

public class BaseTest {
    protected  WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        driver = new DriverManager().initializeDriver(MyConstants.BROWSER);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
        driver.quit();
    }
}
