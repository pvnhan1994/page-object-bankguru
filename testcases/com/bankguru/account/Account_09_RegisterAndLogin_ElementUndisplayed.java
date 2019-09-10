

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

public class Account_09_RegisterAndLogin_ElementUndisplayed extends AbstractTest {

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
		System.out.println("REGISTER - STEP: 1.1 Verify login page is displayed");
		Assert.assertTrue(loginPage.isLoginPageDisplayed());

		System.out.println("REGISTER - STEP: 1.2.1 Verify delete customer form is not displayed");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkUnDisplayed());

		System.out.println("REGISTER - STEP: 1.2.2 Click Selenium toogle");
		loginPage.clickSeleniumToogle();
		
		System.out.println("REGISTER - STEP: 1.2.3 Verify delete customer form is displayed");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
		
		System.out.println("REGISTER - STEP: 2 Verify Home Page is not displayed");
		Assert.assertTrue(loginPage.isHomePageUndisplayed());

		System.out.println("REGISTER - STEP: 2 Verify Register Page is not displayed");
		Assert.assertTrue(loginPage.isRegisterPageUndisplayed());
		
		
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
