package steps;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Sportstak_Elements;
import utils.CommonUtils;
import utils.DriverManager;

public class IndiaTodaySteps {

	@Given("^select this language (.+)$")
	public void select_this_language(String language) throws Throwable {
		System.out.println("hello world");
	}

	@Given("^from home page scroll to bottom$")
	public void from_home_page_scroll_to_bottom() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		try {
			Object lastHeight = js.executeScript("return document.body.scrollHeight");
			while (true) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);
				Object newHeight = js.executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);

	}

	@Then("^verify the broken images$")
	public void verify_the_broken_images() throws Throwable {

		System.out.println("no. of images = " + Sportstak_Elements.getInstance().imageTags().size());
		for (WebElement image : Sportstak_Elements.getInstance().imageTags()) {
			String imageURL = image.getAttribute("src");
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_T);
			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
			DriverManager.getDriver().switchTo().window(tabs.get(1));
			DriverManager.getDriver().get(imageURL);
			String pageTitle = DriverManager.getDriver().getTitle();
			if (pageTitle != "404") {
				System.out.println("image is valid");
			} else {
				System.out.println("Broken image");
			}
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_W);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_W);
			DriverManager.getDriver().switchTo().window(tabs.get(0));

		}

	}

	@Given("^click on left hamburger menu$")
	public void click_on_left_hamburger_menu() throws Throwable {
		Sportstak_Elements.getInstance().clickLeftMenu();
	}

	@Then("^change the theme and verify the header colour$")
	public void change_the_theme_and_verify_the_header_colour() throws Throwable {
		Sportstak_Elements.getInstance().clickTheme();
		String headerColor = Sportstak_Elements.getInstance().getheaderColour();
		String colour = Color.fromString(headerColor).asHex();
		assertEquals("#0a1c58", colour);
	}

	@Given("^Navigate to webstory section$")
	public void navigate_to_webstory_section() throws Throwable {
		Sportstak_Elements.getInstance().selectThisFromHeader("webstory");
	}

	@Then("^click on any webstory from the page$")
	public void click_on_any_webstory_from_the_page() throws Throwable {
		Sportstak_Elements.getInstance().selectThisStory();

	}

	@Then("^capture the text on each web stories$")
	public void capture_the_text_on_each_web_stories() throws Throwable {

		WebElement iframe = DriverManager.getDriver().findElement(By.tagName("iframe"));
		DriverManager.getDriver().switchTo().frame(iframe);

		for (WebElement iterable_element : Sportstak_Elements.getInstance().allText()) {
			String storyText = iterable_element.getText();
			System.out.println("Story text :" + storyText);

		}

		DriverManager.getDriver().switchTo().defaultContent();
	}

	@When("^select any webstory$")
	public void select_any_webstory() throws Throwable {

	}

	@Then("^Click on the home section$")
	public void click_on_the_home_section() throws Throwable {
		Sportstak_Elements.getInstance().selectThisFromHeader("home");
	}

}
