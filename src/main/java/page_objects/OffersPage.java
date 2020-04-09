package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

public class OffersPage extends BasePage {

    //int i;
    //List<Integer> indexOfContainedElements = null;
    int currentPage = 1;
   // boolean isElementClicked = false;

    public By byPageNumber = By.cssSelector("[data-id='page-" + currentPage + "']");

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

    //@FindBy(css = "div a[href^='/rooms/']")
    //public List<WebElementFacade> offersList;

    @FindBy(css = "nav[data-id='SearchResultsPagination']")
    public WebElementFacade navigationBar;

    //public void findElementWithStars(double starNumber, int ordinalNumber) {
//
    //    for (i = 0; offersList.size() > i; i++) {
//
    //        boolean isElementContained = offersList.get(i).containsElements(By.xpath("//span[text()='" + starNumber + "']"));
//
    //        if (isElementContained) {
    //            indexOfContainedElements.add(i);
    //        }
    //    }
    //    if (indexOfContainedElements != null && (indexOfContainedElements.size() >= ordinalNumber)) {
    //        isElementClicked = true;
    //        offersList.get(indexOfContainedElements.get(ordinalNumber)).click();
    //    }
    //}

   //public void goToNextPage(double starNumber, int ordinalNumber) {
   //    if (indexOfContainedElements == null) {
   //        currentPage = currentPage + 1;
   //        navigationBar.findElement(pageNumber).click();
   //    }
   //}

    public void goToNextPage() {
        currentPage = currentPage + 1;
        navigationBar.findElement(byPageNumber).click();
    }

    //public void clickElementWithStars(double starNumber, int ordinalNumber) {
//
    //    findElementWithStars(starNumber, ordinalNumber);
//
    //    do {
    //        goToNextPage(starNumber, ordinalNumber);
    //        findElementWithStars(starNumber, ordinalNumber);
    //    } while (isElementClicked);
    //}
}
//@FindBy(xpath = "//span[text()='5.0']")
//public List<WebElementFacade> starsRatingList;
//
//
//public List<WebElementFacade> getStarNumber(double stars) {
//    return starsRatingList = findAll(By.xpath("//span[text()=" + stars + "]"));
//}
