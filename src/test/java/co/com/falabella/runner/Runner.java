package co.com.falabella.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "C:\\Users\\yeiso\\OneDrive\\Desktop\\QA\\RetoFalabella\\src\\test\\resources\\features",
        glue = "co.com.falabella.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
