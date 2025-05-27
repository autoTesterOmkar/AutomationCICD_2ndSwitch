package RSA2_Framework.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions (features="src/test/java/RSA2_Framework.cucumber", glue="RSA2_cucumber.stepDefination" , 
monochrome = true, plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
	
   }
