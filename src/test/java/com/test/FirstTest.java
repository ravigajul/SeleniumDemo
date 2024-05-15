package com.test;

import org.testng.annotations.Test;

import com.test.constants.MyConstants;
import com.test.pom.base.BaseTest;

public class FirstTest extends BaseTest{
    
    @Test
    public void LaunchBrowser() {
       driver.get(MyConstants.URL);
    }
}
