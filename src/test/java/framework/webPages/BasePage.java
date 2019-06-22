package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public boolean isElementEnabled(By locator) {
		return webAction(locator).isEnabled();
	}

	public void selectFromCalendar(By monthNameLocator,String expectedMonthText,By arraySignLocator,By allDaysLocatorOfMonth){

		while (true) {

			String text = SharedSD.getDriver().findElement( monthNameLocator ).getText();

			if (text.equals( expectedMonthText ))
			{
				break;

			}
			else
			{
				SharedSD.getDriver().findElement( arraySignLocator ).click();

			}
		}
		SharedSD.getDriver().findElement( allDaysLocatorOfMonth ).click();

	}


	public void selectFromMenuList(By allMenuListLocator,String IndivisualMenuText){
		List<WebElement> list = SharedSD.getDriver().findElements(allMenuListLocator);
		for (WebElement ele : list) {
			if (ele.getText().contains(IndivisualMenuText)) {
				ele.click();
				break;
			}
		}
	}

	public void autoComplete(By destinationFieldLocator, String cityName, By suggestedCities, String finalDestination){
		setValue( destinationFieldLocator , cityName);
		List<WebElement> list = SharedSD.getDriver().findElements(suggestedCities);
		for (WebElement ele : list) {
			if(ele.getText().contains(finalDestination)) {
				ele.click();
				break;
			}
		}
	}

	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		WebElement element = SharedSD.getDriver().findElement(locator);
		js.executeScript("arguments[0].scroolIntoView(true);" , element);
	}



}
