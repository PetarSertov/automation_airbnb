package page_objects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ListOfOffersPage extends BasePage {


    @FindBy(css = "#price_filter_min")
    public WebElementFacade fromPriceField;

    @FindBy(css = "#price_filter_max")
    public WebElementFacade toPriceField;

    @FindBy(css = "#menuItemButton-price_range")
    public WebElementFacade expandPriceRangeMenuItemButton;

    @FindBy(css = "#filter-panel-save-button")
    public WebElementFacade savePriceFromMenuItemButton;

    @FindBy(css = "#menuItemButton-dynamicMoreFilters")
    public WebElementFacade expandMoreFiltersButton;

    @FindBy(css = "nav[data-id='SearchResultsPagination']")
    public WebElementFacade navigationBar;

    private int currentPage = 1;
    //public String pricePerNight;

    public void goToNextOffersPage() {
        currentPage++;
        navigationBar.findBy(By.cssSelector("[aria-label='Page " + currentPage + "']"))
                .waitUntilClickable()
                .click();
    }

    public WebElementFacade getOfferByRate(double offerRate) {
        List<WebElementFacade> offerList = findAll(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
        List<WebElementFacade> priceList = offerList.get(0).thenFindAll(By.xpath(".//span[contains(text(),'€')]"));
        String roughTotalPrice = priceList.get(priceList.size() - 1).getText();
        //pricePerNight = priceList.get(priceList.size() - 2).getText().replaceAll("[^0-9]+", "");
        Serenity.setSessionVariable("totalPrice").to(roughTotalPrice.replaceAll("[^0-9]+", ""));


        return offerList.get(0);
    }

    public boolean doPageContainOfferWithRate(double offerRate) {
        return this.containsElements(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
    }


}