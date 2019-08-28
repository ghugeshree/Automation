package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature_files/SignUp.feature"},
        glue= {"step_definitions"},
        //tags = {"@PrimaryConsent"},
        monochrome = true,
        format = {"pretty", "html:target/Reports"}
)


public class TestRunner {

}
