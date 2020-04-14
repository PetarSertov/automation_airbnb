package page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class BasePage extends PageObject {

    @FindBy(css ="button.optanon-allow-all")
    public WebElementFacade acceptCookieButton;

    public void goToLastTab(){
        ArrayList<String> tabs = new ArrayList<String>(this.getDriver().getWindowHandles());
        this.getDriver().switchTo().window(tabs.get(tabs.size()-1));
    }
}
