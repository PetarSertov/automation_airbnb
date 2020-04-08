package entities;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import page_objects.OffersPage;

import java.util.List;

public class OffersDetails extends OffersPage {

    OffersPage offersPage;
    int currentOfferIndex = 0;
    boolean isElementContained = false;

    @FindBy(css = "div a[href^='/rooms/']")
    public List<WebElementFacade> offersWebElementFacadeList;

    public void findOfferWith(double offerStarNumber) {
        checkIfOfferIsOnThisPage(offerStarNumber);
    }

    public void checkIfOfferIsOnThisPage(double offerStarNumber) {
        do {
            isElementContained = offersWebElementFacadeList.get(currentOfferIndex).containsElements(By.xpath("//span[text()='" + offerStarNumber + "']"));
            if (!isElementContained) {
                offersPage.goToNextPage();
            } else {
                clickOnOffer(offerStarNumber);
            }
        } while (isElementContained);
    }

    public void clickOnOffer(double offerStarNumber) {
        for (WebElementFacade currentOfferWebElementFacade : offersWebElementFacadeList) {
            if (currentOfferWebElementFacade.containsElements(By.xpath("//span[text()='" + offerStarNumber + "']"))) {
                currentOfferWebElementFacade.waitUntilClickable().click();
                break;
            }
        }
    }

}
