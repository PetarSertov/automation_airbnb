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

    @Given("^John is on AirBnB \"([^\"]*)\"$")
    public void openPage(String pageName) {
        baseActions.open(pageName);
    }


    @When("^John submits his search details:$")
    public void fillSearchingDetails(@Transpose Map<String, String> rawData) {
        if (rawData != null) {
            ReservationDetails reservationDetails = prepareTestObjectFrom(ReservationDetails.class, rawData);
            reservationActions.prepareSearchingDetails(reservationDetails);
        } else {
            System.out.println("Searching details are empty !!!");
        }


    }

    @When("^he sets the price range from \"([^\"]*)\" to \"([^\"]*)\" levs$")
    public void setPriceRange(String fromPrice, String toPrice) {
        reservationActions.choosePriceRange(fromPrice, toPrice);
    }

    @When("^he searches for a place with parameters:$")
    public void setMoreFilters(@Transpose Map<String, String> rawData) {
        if (rawData != null) {
            MoreFiltersDetails moreFiltersDetails = prepareTestObjectFrom(MoreFiltersDetails.class, rawData);
            reservationActions.chooseMoreFilters(moreFiltersDetails);
        } else {
            System.out.println("Searching details are empty !!!");
        }
    }

    @When("^he selects the \"([^\"]*)\" place with \"([^\"]*)\" stars$")
    public void selectPlaceByStar(String elementIntoTheList, Double numbersOfStars) {

        reservationActions.selectPlaceByStarRating(elementIntoTheList, numbersOfStars);

    }
}
