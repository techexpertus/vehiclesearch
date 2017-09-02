import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber-report.json"},
        tags = {"~@ignore"},
        features = "src/test/resources",
        glue = {"com.bdd.stepdefs"},
        strict = true
)
public class CucumberTestSuiteIT {
}
