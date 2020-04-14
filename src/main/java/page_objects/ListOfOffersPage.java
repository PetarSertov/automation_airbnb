package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class ListOfOffersPage extends BasePage {


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

    @FindBy(css = "nav[data-id='SearchResultsPagination']")
    public WebElementFacade navigationBar;

    private int currentPage = 1;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public String pricePerNight;

    public void goToNextOffersPage() {
        currentPage++;
        System.out.println("CURRENT_PAGE++ " + currentPage);
        //WebElementFacade nextPageArrow = navigationBar.findBy(By.cssSelector("[data-id='page-" + currentPage + "']"));
        WebElementFacade nextPageArrow = navigationBar.findBy(By.cssSelector("[aria-label='Page " + currentPage + "']"));
        nextPageArrow.waitUntilClickable().click();
    }

    public WebElementFacade getOfferByRate(double offerRate) {
        List<WebElementFacade> offerList = findAll(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
        String price = offerList.get(0).findBy(By.xpath(".//span[contains(text(),'€')]")).getText();
        System.out.println(price);
        List<String> listPrice = Arrays.asList(price.split("\n"));
        pricePerNight = listPrice.get(listPrice.size()-1).replace("€","");
        return offerList.get(0);
    }

    public boolean doPageContainOfferWithRate(double offerRate) {
        return this.containsElements(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
    }


}