package com.lab.Tests;

import com.lab.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by eugene on 12/11/17.
 */
public class WrongLoginInputTest extends BaseTest{
    private LoginSteps loginSteps;
    private final String WRONG_EMAIL = "kek@gmail.com";
    private final String PASSWORD = "qwerty";
    private final String errorLoginMessage="We don’t have that email address in our system, please continue as a new customer or check the details above.";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        loginSteps = new LoginSteps();
        loginSteps.initBrowser();
    }
    @Test(description = "Login to EasyJet with wrong email")
    public void wrongEmalAddressCantLoginEasyJet() {
        loginSteps.loginEasyJet(WRONG_EMAIL, PASSWORD);
        Assert.assertTrue(loginSteps.isErrorLoginMessage(errorLoginMessage));
    }
}
