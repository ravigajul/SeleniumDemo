package com.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;


public class HomePage extends BasePage {
    private final By storeMenuLink = By.xpath("//li[@id='menu-item-1227']/a");
    //constructor
    public HomePage(WebDriver driver)  {
        super(driver);
    }
    public StorePage clickStoreMenuLink() {
        driver.findElement(storeMenuLink).click();

        //fluent interface return the object of the new class this action returns
        return new StorePage(driver);
    }
}
