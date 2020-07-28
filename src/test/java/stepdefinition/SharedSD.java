package stepdefinition;

import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import framework.webPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;

	@Before()
	public static void before() {
		ConfigReader configReader = new ConfigReader();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\workspace\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
		driver = new ChromeDriver();
		driver.get(configReader.getUrl());
	}

	@After()
	public static void after(Scenario scenario) {
		if(scenario.isFailed()) {
			BasePage.takeScreenSHot(scenario.getName());
		}
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
