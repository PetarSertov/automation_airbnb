package com.airbnb.bg.steps.libraries;

import net.serenitybdd.core.PendingStepException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @Step
    protected void clicksOnMultipleTimes(WebElementFacade buttonOrLink, int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            buttonOrLink.waitUntilClickable()
                    .click();
        }
    }

    @Step("Selects '{1}' item from drop down {0}")
    protected void selectsFromDropDownAnItemByVisibleText(WebElementFacade dropDownElement,
                                                          String itemValue) {
        if (itemValue != null) {
            dropDownElement.selectByVisibleText(itemValue);
        }
    }

    @Step
    protected void selectFilterCheckbox(WebElementFacade checkbox, boolean checked) {
        if(checked){
            checkbox.waitUntilClickable().click();
        }
    }

}
