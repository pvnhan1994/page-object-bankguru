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

public class Account_03_RegisterAndLogin_PageObjectPattern{
	WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "binvnese" + randomDataTest() + "@gmail.com";
		//open Bank Guru Application
		driver.get("http://demo.guru99.com/v4/");
		loginPage = new LoginPageObject();
		registerPage = new RegisterPageObject();
		homePage = new HomePageObject();
		//Get login Page Url
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_RegisterToSystem() {
		//Click to Here link
		loginPage.clickToHereLink();
		
		//Input email 
		registerPage.inputToEmailTetxt(email);
		
		//Click submit button
		registerPage.clickToSubmitButton();
		
		//Get username/ password
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		//Open login page
		registerPage.openLoginPageUrl(loginPageUrl);
		
		//Input username/ password
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		//Click button Login
		loginPage.clickToLoginButton();
		
		//Verify 
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed(""));
		
		Assert.assertTrue(homePage.isUserIDDisplayed(""));
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
