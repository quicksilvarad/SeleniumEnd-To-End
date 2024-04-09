package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue="newPack.tepDefinition", monochrome=true, plugin= {"html:target/cucumber.html"}, tags= "@tag1")
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

}
