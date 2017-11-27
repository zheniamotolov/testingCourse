package com.lab.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by eugene on 11/27/17.
 */
public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.easyjet.com/us";

    @FindBy(id = "signin-username")
    private WebElement inputLogin;

    @FindBy(id = "signin-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"signin-login\"]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id=\"pageWrapper\"]/header/div[1]/div[1]/nav[2]/ul/li[2]/span/a[2]/span[1]")
    private WebElement signInButton;
    @FindBy(id = "ContactDetailsLinkBreadcrumb")
    private WebElement showUserInformatinoButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void openSignInWindow() {
        signInButton.click();
    }

    public void login( String username, String password) {
        inputLogin.clear();
        inputLogin.sendKeys(username);
        if (inputLogin.getAttribute("value").equals(username)) {
            inputPassword.sendKeys(password);
            buttonSubmit.click();
            logger.info("Login performed");
        }
        else{
            login(username,password);
        }

    }

    public String getLoggedInEmailAddress() {
        logger.info("check for registration-" + showUserInformatinoButton.getText());

        return showUserInformatinoButton.getText();
    }

    public static void waitForTextToAppear(WebDriver newDriver, String textToAppear, WebElement element) {
        WebDriverWait wait = new WebDriverWait(newDriver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
    }
}
