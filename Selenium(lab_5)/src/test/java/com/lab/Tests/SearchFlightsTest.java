package com.lab.Tests;

import com.lab.steps.LoginSteps;
import com.lab.steps.SearchFlightsSteps;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFlightsTest{
    private final String fromCity = "London (All Airports)";
    private final String toCity = "Edinburgh (EDI)";
    private final String successfullyFlightsSearch="Now select your flights";
    private final String errorPersonsAmount="No passengers";
    private SearchFlightsSteps searchFlightsSteps;
    @BeforeMethod(description = "Init browser")
    public void setUp() {
        searchFlightsSteps = new SearchFlightsSteps();
        searchFlightsSteps.initBrowser();
    }
    @Test(description = "find available flights")
    public void findAvailableFlights() {
        searchFlightsSteps.findFlights(fromCity, toCity);
        Assert.assertTrue(searchFlightsSteps.isSearchFlightsPerformed(successfullyFlightsSearch));
    }
    @Test(description = "check amount of person worning message ")
    public void wrongNumberOfPassengersInFlights() {
        searchFlightsSteps.wrongNumberOfPassengersInput(fromCity, toCity);
        Assert.assertTrue(searchFlightsSteps.isErrorMessageAppears(errorPersonsAmount));
    }

}
