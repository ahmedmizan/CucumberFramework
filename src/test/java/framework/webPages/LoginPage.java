package framework.webPages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

//	private By pageHeader = By.xpath("//*[@id='content']/div/div/div[1]/span");
    private By errorMsg  =By.xpath("//div[text()='The email you’ve entered doesn’t match any account. ']");
	public String getPageHeader() {
		waitTobeVisible(errorMsg);
		return getTextFromElement(errorMsg);
	}
}
