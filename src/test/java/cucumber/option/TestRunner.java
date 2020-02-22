package cucumber.option;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/Customers.feature",
                  glue= {"StepDefinitions"},
                		  dryRun=false,
                  monochrome=true, 
                   plugin= {"pretty","html:target/testouput"},
                //   tags= {"@Sanity","@Regression"}  ///it executes both sanity and regession test case
                                                     //it acts as a AND  operator
		
     //  tags= {"@Sanity,@Regression"}  //it acts as a OR operator
                                      //it executes all sanity and regression test case
	tags="@Sanity"
		
		)                                                
public class TestRunner {
//monochrome=true, 
   // plugin= {"pretty","html:target/testouput"}
	// dryRun=true

}
