package com.airbnb.bg.steps.libraries;

import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import page_objects.ListOfOffersPage;
import widget_objects.CalendarWidget;
import widget_objects.MoreFiltersWidget;
import widget_objects.ReservationWidget;

public class ReservationActions extends BaseActions {

    private ReservationWidget reservationWidget;
    private CalendarWidget calendarWidget;
    private MoreFiltersWidget moreFiltersWidget;
    private ListOfOffersPage listOfOffersPage;


    @Step
    public void prepareSearchingDetails(ReservationDetails reservationDetails) {

        fillsFieldWithData(reservationWidget.placeField, reservationDetails.getPlace());
        clicksOn(reservationWidget.selectDestinationFromDropDown);

        calendarWidget.selectsCheckInDate(reservationDetails.getStartingAfterDays());
        calendarWidget.selectsCheckOutDate(reservationDetails.getVacationDaysNumber());


        clicksOn(reservationWidget.guestsPickerDropDown);
        clicksOnMultipleTimes(reservationWidget.addAdultButton, reservationDetails.getNumberOfAdults());
        clicksOnMultipleTimes(reservationWidget.addKidButton, reservationDetails.getNumberOfKids());

        Serenity.setSessionVariable("guests").to(reservationWidget.numberOfGuests.getText());
        Serenity.setSessionVariable("checkInDate").to(calendarWidget.checkInDate);
        Serenity.setSessionVariable("checkOutDate").to(calendarWidget.checkOutDate);

        clicksOn(reservationWidget.submitReservationFormButton);
    }

    @Step
    public void choosePriceRange(String fromPrice, String toPrice) {
        clicksOn(listOfOffersPage.expandPriceRangeMenuItemButton);
        fillsFieldWithData(listOfOffersPage.fromPriceField, fromPrice);
        fillsFieldWithData(listOfOffersPage.toPriceField, toPrice);
        clicksOn(listOfOffersPage.savePriceFromMenuItemButton);
    }

    @Step
    public void chooseMoreFilters(MoreFiltersDetails moreFiltersDetails) {
        clicksOn(listOfOffersPage.expandMoreFiltersButton);

        clicksOnMultipleTimes(moreFiltersWidget.addBathroomButton, moreFiltersDetails.getNumberOfBathrooms());
        selectFilterCheckbox(moreFiltersWidget.airConditionerCheckBox, moreFiltersDetails.isAirConditioner());
        selectFilterCheckbox(moreFiltersWidget.jacuzziCheckBox, moreFiltersDetails.isJacuzzi());

        clicksOn(moreFiltersWidget.saveMoreFiltersButton);

    }


    @Step
    public void selectOfferByRating(double offerRate) {
        while (!listOfOffersPage.doPageContainOfferWithRate(offerRate)) {
            listOfOffersPage.goToNextOffersPage();
        }
        listOfOffersPage.getOfferByRate(offerRate).waitUntilClickable().click();
    }
}
