package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{
	 WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public boolean isWelcomeMessageDisplayed(String expected) {
		String actual = getTextElement(driver,HomePageUI.WELCOME_MESSAGE_TEXT);
		return actual.equals(expected);
	}
	public boolean isUserIDDisplayed(String expected) {
		String actual = getTextElement(driver,HomePageUI.USERID_TEXT);
		return actual.contains(expected);
	}
	public EditCustomerPageObject clickEditCustomer() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}
	public NewCustomerPageObject clickNewCustomer() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}
	

}
