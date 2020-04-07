package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import page_objects.BasePage;

public class ReservationWidget extends BasePage {

    @FindBy(css = "input[name=query]")
    public WebElementFacade placeField;

    @FindBy(css = "button#lp-guestpicker")
    public WebElementFacade guestsPickerDropDown; //click to open; click to close

    @FindBy(css = "[aria-labelledby$='search_bar-adults'] button [aria-label='add']")
    public WebElementFacade addAdultButton;

    @FindBy(css = "[aria-labelledby$='search_bar-children'] button [aria-label='add']")
    public WebElementFacade addKidButton;

    @FindBy(css = "button[type='submit']")
    public WebElementFacade formSubmitButton;

    @FindBy(css = "input[name='checkin']")
    public WebElementFacade checkinLocator;

    @FindBy(css = "input[name='checkout']")
    public WebElementFacade checkoutLocator;

    @FindBy(css = "span")
    public WebElementFacade selectDestination;

    @FindBy(css = "#filter-panel-save-button")
    public WebElementFacade saveGuestsPickerButton;

}
