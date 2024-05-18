package com.test.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By txtProductSearch = By.cssSelector("input#woocommerce-product-search-field-0");
    // ~ is the sibling selector in css
    private final By btnSearch = By.cssSelector("input#woocommerce-product-search-field-0~button");
    private final By searchTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("[data-toggle-type] [title]");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterSearchText(String searchText) {

        driver.findElement(txtProductSearch).sendKeys(searchText);
        // builder pattern return the object of the same class this action returns
        return this;
    }

    public StorePage clickSearchButton() {
        driver.findElement(btnSearch).click();
        return this;
    }

    public String getSearchTitle() {
        return driver.findElement(searchTitle).getText();
    }

    private By getAddToCartButton(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartBtn(String productName) {
        By btnAddToCart = getAddToCartButton(productName);
        driver.findElement(btnAddToCart).click();
        return this;
    }

    public StorePage search(String text) {
        enterSearchText(text);
        clickSearchButton();
        return this;
    }

    public CartPage clickViewCart() {
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

}
