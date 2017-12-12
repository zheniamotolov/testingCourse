package com.lab.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by eugene on 11/27/17.
 */
public class MainPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.easyjet.com/us";
    @FindBy(className = "message-summary")
    private WebElement wrongAmountOfPassengersMessage;
    @FindBy(className = "quantity-button-remove")
    private WebElement decrementAmountOfPeopleButton;
    @FindBy(className = "incorrectemail-errormessage")
    private WebElement loginErrorMessage;
    @FindBy(className = "incorrectpassword-errormessage")
    private WebElement passwordErrorMessage;

    @FindBy(id = "signin-username")
    private WebElement inputLogin;

    @FindBy(id = "signin-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"signin-login\"]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id=\"pageWrapper\"]/header/div[1]/div[1]/nav[2]/ul/li[2]/span/a[2]/span[1]")
    private WebElement signInButton;
    @FindBy(css = "form[name='searchPodForm']")
    private WebElement searchForm;
    @FindBy(css = "input[name='origin']")
    private WebElement from;
    @FindBy(xpath = "//*[@id=\"pageWrapper\"]/main/div/div[1]/section/div[1]/div/div/ul/li[1]/div/div/form/div[1]/div[1]/label/span[1]/span")
    private WebElement oneWayButton;
    @FindBy(css = "input[name='destination']")
    private WebElement destination;
    @FindBy(className = "button-reset")
    private WebElement departingButton;

    @FindBy(xpath = "//*[@id=\"drawer-dialog\"]/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div/div[25]")
    private WebElement departingDate;


    @FindBy(xpath = "//*[@id=\"close-drawer-link\"]")
    private WebElement closeCalendarButton;

    @FindBy(xpath = "//*[@id=\"pageWrapper\"]/main/div/div[1]/section/div[1]/div/div/ul/li[1]/div/div/form/button[1]")
    private WebElement showResaultFlightsButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
    }

    public void openSignInWindow() {
        signInButton.click();
    }

    public void login(String username, String password) {
        inputLogin.clear();
        inputLogin.sendKeys(username);
        if (inputLogin.getAttribute("value").equals(username)) {
            inputPassword.clear();
            inputPassword.sendKeys(password);
            buttonSubmit.click();
            logger.info("Login performed");
        } else {
            login(username, password);
        }

    }

    public void fillSearchForm(String fromCity, String toCity) {
        oneWayButton.click();
        from.clear();
        from.sendKeys(fromCity);
        destination.clear();
        destination.sendKeys(toCity);
        logger.info("From city  ant To city");
        searchForm.click();
        departingButton.click();
        departingDate.click();
        showResaultFlightsButton.click();
        logger.info("end filling");
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
   public void wrongPassengersDataInputForm(String fromCity, String toCity) {
        decrementAmountOfPeopleButton.click();

    }
    public String getWrongAmpuntOfPeopleMessage(){
        logger.info(wrongAmountOfPassengersMessage.getText());
        return wrongAmountOfPassengersMessage.getText();
    }
}
