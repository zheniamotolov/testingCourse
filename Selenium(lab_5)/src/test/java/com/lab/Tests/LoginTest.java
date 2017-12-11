package com.lab.Tests;

import com.lab.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginSteps loginSteps;
    private final String EMAIL = "zheniamotlov@gmail.com";
    private final String WRONG_EMAIL = "kek@gmail.com";
    private final String PASSWORD = "qwerty";
    private final String SIGN_OUT="Sign Out";
    private final String successfullySignInText = "Your account details";
    private final String errorLoginMessage="We don’t have that email address in our system, please continue as a new customer or check the details above.";
    @BeforeMethod(description = "Init browser")
    public void setUp() {
        loginSteps = new LoginSteps();
        loginSteps.initBrowser();
    }

    @Test(description = "Login to EasyJet")
    public void oneCanLoginEasyJet() {
        loginSteps.loginEasyJet(EMAIL, PASSWORD);
        Assert.assertTrue(loginSteps.isLoggedIn(successfullySignInText));
    }
    @Test(description = "Sign out from EasyJet")
    public void oneCanSignOutEasyJet() {
        Assert.assertTrue(loginSteps.isSignOut(SIGN_OUT));
    }


}
