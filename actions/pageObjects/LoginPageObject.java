package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	 WebDriver driver;
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
