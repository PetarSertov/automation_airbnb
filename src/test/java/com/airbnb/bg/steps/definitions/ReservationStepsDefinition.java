package com.airbnb.bg.steps.definitions;

import com.airbnb.bg.steps.libraries.BaseActions;
import com.airbnb.bg.steps.libraries.CalendarWidgetActions;
import com.airbnb.bg.steps.libraries.OfferActions;
import com.airbnb.bg.steps.libraries.ReservationActions;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import page_objects.OfferPage;
import widget_objects.CalendarWidget;

import java.util.Map;

import static page_objects.OfferPage.CURRENT_OFFER_CHECK_IN_DATE;
import static utils.TestObjectFactory.prepareTestObjectFrom;


public class ReservationStepsDefinition {

    @Steps
    private BaseActions baseActions;
    @Steps
    private ReservationActions reservationActions;
    @Steps
    private OfferActions offerActions;
    @Steps
    private CalendarWidgetActions calendarWidgetActions;
    @Steps
    private CalendarWidget calendarWidget;
    private OfferPage offerPage;

    @Given("^(?:.*) is on AirBnB \"([^\"]*)\"$")
    public void openPage(String pageName) {
        baseActions.open(pageName);
    }


    @When("^(?:.*) submits his search details:$")
    public void submitsSearchingDetailsWith(@Transpose Map<String, String> reservationData) {
        if (reservationData != null) {
            baseActions.acceptCookies();
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
        reservationActions.selectOfferByRating(numbersOfStars);
        baseActions.navigateToLastTab();
    }

    @Then("^the total calculated price is according to the days$")
    public void theTotalCalculatedPriceIsAccordingToTheDays() {
        System.out.println("WE ARE HERE");
    }

    @Then("^the selected period and guests number is displayed correctly$")
    public void validateGuestsNumberAndVacationPeriod() {
        SoftAssertions softAssertions = new SoftAssertions();

        offerPage.pageStyle.waitUntilVisible();

        //softAssertions.assertThat(offerActions.readsTextFrom(CURRENT_OFFER_CHECK_IN_DATE))
        System.out.println(offerPage.currentOfferCheckInDate.waitUntilVisible().getText());
        System.out.println(offerPage.findAll(CURRENT_OFFER_CHECK_IN_DATE));


        softAssertions.assertThat(offerPage.currentOfferCheckInDate.waitUntilClickable().getValue())
                .as("Check in date should be the same as input check in date.")
                .isEqualTo(calendarWidget.checkInDate);

        softAssertions.assertAll();
    }

    /*
            cartPageActions.opensCartPage();
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(cartPageActions.readsTextFrom(CART_PRODUCT_TOTAL_PRICE_LOCATOR))
                .as("Total price should be calculated correctly")
                .contains(cartPageActions.calculateTotalPriceForProduct(this.product));

        softAssertions.assertThat(cartPageActions.readsTextFrom(CART_PRODUCT_NAME_LOCATOR))
                .as("Product name")
                .isEqualToIgnoringCase(this.product.getProductName());

        softAssertions.assertThat(cartPageActions.readsNumericValueFrom(CART_PRODUCT_QUANTITY_LOCATOR))
                .as("Product quantity")
                .isEqualTo(this.product.getProductQuantity());

        softAssertions.assertThat(cartPageActions.readsTextFrom(CART_PRODUCT_COLOR_SIZE_LOCATOR))
                .as("Product color and size")
                .containsIgnoringCase(this.product.getProductSize())
                .containsIgnoringCase(this.product.getProductColor());

        softAssertions.assertAll();
     */
}
