package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

import java.util.List;

public class OffersPage extends BasePage {

    @FindBy(css = "#price_filter_min")
    public WebElementFacade fromPriceField;

    @FindBy(css = "#price_filter_max")
    public WebElementFacade toPriceField;

    @FindBy(css = "#menuItemButton-price_range")
    public WebElementFacade priceRangeMenuItemButton;

    @FindBy(css = "#filter-panel-save-button")
    public WebElementFacade savePriceButton;

    @FindBy(css = "#menuItemButton-dynamicMoreFilters")
    public WebElementFacade moreFiltersButton;

    //@FindBy(xpath = "//span[text()='5.0']")
    public List<WebElementFacade> starsRatingList;


    public List<WebElementFacade> getStarNumber(double stars) {
        return starsRatingList = findAll(By.xpath("//span[text()=" + stars + "]"));
    }

}
