package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import page_objects.BasePage;

public class ReservationWidget extends BasePage {

    @FindBy(css = "input[name=query]")
    public WebElementFacade placeField;

    @FindBy(css = "form[role=search] button[aria-expanded=false]")
    public WebElementFacade guestsPickerDropDown; //click to open; click to close

    @FindBy(css = "button[aria-describedby$='stepper-adults']:last-child")
    public WebElementFacade addAdultButton;

    @FindBy(css = "button[aria-describedby$='stepper-children']:last-child")
    public WebElementFacade addKidButton;

    @FindBy(css = "button[type='submit']")
    public WebElementFacade formSubmitButton;

    @FindBy(css = "#Koan-query__option-0")
    public WebElementFacade selectDestination;

    @FindBy(css = "button[aria-expanded='true']")
    public WebElementFacade numberOfGuests;

}
