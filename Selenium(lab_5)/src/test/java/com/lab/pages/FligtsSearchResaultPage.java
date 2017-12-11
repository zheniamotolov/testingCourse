package com.lab.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eugene on 12/11/17.
 */
public class FligtsSearchResaultPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "/html/body/div[4]/header/div[3]/div/div/h2")
    private WebElement pickFlightsText;

    public FligtsSearchResaultPage(WebDriver driver) {
        super(driver);

    }
    public String getFlightsSearchText(){
        logger.info("end filling kek");
        logger.info("check for registration-" + pickFlightsText.getText());
        return pickFlightsText.getText();
    }


    @Override
    public void openPage() {
        logger.info("FligtsSearchResaultPage opened");
    }

}
