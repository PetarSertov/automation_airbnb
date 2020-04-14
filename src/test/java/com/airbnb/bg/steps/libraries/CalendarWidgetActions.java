package com.airbnb.bg.steps.libraries;

import net.thucydides.core.annotations.Step;
import widget_objects.CalendarWidget;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarWidgetActions extends BaseActions {
    public CalendarWidget calendarWidget;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Calendar calendar = Calendar.getInstance();
    public String checkInDate;
    public String checkOutDate;

    private int indexOfCheckInDay;

    @Step
    public void clicksOnCheckInDate(int startingAfterDays) {
        indexOfCheckInDay = startingAfterDays - 1;
        calendar.add(Calendar.DAY_OF_MONTH, startingAfterDays);
        checkInDate = simpleDateFormat.format(calendar.getTime());
        calendarWidget.days.get(indexOfCheckInDay).waitUntilClickable().click();
    }

    @Step
    public void clicksOnCheckoutDate(int numberOfDays) {
        int indexOfCheckoutDay = numberOfDays + indexOfCheckInDay;
        calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
        checkOutDate = simpleDateFormat.format(calendar.getTime());
        calendarWidget.days.get(indexOfCheckoutDay).waitUntilClickable().click();
    }
}
