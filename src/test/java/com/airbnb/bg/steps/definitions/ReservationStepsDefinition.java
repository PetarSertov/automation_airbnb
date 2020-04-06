package com.airbnb.bg.steps.definitions;

import com.airbnb.bg.steps.libraries.BaseActions;
import com.airbnb.bg.steps.libraries.ReservationActions;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.ReservationWidgetDetails;
import net.thucydides.core.annotations.Steps;

import java.time.LocalDate;
import java.util.Map;

import static utils.TestObjectFactory.*;


public class ReservationStepsDefinition {

    @Steps
    private BaseActions baseActions;
    @Steps
    private ReservationActions reservationActions;

    @Given("^John is on AirBnB \"([^\"]*)\"$")
    public void openPage(String pageName) {
        baseActions.open(pageName);
    }


    @When("^John enters his search details:$")
    public void fillSearchingDetails(@Transpose Map<String, String> rawData) {
        if (rawData != null) {

            //ReservationWidgetDetails reservationWidgetDetails = prepareTestObjectFrom(ReservationWidgetDetails.class, rawData);
            //reservationActions.prepareSearchingDetails(reservationWidgetDetails);

        } else {
            System.out.println("Searching details are empty !!!");
        }


    }
}
