package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class OfferPage extends BasePage {

    public static By CURRENT_OFFER_CHECK_IN_DATE = By.cssSelector("input#checkin~div||div");
    public static By CURRENT_OFFER_CHECK_OUT_DATE = By.cssSelector("div[aria-label][role='button'] div:last-child div:last-child");
    public static By CURRENT_OFFER_NUMBER_OF_GUESTS = By.cssSelector("#GuestPicker-book_it-trigger span");


    //@FindBy(css = "div[aria-label][role='button'] div div:last-child")
    @FindBy(css = "input#checkin~div||div")
    public WebElementFacade currentOfferCheckInDate;

    @FindBy(css = "h1 span")
    public WebElementFacade title;

    @FindBy(css = "div[data-testid='book-it-default'] div[style^='background:']")
    public WebElementFacade pageStyle;

}
