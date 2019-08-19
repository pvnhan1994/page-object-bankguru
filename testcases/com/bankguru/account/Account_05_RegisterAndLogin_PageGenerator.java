package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_05_RegisterAndLogin_PageGenerator {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "binvnese" + randomDataTest() + "@gmail.com";
		
		driver.get("http://demo.guru99.com/v4/");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_RegisterToSystem() {
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTetxt(email);
		registerPage.clickToSubmitButton();
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		Assert.assertTrue(homePage.isUserIDDisplayed(username));
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
