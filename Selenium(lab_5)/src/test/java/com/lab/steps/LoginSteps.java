package com.lab.steps;

import com.lab.driver.DriverSingleton;
import com.lab.pages.FligtsSearchResaultPage;
import com.lab.pages.MainPage;
import com.lab.pages.PostLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by eugene on 11/27/17.
 */
public class LoginSteps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void visitPage(String url) {
        driver.get(url);
    }

    public void loginEasyJet(String username, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.openSignInWindow();
        mainPage.login(username, password);
    }

    public boolean isLoggedIn(String successfullySignInText) {
        PostLoginPage postLoginPage = new PostLoginPage(driver);
        return (postLoginPage.getLoggedInEmailAddress().equals(successfullySignInText));
    }

    public boolean isErrorLoginMessage(String errorLoginMessage) {
        MainPage mainPage = new MainPage(driver);
        return (mainPage.getLoginErrorMessage().equals(errorLoginMessage));
    }

    public boolean isSignOut(String signOut) {
        PostLoginPage postLoginPage = new PostLoginPage(driver);
        return (postLoginPage.getSignOutOption().equals(signOut));
    }

    public boolean isErrorPasswordMessage(String errorPasswordMessage) {
        MainPage mainPage = new MainPage(driver);
        return (mainPage.getPasswordErrorMessage().equals(errorPasswordMessage));
    }


}
