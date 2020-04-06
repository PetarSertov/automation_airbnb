package com.airbnb.bg.steps.libraries;

import entities.ReservationWidgetDetails;
import widget_objects.ReservationWidget;

import static widget_objects.ReservationWidget.*;

public class ReservationActions extends BaseActions {

    private ReservationWidget reservationWidget;

    public void prepareSearchingDetails(ReservationWidgetDetails reservationWidgetDetails) {
        fillsFieldWithData(PLACE_LOCATOR, reservationWidgetDetails.getPlace());

    }


}
