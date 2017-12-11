package com.lab.Tests;

import com.lab.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by eugene on 12/11/17.
 */
public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public void init() {
    driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public static void shotDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
