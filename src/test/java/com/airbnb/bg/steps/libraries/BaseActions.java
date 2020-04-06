package com.airbnb.bg.steps.libraries;

import net.serenitybdd.core.PendingStepException;
import page_objects.HomePage;

public class BaseActions {

    private HomePage homePage;


    public void open(String pageName) {

        switch (pageName.toLowerCase().trim()) {
            case "homepage":
                this.homePage.open();
                break;
            default:
                throw new PendingStepException( "Not implemented for this item: " + pageName );

        }
   }
}
