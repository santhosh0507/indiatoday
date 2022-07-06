package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonUtils;
import utils.DriverManager;

public class Sportstak_Elements {
	
	private static Sportstak_Elements Sportstak_ElementsInstance;

	private Sportstak_Elements() {

	}

	public static Sportstak_Elements getInstance() {
		if (Sportstak_ElementsInstance == null) {
			Sportstak_ElementsInstance = new Sportstak_Elements();
		}
		return Sportstak_ElementsInstance;

	}

	@FindBy(xpath = "//*[@class='feature-tabs verticalLine']")
	private List<WebElement> headerOptions;

	public void selectThisFromHeader(String input) {
		for (WebElement options : headerOptions) {
			if (options.getText().equalsIgnoreCase(input)) {
				options.click();
			}
		}
	}
	
	@FindBy(xpath = "//*[@class='header']//child::button")
	private WebElement leftMenu;
	
	public void clickLeftMenu()
	{
		leftMenu.click();
	}
	
	@FindBy(xpath = "//*[text()='Theme']")
	private WebElement theme;
	
	public void clickTheme()
	{
		CommonUtils.getInstance().explicitWait(theme);
		theme.click();
	}
	
	@FindBy(xpath = "//*[@class='MuiPaper-root MuiAppBar-root MuiAppBar-positionStatic MuiAppBar-colorPrimary MuiPaper-elevation4']")
	private WebElement headerBox;
	
	public String getheaderColour()
	{
		return headerBox.getCssValue("background-color");
	}
	
	@FindBy(xpath = "//img")
	private List<WebElement> imageTag;
	
	public List<WebElement> imageTags()
	{
		return imageTag;
	}
	
	@FindBy(xpath = "//*[@class='jsx-3628065952 cardimage']//child::img")
	private WebElement allStories;
	
	public void selectThisStory() throws InterruptedException
	{
		WebElement iframe = DriverManager.getDriver().findElement(By.tagName("iframe"));
		DriverManager.getDriver().switchTo().frame(iframe); 	
		allStories.click();
		DriverManager.getDriver().switchTo().defaultContent();
	}
	
	@FindBy(xpath = "//h2")
	private List<WebElement> allStorytext;
	
	public List<WebElement> allText()
	{
		
		return allStorytext;
	}
	
}
