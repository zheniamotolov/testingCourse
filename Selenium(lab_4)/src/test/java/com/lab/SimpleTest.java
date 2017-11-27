package com.lab;

import com.lab.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by eugene on 11/27/17.
 */
public class SimpleTest {

    private Steps steps;
    private final String EMAIL = "zheniamotlov@gmail.com";
    private final String PASSWORD = "qwerty";
    private final String succseffullySignInText="Your account details";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Login to Github")
    public void oneCanLoginGithub()
    {
        steps.loginEasyJet(EMAIL, PASSWORD);

        Assert.assertTrue(steps.isLoggedIn(succseffullySignInText));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}

