package framework.webPages;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import stepdefinition.SharedSD;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

	WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), 30);

	// This is the most common wait function used in selenium
	public static WebElement webAction(By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(java.util.NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new  Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) { return driver.findElement(locator); }
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
		WebElement element = webAction(locator);
		Select selectMonth = new Select(element);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement element = webAction(locator);
		Select selectMonth = new Select(element);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public boolean isElementEnabled(By locator) {
		return webAction(locator).isEnabled();
	}



	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		WebElement element = webAction(locator);
		js.executeScript("arguments[0].scroolIntoView(true);" , element);
	}

	public void implcitWait(int second){
		SharedSD.getDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

	public void waitForClickable(By locator){
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitTobeVisible(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void selectDropdownVisibleText(By loc, String text) {
		try {
			Select select = new Select(webAction(loc));
			select.selectByVisibleText(text);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element is not available with locator: " + loc);
			e.printStackTrace();
		}
	}

	public void selectDropdownByValue(By locator, String value) {
		try {
			Select select = new Select(SharedSD.getDriver().findElement(locator));
			select.selectByValue(value);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element is not available with locator: " + locator);
			e.printStackTrace();
		}
	}

	public void selectDropdownByIndex(By locator, int value) {
		try {
			Select select = new Select(SharedSD.getDriver().findElement(locator));
			select.selectByIndex(value);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element is not available with locator: " + locator);
			e.printStackTrace();
		}
	}


	public void mouseOver(By locator) {
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(SharedSD.getDriver().findElement(locator)).perform();
	}

	public void mouseOver(int xOffset, int yOffset) {
		Actions action = new Actions(SharedSD.getDriver());
		action.moveByOffset(xOffset, yOffset).perform();
	}
	//	//int age = (int)price; // Casting
	public static void scrollDownOnPage(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
		jse.executeScript("window.scrollBy(" + x + "," + y +")");
	}

	public void jsClickOn(By value) {
		WebElement element = SharedSD.getDriver().findElement(value);
		JavascriptExecutor executor = (JavascriptExecutor) SharedSD.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void getXoffsetAndYoffset(By locator){
		Point point=  SharedSD.getDriver().findElement(locator).getLocation();
		int xOffset = point.getX();
		int yOffset = point.getY();
		System.out.println("X offset: " + xOffset + " and Y offset: " + yOffset);
	}
	public void dragAndDrop(By locator, By locator1){
		Actions action = new Actions(SharedSD.getDriver());
		WebElement draggable =SharedSD.getDriver().findElement(locator);
		WebElement droppable =SharedSD.getDriver().findElement(locator1);
		action.dragAndDrop(draggable,droppable).build().perform();
	}
	public void simpleAlert(){
		Alert simpleAlert = SharedSD.getDriver().switchTo().alert();
		String alertMsg = SharedSD.getDriver().switchTo().alert().getText();
		SharedSD.getDriver().switchTo().alert().accept();
		SharedSD.getDriver().switchTo().alert().dismiss();
	}

	public void acceptAlert(){
		wait.until(ExpectedConditions.alertIsPresent());
		SharedSD.getDriver().switchTo().alert().accept();
	}

	public static void takeScreenSHot(String fileName){
		TakesScreenshot screenshot = (TakesScreenshot)SharedSD.getDriver();
		File image = screenshot.getScreenshotAs(OutputType.FILE);
		File location = new File("./Screenshots/" + fileName + ".png");
		try {
			FileUtils.copyFile(image,location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
