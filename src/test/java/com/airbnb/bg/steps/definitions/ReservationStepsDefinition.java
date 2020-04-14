package com.airbnb.bg.steps.definitions;

import com.airbnb.bg.steps.libraries.*;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebElement;
import page_objects.ListOfOffersPage;
import page_objects.OfferPage;
import utils.WaitForEvent;
import widget_objects.CalendarWidget;

import java.util.Map;

import static page_objects.OfferPage.*;
import static utils.TestObjectFactory.prepareTestObjectFrom;


public class ReservationStepsDefinition {

    private OfferPage offerPage;
    private ListOfOffersPage listOfOffersPage;
    private CalendarWidget calendarWidget;
    private WaitForEvent waitForEvent;

    @Steps
    private BaseActions baseActions;
    @Steps
    private ReservationActions reservationActions;


    @Given("^(?:.*) is on AirBnB \"([^\"]*)\"$")
    public void openPage(String pageName) {
        baseActions.open(pageName);
    }


    @When("^(?:.*) submits his search details:$")
    public void submitsTheFormWithReservationDetails(@Transpose Map<String, String> reservationData) {
        baseActions.acceptAllCookies();
        if (reservationData != null) {
            ReservationDetails reservationObject = prepareTestObjectFrom(ReservationDetails.class, reservationData);
            reservationActions.prepareSearchingDetails(reservationObject);
        } else {
            System.out.println("Searching details are empty!");
        }
    }

    @When("(?:.*) sets the price range from \"([^\"]*)\" to \"([^\"]*)\" euro$")
    public void setPriceRange(String fromPrice, String toPrice) {
        reservationActions.choosePriceRange(fromPrice, toPrice);
    }

    @When("^(?:.*) searches for a place with parameters:$")
    public void setMoreFilters(@Transpose Map<String, String> filtersData) {
        if (filtersData != null) {
            MoreFiltersDetails filtersObject = prepareTestObjectFrom(MoreFiltersDetails.class, filtersData);
            reservationActions.chooseMoreFilters(filtersObject);
        } else {
            System.out.println("Filters details are empty!");
        }
    }

    @When("^(?:.*) selects the first offer with \"([^\"]*)\" stars$")
    public void selectPlaceByRating(Double offerRate) {
        reservationActions.selectOfferByRating(offerRate);
        baseActions.navigateToLastTab();
    }

    @Then("^the total calculated price is according to the days$")
    public void theTotalCalculatedPriceIsAccordingToTheDays() {

        assertThat(baseActions.readsTextFrom(TOTAL_CALCULATED_PRICE).replaceAll("[^0-9]+", ""))
                .as("The total price should be the same as in the Offers Page.")
                .containsIgnoringCase(Serenity.sessionVariableCalled("totalPrice").toString());
    }


    @Then("^the selected period and guests number is displayed correctly$")
    public void validateGuestsNumberAndVacationPeriod() {

        int tryOuts = 0;
        WebElement element = null;
        String checkInDate = null;

        while (checkInDate == null && tryOuts < 6) {
            try {
                tryOuts++;
                checkInDate = this.offerPage.find(CURRENT_OFFER_CHECK_IN_DATE).getText();
            } catch (Throwable e) {
                WaitForEvent.sleep(1000);
            }
        }

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(checkInDate)
                .as("Check in date should be the same as input check in date.")
                .isEqualTo(Serenity.sessionVariableCalled("checkInDate").toString());

        softAssertions.assertThat(this.offerPage.find(CURRENT_OFFER_CHECK_OUT_DATE).getText())
                .as("Check out date should be the same as input check out date.")
                .isEqualTo(Serenity.sessionVariableCalled("checkOutDate").toString());

        softAssertions.assertThat(this.offerPage.find(CURRENT_OFFER_NUMBER_OF_GUESTS).getText())
                .as("Guest number should be the same as input guests.")
                .isEqualTo(Serenity.sessionVariableCalled("guests").toString());

        softAssertions.assertAll();
    }

}
