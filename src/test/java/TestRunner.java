import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith( CucumberWithSerenity.class )
@CucumberOptions( features = "features",
        glue = "com/airbnb/bg/steps/definitions",
        tags = {""} )
public class TestRunner
{

}
