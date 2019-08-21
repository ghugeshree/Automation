package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue= {"stepDefinitions"},
        tags = {"@SignUp, @PrimaryConsent"},
        monochrome = true,
        format = {"pretty", "html:target/Reports"}
)

public class TestRunner {

}
