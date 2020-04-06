package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ReservationWidget {

    public static final By PLACE_LOCATOR = By.cssSelector("input[name='query']");
    public static final By GUESTS_BUTTON_LOCATOR = By.cssSelector("button#lp-guestpicker");   //click to open; click to close;
    public static final By ADD_ADULT_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-adults'] button");
    public static final By ADD_KID_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-children'] button");
    public static final By FORM_SUBMIT_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");

    @FindBy(css = "input[name='checkin']")
    public WebElementFacade checkinLocator;

    @FindBy(css = "input[name='checkout']")
    public WebElementFacade checkoutLocator;
}
