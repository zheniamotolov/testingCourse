package com.lab.Tests;

import com.lab.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by eugene on 12/11/17.
 */
public class WrongLogInDataTest extends BaseTest{
    private LoginSteps loginSteps;
    private final String WRONG_EMAIL = "kek@gmail.com";
    private final String EMAIL = "zheniamotolov@gmail.com";
    private final String PASSWORD = "qwerty";
    private final String WRONG_PASSWORD = "1";
    private final String errorLoginMessage="We don’t have that email address in our system, please continue as a new customer or check the details above.";
private final String errorPasswordMessage="Failed to sign in, please check your details and try again";
    @BeforeMethod(description = "Init browser")
    public void setUp() {
        loginSteps = new LoginSteps();
        loginSteps.initBrowser();
    }
    @Test(description = "Login to EasyJet with wrong email")
    public void wrongEmailAddressCantLoginEasyJet() {
        loginSteps.loginEasyJet(WRONG_EMAIL, PASSWORD);
        Assert.assertTrue(loginSteps.isErrorLoginMessage(errorLoginMessage));
    }
    @Test(description = "Login to EasyJet with wrong password")
    public void wrongPasswordCantLoginEasyJet() {
        loginSteps.loginEasyJet(EMAIL, WRONG_PASSWORD);
        Assert.assertTrue(loginSteps.isErrorPasswordMessage(errorPasswordMessage));
    }
}
