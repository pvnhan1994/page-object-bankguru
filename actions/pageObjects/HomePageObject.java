package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	 WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public void clickNewCustomer() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
	}
	public boolean isWelcomeMessageDisplayed(String expected) {
		String actual = getTextElement(driver,HomePageUI.WELCOME_MESSAGE_TEXT);
		return actual.equals(expected);
	}

	public boolean isUserIDDisplayed(String expected) {
		String actual = getTextElement(driver,HomePageUI.USERID_TEXT);
		return actual.contains(expected);
	}
	
	

}
