package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Sportstak_Elements;

public class DriverManager {

	public static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DriverManager.class);

	public static WebDriver getDriver() {
		return driver;
	}

	public static void openThisBrowser(String browser) {

		try {

			switch (browser) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Launched the " + browser + " browser");

				break;
			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Launched the " + browser + " browser");

				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Launched the" + browser + " browser");

				break;
			case "opera":

				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				logger.info("Launched the" + browser + " browser");

				break;
			case "safari":

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				logger.info("Launched the" + browser + " browser");

				break;

			default:
				logger.info("Browser is initiated");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		DriverManager.getDriver().manage().window().maximize();
		PageFactory.initElements(DriverManager.driver, Sportstak_Elements.getInstance());
		PageFactory.initElements(DriverManager.driver, CommonUtils.getInstance());

	}

}
