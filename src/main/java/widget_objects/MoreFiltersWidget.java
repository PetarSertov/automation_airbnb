package widget_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import page_objects.BasePage;

public class MoreFiltersWidget extends BasePage {

    @FindBy(css = "label[for=filterItem-checkbox-amenities-5]")
    public WebElementFacade airConditionerCheckBox;

    @FindBy(css = "label[for=filterItem-checkbox-amenities-25]")
    public WebElementFacade jacuzziCheckBox;

    @FindBy(css = "button[aria-describedby*='bathrooms']:last-child")
    public WebElementFacade addBathroomButton;

    @FindBy(css = "footer > button")
    public WebElementFacade saveMoreFiltersButton;
}
