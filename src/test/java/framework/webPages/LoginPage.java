package framework.webPages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

	private By pageHeader = By.xpath("//*[@id='content']/div/div/div[1]/span");

	public String getPageHeader() {
		waitTobeVisible(pageHeader);
		return getTextFromElement(pageHeader);
	}
}
