package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

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
}
