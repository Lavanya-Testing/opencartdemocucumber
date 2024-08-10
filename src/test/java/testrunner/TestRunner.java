package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		      //features= {".//features/login.feature"},
		      // features= {".//features/registration.feature","features/login.feature"},
		      //features={".//features/loginDDTExcel.feature"},
		features={".//features/loginDDTExcel.feature"},
		       //features= {".//features/registration.feature"},
                 
                 glue={"stepdefinations","hooks"},
                 plugin= {"pretty", "html:reports/myreport.html",   
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 //tags="@regression",
                // tags="@regression and  @sanity"
                 //tags="@sanity and not @regression"
                 //tags="@sanity or @regression"
							//"rerun:target/rerun.txt"},
                		dryRun=false,    // checks mapping between scenario steps and step definition methods
     					monochrome=true,    // to avoid junk characters in output
     					publish=true)

public class TestRunner {

}
