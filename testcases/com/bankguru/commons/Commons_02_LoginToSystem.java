

package com.bankguru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Commons_02_LoginToSystem extends AbstractTest {

	WebDriver driver;
	public static String USERNAME, PASSWORD;
	String email, loginPageUrl;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	DepositPageObject depositPage;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("LOGIN - STEP 1: Input username");
		loginPage.inputToUsernameTextbox(Constants.LOGIN_USERNAME);

		log.info("LOGIN - STEP 2: Input password");
		loginPage.inputToPasswordTextbox(Constants.LOGIN_PASSWORD);

		log.info("LOGIN - STEP 3: Click Button");
		homePage = loginPage.clickToLoginButton();

		log.info("LOGIN - STEP 4: Verify Welcome Msg displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		verifyTrue(homePage.isUserIDDisplayed(Constants.LOGIN_USERNAME));
		closeBrowserAndDriver(driver);
	}


	


}
