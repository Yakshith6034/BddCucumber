package StepRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features/BookCartRegistration.feature",
    glue = "StepDefinition",
    	

    		plugin= {"pretty","html:test-output"},
    
  

    monochrome = true, dryRun = false, publish = true
    
   
)
public class Step {
}

