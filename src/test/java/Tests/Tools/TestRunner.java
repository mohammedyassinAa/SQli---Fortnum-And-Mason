package Tests.Tools;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "Features",
        glue = {"Tests"},
        plugin = {
                "pretty",
                "json:target/cucumber-report.json", // for JSON
                "html:target/cucumber-html-report.html" // for HTML
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}