package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_03_RegisterAndLogin_PageObjectPattern {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	String customerNameValue, dateOfBirthValue, addressValue, cityValue;
	String stateValue, pinValue, mobileNumberValue, emailValue, passWordValue, genderValue;
	
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "binvnese" + randomDataTest() + "@gmail.com";
		
		customerNameValue = "Ahmed Geill";
		dateOfBirthValue = "1990-01-01";
		addressValue = "739 Thackeray Parkway";
		cityValue = "Houston";
		stateValue = "Texas";
		genderValue = "male";
		pinValue = "774271";
		mobileNumberValue = "7131676950";
		emailValue = "ageill0@gmail.org";
		passWordValue = "123123";
		
		driver.get("http://demo.guru99.com/v4/");
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);
		newCustomerPage = new NewCustomerPageObject(driver);
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
	@Test
	public void TC_03_AddNewCustomer() throws Exception {
		homePage.clickNewCustomer();
		newCustomerPage.isNewCustomerPageDisplayed();
		newCustomerPage.inputToCustomerNameTextbox(customerNameValue);
		newCustomerPage.selectGender();
		newCustomerPage.inputDoBTextbox(dateOfBirthValue);
		newCustomerPage.inputToAddressTextarea(addressValue);
		newCustomerPage.inputToCityTextbox(cityValue);
		newCustomerPage.inputToStateTextbox(stateValue);
		newCustomerPage.inputToPinTextbox(pinValue);
		newCustomerPage.inputToMobilePhoneTextbox(mobileNumberValue);
		newCustomerPage.inputToEmailCustomerTextbox(emailValue);
		newCustomerPage.inputToPasswordTextbox(passWordValue);
		newCustomerPage.clickToSubmitButton();
		//Thread.sleep(3000);
		Assert.assertEquals(newCustomerPage.getCustomerNameTable(), customerNameValue);
		Assert.assertEquals(newCustomerPage.getGenderTable(),genderValue);
		Assert.assertEquals(newCustomerPage.getDoBTable(),dateOfBirthValue);
		Assert.assertEquals(newCustomerPage.getAddressTable(), addressValue);
		Assert.assertEquals(newCustomerPage.getCityTable(), cityValue);
		Assert.assertEquals(newCustomerPage.getStateTable(), stateValue);
		Assert.assertEquals(newCustomerPage.getPinTable(), pinValue);
		Assert.assertEquals(newCustomerPage.getMobileNumberTable(), mobileNumberValue);

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
