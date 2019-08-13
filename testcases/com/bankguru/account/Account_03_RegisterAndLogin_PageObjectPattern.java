package com.bankguru.account;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_03_RegisterAndLogin_PageObjectPattern {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "binvnese" + randomDataTest() + "@gmail.com";

		driver.get("http://demo.guru99.com/v4/");
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);

		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPage.clickToHereLink();
		registerPage.inputToEmailTetxt(email);
		registerPage.clickToSubmitButton();
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		registerPage.openLoginPageUrl(loginPageUrl);
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

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
