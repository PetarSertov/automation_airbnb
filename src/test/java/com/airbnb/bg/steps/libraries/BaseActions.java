package com.airbnb.bg.steps.libraries;

import net.serenitybdd.core.PendingStepException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.BasePage;
import page_objects.HomePage;
import utils.WaitForEvent;

import static page_objects.OfferPage.CURRENT_OFFER_CHECK_IN_DATE;


public class BaseActions {

    private WaitForEvent waitForEvent;
    private HomePage homePage;
    private BasePage basePage;

    @Step
    public void open(String pageName) {

        switch (pageName.toLowerCase().trim()) {

            case "homepage":
                this.homePage.open();

                break;

            default:
                throw new PendingStepException("Not implemented for this item: " + pageName);

        }
    }

    @Step
    public String readsTextFrom(WebElementFacade webElement) {
        return webElement.waitUntilVisible()
                .getText()
                .trim();
    }

    @Step
    public String readsTextFrom(By locator) {
        return readsTextFrom((WebElementFacade) basePage.find(locator));
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
        if (checked) {
            checkbox.waitUntilClickable().click();
        }
    }

    @Step
    public void acceptAllCookies() {
        boolean isClicked = false;
        int tryOuts = 0;

        while (!isClicked && tryOuts < 6) {
            try {
                tryOuts++;
                basePage.acceptCookieButton.waitUntilClickable().click();
                isClicked = true;
            } catch (Throwable e) {
                waitForEvent.sleep(1000);
            }
        }
    }


    @Step
    public WebElementFacade waitWebElementToBeVisible(WebElementFacade webElementFacade) {
        boolean isVisible = false;
        int tryOuts = 0;

        while (!isVisible && tryOuts < 6) {
            try {
                tryOuts++;
                webElementFacade.waitUntilVisible();
                isVisible = true;
            } catch (Throwable e) {
                WaitForEvent.sleep(500);
            }
        }
        return webElementFacade;
    }

    @Step
    public WebElement waitWebElementToBeVisible(By by) {
        boolean isVisible = false;
        int tryOuts = 0;
        WebElement element = null;

        while (!isVisible && tryOuts < 6) {
            try {
                tryOuts++;
                element.findElement(by);
                isVisible = true;
            } catch (Throwable e) {
                WaitForEvent.sleep(500);
            }
        }
        return element;
    }

    @Step
    public String waitWebElementToBeDisplayed(By by) {
        int tryOuts = 0;
        WebElement element = null;
        String textFromElement = null;

        while (textFromElement == null && tryOuts < 6) {
            try {
                tryOuts++;
                textFromElement = element.findElement(by).getText();
            } catch (Throwable e) {
                WaitForEvent.sleep(300);
            }
        }
        return textFromElement;
    }

    @Step
    public void navigateToLastTab() {
        basePage.goToLastTab();
    }

}
