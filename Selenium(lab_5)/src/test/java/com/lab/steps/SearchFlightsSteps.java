package com.lab.steps;

import com.lab.driver.DriverSingleton;
import com.lab.pages.FligtsSearchResaultPage;
import com.lab.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by eugene on 12/11/17.
 */
public class SearchFlightsSteps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }
    public void findFlights(String fromCity, String toCity) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillSearchForm(fromCity, toCity);

    }

    public boolean isSearchFlightsPerformed(String searchFlightsResualt) {
        FligtsSearchResaultPage fligtsSearchResaultPage=new FligtsSearchResaultPage(driver);

        return (fligtsSearchResaultPage.getFlightsSearchText().equals(searchFlightsResualt));
    }
}
