package com.airbnb.bg.steps.libraries;

import entities.MoreFiltersDetails;
import entities.OffersDetails;
import entities.ReservationDetails;
import net.thucydides.core.annotations.Step;
import page_objects.OffersPage;
import utils.OrdinalNumbers;
import widget_objects.CalendarWidget;
import widget_objects.MoreFiltersWidget;
import widget_objects.ReservationWidget;

public class ReservationActions extends BaseActions {

    private ReservationWidget reservationWidget;
    private CalendarWidget calendarWidget;
    private OffersPage offersPage;
    private MoreFiltersWidget moreFiltersWidget;
    private OffersDetails offersDetails;


    @Step
    public void prepareSearchingDetails(ReservationDetails reservationDetails) {

        fillsFieldWithData(reservationWidget.placeField, reservationDetails.getPlace());
        clicksOn(reservationWidget.selectDestination);

        clicksOn(reservationWidget.checkinLocator);
        calendarWidget.clicksOnCheckInDate(reservationDetails.getStartingAfterDays());

        clicksOn(reservationWidget.checkoutLocator);
        calendarWidget.clicksOnCheckoutDate(reservationDetails.getVacationDaysNumber());

        clicksOn(reservationWidget.guestsPickerDropDown);
        clicksOnMultipleTimes(reservationWidget.addAdultButton, reservationDetails.getNumberOfAdults());
        clicksOnMultipleTimes(reservationWidget.addKidButton, reservationDetails.getNumberOfKids());
        clicksOn(reservationWidget.saveGuestsPickerButton);

        clicksOn(reservationWidget.formSubmitButton);
    }

    @Step
    public void choosePriceRange(String fromPrice, String toPrice) {
        clicksOn(offersPage.priceRangeMenuItemButton);
        fillsFieldWithData(offersPage.fromPriceField, fromPrice);
        fillsFieldWithData(offersPage.toPriceField, toPrice);
        clicksOn((offersPage.savePriceButton));
    }

    @Step
    public void chooseMoreFilters(MoreFiltersDetails moreFiltersDetails) {
        clicksOn(offersPage.moreFiltersButton);

        clicksOnMultipleTimes(moreFiltersWidget.addBathroomButton, moreFiltersDetails.getNumberOfBathrooms());
        selectFilterCheckbox(moreFiltersWidget.airConditionerCheckBox, moreFiltersDetails.isAirConditioner());
        selectFilterCheckbox(moreFiltersWidget.jacuzziCheckBox, moreFiltersDetails.isJacuzzi());

        clicksOn(moreFiltersWidget.saveMoreFiltersButton);

    }

    @Step
    public void selectPlaceByStarRating(Double numbersOfStars) {
        /*int ordinalNumber = OrdinalNumbers.valueOf(elementIntoTheList.toUpperCase())
                .getValue();*/
        offersDetails.findOfferWith(numbersOfStars);
    }
}
