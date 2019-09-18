

package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Commons_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_11_RegisterAndLogin_ShareState extends AbstractTest {

	WebDriver driver;
	
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
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("LOGIN - STEP 1: Input username");
		loginPage.inputToUsernameTextbox(Commons_01_RegisterToSystem.USERNAME);
	
		log.info("LOGIN - STEP 2: Input password");
		loginPage.inputToPasswordTextbox(Commons_01_RegisterToSystem.PASSWORD);
		
		log.info("LOGIN - STEP 3: Click Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("LOGIN - STEP 4: Verify Welcome Msg displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		log.info("LOGIN - STEP 5: Verify USERID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(Commons_01_RegisterToSystem.USERNAME));
	
	}


	@Test
	public void TC_02_LoginToSystem() {
	}
	
	@Test
	public void TC_03_LoginToSystem() {
	}
	@Test
	public void TC_04_LoginToSystem() {
	}
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
