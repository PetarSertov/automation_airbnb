package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import page_objects.BasePage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CalendarWidget extends BasePage {

    @FindBy(css = "td[aria-disabled='false']")
    public List<WebElementFacade> days;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendar = Calendar.getInstance();
    public String checkInDate;
    public String checkOutDate;


    private int indexOfCheckInDay;

    public void selectsCheckInDate(int startingAfterDays) {
        indexOfCheckInDay = startingAfterDays - 1;
        calendar.add(Calendar.DAY_OF_MONTH, indexOfCheckInDay);
        checkInDate = simpleDateFormat.format(calendar.getTime());
        days.get(indexOfCheckInDay).waitUntilClickable().click();
    }

    public void selectsCheckOutDate(int vacationDaysNumber) {
        int indexOfCheckoutDay = vacationDaysNumber + indexOfCheckInDay;
        calendar.add(Calendar.DAY_OF_MONTH, vacationDaysNumber);
        checkOutDate = simpleDateFormat.format(calendar.getTime());
        days.get(indexOfCheckoutDay).waitUntilClickable().click();
    }

}
