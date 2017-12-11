package com.lab.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eugene on 12/10/17.
 */
public class PostLoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//*[@id=\"masthead\"]/div[1]/div[1]/a[2]")
    private WebElement signOut;
    @FindBy(id = "ContactDetailsLinkBreadcrumb")
    private WebElement showUserInformatinoButton;

    public PostLoginPage(WebDriver driver) {
        super(driver);

    }

    public String getLoggedInEmailAddress() {
        logger.info("check for registration-" + showUserInformatinoButton.getText());
        signOut.click();
        String temp=showUserInformatinoButton.getText();
        return temp;
    }
    public String getSignOutOption(){
        return signOut.getText();
    }

    @Override
    public void openPage() {
        logger.info("PostLoginPage opened");
    }

}
