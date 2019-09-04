

package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_08_RegisterAndLogin_DynamicLocator_RestParamerter extends AbstractTest {

	WebDriver driver;
	String email, username, password, loginPageUrl;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	DepositPageObject depositPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = openMultiBrowser(browserName);
		
		email = "binvnese" + randomDataTest() + "@gmail.com";
		
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageUrl = loginPage.getLoginPageUrl();
		//login >> register
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTetxt(email);
		registerPage.clickToSubmitButton();
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		//register >> login
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		//login >> homepage
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		Assert.assertTrue(homePage.isUserIDDisplayed(username));
	}
	@Test
	public void TC_03_WebDriverCycle() throws Exception {
		//homepage >> newaccount 
		newAccountPage = (NewAccountPageObject) homePage.openMultiPage(driver, "New Account");
		Thread.sleep(1000);
		//newaccount >> editaccount
		//editAccountPage = newAccountPage.openEditAccountPage(driver);
		editAccountPage = (EditAccountPageObject) newAccountPage.openMultiPage(driver, "Edit Account");
		Thread.sleep(1000);
		//editaccount >> homepage 
		homePage = (HomePageObject) editAccountPage.openMultiPage(driver, "Manager");
		Thread.sleep(1000);
		//homepage >> deposit
		
	}
	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
