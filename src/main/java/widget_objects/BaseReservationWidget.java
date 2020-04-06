package widget_objects;

import org.openqa.selenium.By;

public class BaseReservationWidget {

    private static final By BASE_PLACE_LOCATOR = By.cssSelector("input[name='query']");
    private static final By BASE_CHECKIN_LOCATOR = By.cssSelector("input[name='checkin']");
    private static final By BASE_CHECKOUT_LOCATOR = By.cssSelector("input[name='checkout']");
    private static final By BASE_GUESTS_BUTTON_LOCATOR = By.cssSelector("button#lp-guestpicker");   //click to open; click to close;
    private static final By BASE_ADD_ADULT_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-adults'] button");
    private static final By BASE_ADD_KID_BUTTON_LIST_LOCATOR = By.cssSelector("[aria-labelledby$='search_bar-children'] button");
    private static final By BASE_FORM_SUBMIT_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");


}
