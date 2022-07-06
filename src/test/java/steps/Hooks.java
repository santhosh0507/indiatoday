package steps;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {
	
	@Before
	public void homePage() throws InterruptedException
	{
		DriverManager.getDriver().get("https://thesportstak.com");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
	}
	
	@After
	public void ifFailTakeScreenshot()
	{
		
	}

}
