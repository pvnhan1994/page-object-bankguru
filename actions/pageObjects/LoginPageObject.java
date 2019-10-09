package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	 WebDriver driver;
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	public boolean isLoginPageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		return isControlDisplayed(driver, LoginPageUI.USER_ID_TEXTBOX);
	}
	public boolean isHomePageUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.WELCOME_MSG_AT_HOME_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.WELCOME_MSG_AT_HOME_PAGE);
	}
	public boolean isRegisterPageUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
	}
	
	public boolean isDeleteCustomerFormLinkUnDisplayed() {
		waitForElementInvisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM);
		return isControlUndisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM);
	}
	public void clickSeleniumToogle() {
		waitForElementVisible(driver, LoginPageUI.SELENIUM_TOOGLE);
		clickToElement(driver, LoginPageUI.SELENIUM_TOOGLE);
	}
	public boolean isDeleteCustomerFormLinkDisplayed() {
		waitForElementVisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM);
		return isControlDisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM);
	}
	public String get(String name) {
		waitForElementVisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM);
		return getAttributeValue(driver, LoginPageUI.DELETE_CUSTOMER_FORM, name);
	}

}
