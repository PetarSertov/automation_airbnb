package com.airbnb.bg.steps.libraries;

import entities.MoreFiltersDetails;
import entities.ReservationDetails;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import page_objects.OffersPage;
import widget_objects.CalendarWidget;
import widget_objects.MoreFiltersWidget;
import widget_objects.ReservationWidget;

import java.util.Map;

public class ReservationActions extends BaseActions {

    private ReservationWidget reservationWidget;
    private CalendarWidget calendarWidget;
    private OffersPage offersPage;
    private MoreFiltersWidget moreFiltersWidget;


    @Step
    public void prepareSearchingDetails(ReservationDetails reservationDetails) {

        fillsFieldWithData(reservationWidget.placeField, reservationDetails.getPlace());
        clicksOn(reservationWidget.selectDestination);

        clicksOn(reservationWidget.checkinLocator);
        calendarWidget.clicksOnCheckinDate(reservationDetails.getStartingAfterDays());

        clicksOn(reservationWidget.checkoutLocator);
        calendarWidget.clicksOnCheckoutDate(reservationDetails.getVacationDaysNumber());

        clicksOn(reservationWidget.guestsPickerDropDown);
        clicksOnTimes(reservationWidget.addAdultButton, reservationDetails.getNumberOfAdults());
        clicksOnTimes(reservationWidget.addKidButton, reservationDetails.getNumberOfKids());
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
        
        clicksOn(moreFiltersWidget.addBathroomButton);
        clicksOn(moreFiltersWidget.airConditionerCheckBox);
        clicksOn(moreFiltersWidget.jacuzziCheckBox);
        
        clicksOn(moreFiltersWidget.saveMoreFiltersButton);

    }

}
