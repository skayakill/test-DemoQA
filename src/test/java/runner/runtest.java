package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
features = "src/test/resources/features",
        glue ="stepDef",
        tags = "@Test",
        plugin = {"pretty", "html:target/Regression.html"}

)
public class runtest {
}
