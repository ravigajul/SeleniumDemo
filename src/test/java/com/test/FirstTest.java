package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.constants.MyConstants;
import com.test.pom.base.BaseTest;
import com.test.pom.pages.HomePage;
import com.test.pom.pages.StorePage;

public class FirstTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() {
        driver.get(MyConstants.URL);
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        // builder pattern enterSearchText returns the object of the same class
        // storePage.enterSearchText(null, "blue").clickSearchButton()

        // functional page object pattern
        storePage.search("blue");
        Assert.assertEquals(storePage.getSearchTitle(), "Search results: “blue”");
        storePage.clickAddToCart("Blue Shoes");
        storePage.clickViewCart();

    }
}
