package entities;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.OffersPage;

import java.util.List;


public class OffersDetails extends OffersPage {

    int currentPage = 1;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void goToNextOffersPage() {
        currentPage++;
        navigationBar.findElement(By.cssSelector("[data-id='page-" + currentPage + "']")).click();
    }

    public void selectOfferByRating(double offerRate) {
        while (!doPageContainOfferWithRate(offerRate)) {
            goToNextOffersPage();
        }
        getOfferByRate(offerRate).click();

    }

    private WebElementFacade getOfferByRate(double offerRate) {
        List<WebElementFacade> offerList = findAll(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
        return offerList.get(0);
    }

    private boolean doPageContainOfferWithRate(double offerRate) {
        return this.containsElements(By.xpath("//*[@itemprop='itemListElement' and .//span[@aria-label] and .//span[text()='" + offerRate + "']]"));
    }

}
