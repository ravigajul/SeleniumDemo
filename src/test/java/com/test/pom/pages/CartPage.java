package com.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;

public class CartPage extends BasePage {
    private final By productName = By.xpath("//a[text()='Blue Shoes']");
    private final By checkOutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public CheckOutPage checkOut() {
        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
}
