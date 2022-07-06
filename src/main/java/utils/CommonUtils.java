package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	private static CommonUtils CommonUtilsInstance;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {
		if (CommonUtilsInstance == null) {
			CommonUtilsInstance = new CommonUtils();
		}
		return CommonUtilsInstance;

	}
	
	Actions actions = new Actions(DriverManager.getDriver());
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
	
	public void explicitWait(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
