package test.cuke;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/cuke",
		glue = "com.qa.cuke.stepdefs")
public class CukeRunner {

}
