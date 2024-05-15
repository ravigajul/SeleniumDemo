package com.test.pom.pages;

import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;


public class HomePage extends BasePage {
    //constructor
    public HomePage(WebDriver driver)  {
        super(driver);
        
    }
    public void goToHomePage() {
        driver.get("https://www.google.com");
    }
}
