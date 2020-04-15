package page_objects;

import org.openqa.selenium.By;

public class OfferPage extends BasePage {

    public static By CURRENT_OFFER_CHECK_IN_DATE = By.cssSelector("div[aria-label^='Change dates'] div:first-of-type div:last-child");
    public static By CURRENT_OFFER_CHECK_OUT_DATE = By.cssSelector("div[aria-label^='Change dates'] div:last-child div:last-child");
    public static By CURRENT_OFFER_NUMBER_OF_GUESTS = By.cssSelector("#GuestPicker-book_it-trigger span");
    public static By TOTAL_CALCULATED_PRICE = By.xpath(".//span[contains(text(),'Total')]/parent::li");

    //public static By CURRENT_OFFER_CHECK_IN_DATE = By.cssSelector("input[aria-label='Check-in']");
    //public static By CURRENT_OFFER_CHECK_OUT_DATE = By.cssSelector("input[aria-label='Checkout']");
    //public static By CURRENT_OFFER_NUMBER_OF_GUESTS = By.cssSelector("span.guest-label__text");
    //public static By TOTAL_CALCULATED_PRICE = By.xpath("//*[@id='book_it_form']//span[contains(text(),'€')]");

}
