package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CalendarWidget {

    @FindBy(css = "td")
    List<WebElementFacade> days;

    public void clicksOnDate(int day) {
        days.get(day - 1).waitUntilClickable().click();
    }
}
