

package com.bankguru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Commons_01_RegisterToSystem extends AbstractTest {

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
		email = "binvnese" + randomDataTest() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("REGISTER - STEP: 1 Verify login page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());

		
		log.info("REGISTER - STEP: 2 Click to HERE LINK");
		registerPage = loginPage.clickToHereLink();
		
		log.info("REGISTER - STEP: 3 Input to Email ID Textbox");
		registerPage.inputToEmailTetxt(email);
		
		log.info("REGISTER - STEP: 4 Click to Submit button");
		registerPage.clickToSubmitButton();

		log.info("REGISTER - STEP: 5 Get username/ password infor");		
		USERNAME = registerPage.getUsernameInformation();
		PASSWORD = registerPage.getPasswordInformation();
	
		driver.quit();
	}


	


}
