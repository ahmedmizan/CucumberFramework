package framework.webPages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");


	public void clickOnLoginButton() {
		waitForClickable(loginButton);
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}

	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}





}
