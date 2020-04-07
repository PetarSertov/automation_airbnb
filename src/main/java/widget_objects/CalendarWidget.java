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

    @FindBy(css = "td[aria-disabled='false'][role='button']")
    List<WebElementFacade> days;


    @FindBy(css = "div[role='button'][aria-label$='следващия месец.']")
    WebElementFacade nextMonthButton;


    public void clicksOnCheckInDate(int numberOfDays) {
        indexOfCheckInDay = numberOfDays - 1;
        checkInDay = currentDay + numberOfDays;

        if (currentDay > checkInDay) {
            nextMonthButton.waitUntilClickable().click();
        }
        days.get(numberOfDays - 1).waitUntilClickable().click();
        System.out.println(days.get(numberOfDays - 1));
    }

    public void clicksOnCheckoutDate(int numberOfDays) {
        int indexOfCheckoutDay = (numberOfDays - 1) + indexOfCheckInDay;

        checkoutDay = checkInDay + indexOfCheckoutDay;

        if (currentDay > checkoutDay) {
            nextMonthButton.waitUntilClickable().click();
        }

        days.get(indexOfCheckoutDay).waitUntilClickable().click();
    }
}
