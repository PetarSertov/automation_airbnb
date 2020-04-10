package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import page_objects.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CalendarWidget extends BasePage {

    DateFormat dateFormat = new SimpleDateFormat("dd");
    Date date = new Date();
    int currentDay = Integer.parseInt(dateFormat.format(date));
    int checkInDay;
    int checkoutDay;
    int indexOfCheckInDay;

    @FindBy(css = "td[aria-disabled='false']")
    List<WebElementFacade> days;

    public void clicksOnCheckInDate(int startingAfterDays) {
        indexOfCheckInDay = startingAfterDays - 1;
        checkInDay = currentDay + startingAfterDays;
        days.get(indexOfCheckInDay).waitUntilClickable().click();
    }

    public void clicksOnCheckoutDate(int numberOfDays) {
        int indexOfCheckoutDay = numberOfDays + indexOfCheckInDay;
        checkoutDay = checkInDay + indexOfCheckoutDay;
        days.get(indexOfCheckoutDay).waitUntilClickable().click();
    }

}
