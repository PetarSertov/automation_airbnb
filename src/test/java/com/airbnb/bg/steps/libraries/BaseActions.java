package com.airbnb.bg.steps.libraries;

import net.serenitybdd.core.PendingStepException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import page_objects.BasePage;
import page_objects.HomePage;


public class BaseActions {

    private HomePage homePage;
    private BasePage basePage;

    @Step
    public void open(String pageName) {

        switch (pageName.toLowerCase().trim()) {
            case "homepage":
                this.homePage.open();
                break;
            default:
                throw new PendingStepException( "Not implemented for this item: " + pageName );

        }
   }

    @Step("Enters '{1}' in field {0}")
    protected void fillsFieldWithData(WebElementFacade fieldElement,
                                      String data) {
        if (data != null) {
            fieldElement.waitUntilEnabled()
                    .type(data);
        }
    }

    protected void fillsFieldWithData(By fieldElement,
                                      String data) {
        fillsFieldWithData((WebElementFacade) basePage.find(fieldElement),
                data);
    }

    @Step
    protected void clicksOn(WebElementFacade buttonOrLink) {
        buttonOrLink.waitUntilClickable()
                .click();
    }


}
