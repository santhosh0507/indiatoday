package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/test/resources/features", 
						glue = "steps", 
						//tags = "@tag1", 
						dryRun = false, 
						monochrome = true, 
						publish = true, 
						plugin = { "pretty", "json:target/report/cucumber.json", 
									"html:target/report/cucumber-report.html" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser)
	{
		utils.DriverManager.openThisBrowser(browser);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		utils.DriverManager.getDriver().quit();
	}

}
