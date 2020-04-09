package com.airbnb.bg.steps.definitions;

import com.airbnb.bg.steps.libraries.BaseActions;
import com.airbnb.bg.steps.libraries.ReservationActions;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static utils.TestObjectFactory.prepareTestObjectFrom;


public class ReservationStepsDefinition {

    @Steps
    private BaseActions baseActions;
    @Steps
    private ReservationActions reservationActions;

    @Given("^(?:.*) is on AirBnB \"([^\"]*)\"$")
    public void openPage(String pageName) {
        baseActions.open(pageName);
    }


    @When("^(?:.*) submits his search details:$")
    public void submitsSearchingDetailsWith(@Transpose Map<String, String> reservationData) {
        if (reservationData != null) {
            ReservationDetails reservationObject = prepareTestObjectFrom(ReservationDetails.class, reservationData);
            reservationActions.prepareSearchingDetails(reservationObject);
        } else {
            System.out.println("Searching details are empty!");
        }


    }

    @When("(?:.*) sets the price range from \"([^\"]*)\" to \"([^\"]*)\" levs$")
    public void setPriceRange(String fromPrice, String toPrice) {
        reservationActions.choosePriceRange(fromPrice, toPrice);
    }

    @When("^(?:.*) searches for a place with parameters:$")
    public void setMoreFilters(@Transpose Map<String, String> filtersData) {
        if (filtersData != null) {
            MoreFiltersDetails filtersObject = prepareTestObjectFrom(MoreFiltersDetails.class, filtersData);
            reservationActions.chooseMoreFilters(filtersObject);
        } else {
            System.out.println("Searching details are empty!");
        }
    }

    @When("^(?:.*) selects the first offer with \"([^\"]*)\" stars$")
    public void selectPlaceByStar(Double numbersOfStars) {
        reservationActions.selectPlaceByStarRating(numbersOfStars);

    }
}
