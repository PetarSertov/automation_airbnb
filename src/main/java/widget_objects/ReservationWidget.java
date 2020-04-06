package widget_objects;

import org.openqa.selenium.By;

public class ReservationWidget {

    public static final By PLACE_LOCATOR = By.cssSelector("input[name='query']");
    public static final By CHECKIN_LOCATOR = By.cssSelector("input[name='checkin']");
    public static final By CHECKOUT_LOCATOR = By.cssSelector("input[name='checkout']");
    public static final By GUESTS_BUTTON_LOCATOR = By.cssSelector("button#lp-guestpicker");   //click to open; click to close;
    public static final By ADD_ADULT_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-adults'] button");
    public static final By ADD_KID_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-children'] button");
    public static final By FORM_SUBMIT_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");


}
