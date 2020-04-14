package com.airbnb.bg.steps.libraries;

import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.thucydides.core.annotations.Step;
import page_objects.ListOfOffersPage;
import widget_objects.CalendarWidget;
import widget_objects.MoreFiltersWidget;
import widget_objects.ReservationWidget;

public class ReservationActions extends BaseActions {

    private ReservationWidget reservationWidget;
    private CalendarWidgetActions calendarWidgetActions;
    private CalendarWidget calendarWidget;
    private ListOfOffersPage listOfOffersPage;
    private MoreFiltersWidget moreFiltersWidget;
    public String guests;

    @Step
    public void prepareSearchingDetails(ReservationDetails reservationDetails) {

        fillsFieldWithData(reservationWidget.placeField, reservationDetails.getPlace());
        clicksOn(reservationWidget.selectDestination);

        calendarWidget.clicksOnCheckInDate(reservationDetails.getStartingAfterDays());
        calendarWidget.clicksOnCheckoutDate(reservationDetails.getVacationDaysNumber());

        //calendarWidgetActions.clicksOnCheckInDate(reservationDetails.getStartingAfterDays());
        //calendarWidgetActions.clicksOnCheckoutDate(reservationDetails.getVacationDaysNumber());

        clicksOn(reservationWidget.guestsPickerDropDown);
        clicksOnMultipleTimes(reservationWidget.addAdultButton, reservationDetails.getNumberOfAdults());
        clicksOnMultipleTimes(reservationWidget.addKidButton, reservationDetails.getNumberOfKids());

        guests = reservationWidget.numberOfGuests.getText();

        clicksOn(reservationWidget.formSubmitButton);
    }

    @Step
    public void choosePriceRange(String fromPrice, String toPrice) {
        clicksOn(listOfOffersPage.priceRangeMenuItemButton);
        fillsFieldWithData(listOfOffersPage.fromPriceField, fromPrice);
        fillsFieldWithData(listOfOffersPage.toPriceField, toPrice);
        clicksOn((listOfOffersPage.savePriceButton));
    }

    @Step
    public void chooseMoreFilters(MoreFiltersDetails moreFiltersDetails) {
        clicksOn(listOfOffersPage.moreFiltersButton);

        clicksOnMultipleTimes(moreFiltersWidget.addBathroomButton, moreFiltersDetails.getNumberOfBathrooms());
        selectFilterCheckbox(moreFiltersWidget.airConditionerCheckBox, moreFiltersDetails.isAirConditioner());
        selectFilterCheckbox(moreFiltersWidget.jacuzziCheckBox, moreFiltersDetails.isJacuzzi());

        clicksOn(moreFiltersWidget.saveMoreFiltersButton);

    }

    /*
    @Step
    public void selectPlaceByStarRating(Double numbersOfStars) {
        /*int ordinalNumber = OrdinalNumbers.valueOf(elementIntoTheList.toUpperCase())
                .getValue();
        selectOfferByRating(numbersOfStars);
    }
    */

    @Step
    public void selectOfferByRating(double offerRate) {
        while (!listOfOffersPage.doPageContainOfferWithRate(offerRate)) {
            listOfOffersPage.goToNextOffersPage();
        }
        listOfOffersPage.getOfferByRate(offerRate).waitUntilClickable().click();
    }
}
