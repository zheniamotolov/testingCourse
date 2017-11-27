package com.lab.steps;

import com.lab.driver.DriverSingleton;
import com.lab.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by eugene on 11/27/17.
 */
public class Steps {
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
    public void loginEasyJet(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.openSignInWindow();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String successfullySignInText)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInEmailAddress().equals(successfullySignInText));
    }

}
