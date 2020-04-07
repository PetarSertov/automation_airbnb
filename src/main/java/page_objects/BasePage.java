package page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;

public class BasePage extends PageObject {

    @WhenPageOpens
    public void makeBrowserWindowFullScreen( )
    {
        this
                .getDriver( )
                .manage( )
                .window( )
                .maximize( );
    }
}
