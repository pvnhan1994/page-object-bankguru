package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class Validation_02_EditCustomer {
	WebDriver driver;
	String customerID;
	String username, password;
	
	EditCustomerPageObject editCustomerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		username = "mngr216462";
		password = "bYjenug";
		customerID = "51037";
		
		driver.get("http://demo.guru99.com/v4/");
		
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		editCustomerPage = new EditCustomerPageObject(driver);
	}

	@Test
	public void LoginToSystem() {
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
		homePage.clickEditCustomer();
	}

	@Test
	public void NavigateToEditCustomerPage() {
		homePage.clickEditCustomer();
		Assert.assertTrue(editCustomerPage.isTextEditCustomerDisplayed());
	}

	@Test
	public void TC_01_CustomerIDCannotBeEmpty() {
		editCustomerPage.sendKeyTabToCustomerID();
		Assert.assertTrue(editCustomerPage.ValidateCustomerIDCannotBeEmpty());
	}

	@Test
	public void TC_02_CustomerIDMustBeNumeric() {
		editCustomerPage.inputToCustomerIDTextbox("1234abc");
		Assert.assertTrue(editCustomerPage.ValidateCustomerIDMustBeNumeric());
	}

	@Test
	public void TC_03_CustomerIDCannotHaveSpecialCharacter() {
		editCustomerPage.clearDataCustomerIDTextBox();
		editCustomerPage.inputToCustomerIDTextbox("ab##c");
		Assert.assertTrue(editCustomerPage.ValidateCustomerIDCannotHaveSpecialCharacter());
	}

	@Test
	public void TC_04_CustomerIDValid() {
		editCustomerPage.clearDataCustomerIDTextBox();
		editCustomerPage.inputToCustomerIDTextbox(customerID);
		editCustomerPage.clickToSubmitButton();

	}

//	public void TC_05_NameCannotBeEmpty() {
//		editCustomerPage.clearDataCustomerIDTextBox();
//		editCustomerPage.sendKeyTabToCustomerName();
//		Assert.assertTrue(editCustomerPage.ValidateCustomerNameMustNotBeBlank());
//	}
//
//	@Test
//	public void TC_06_NameCannotBeNumeric()   {
//		editCustomerPage.inputToCustomerNameTextbox("1234");
//		Assert.assertTrue(editCustomerPage.ValidateCustomerNameCannotBeNumeric());
//		editCustomerPage.clearDataCustomerIDTextBox();
//		editCustomerPage.inputToCustomerNameTextbox("name1234");
//		Assert.assertTrue(editCustomerPage.ValidateCustomerNameCannotBeNumeric());
//	}
//	@Test
//	public void TC_07_NameCannotHaveSpecialChars() {
//		editCustomerPage.clearDataCustomerIDTextBox();
//		editCustomerPage.inputToCustomerNameTextbox("@#");
//		Assert.assertTrue(editCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());
//		editCustomerPage.clearDataCustomerIDTextBox();
//		editCustomerPage.inputToCustomerNameTextbox("abc#@");
//		Assert.assertTrue(editCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());
//	}
	@Test
	public void TC_08_AddressCannotBeEmpty() {
		editCustomerPage.clearDataAddressTextbox();
		editCustomerPage.sendKeyTabToAddress();
		Assert.assertTrue(editCustomerPage.ValidateAddressCannotBeEmpty());

	}

	@Test
	public void TC_09_CityCannotBeEmpty() {
		editCustomerPage.clearDataCityTextbox();
		editCustomerPage.sendKeyTabToCity();
		Assert.assertTrue(editCustomerPage.ValidateCityCannotBeEmpty());
	}

	@Test
	public void TC_10_CityCannotBeNumeric() {
		editCustomerPage.inputToCityTextbox("1234");
		Assert.assertTrue(editCustomerPage.ValidateCityCannotBeNumeric());
		editCustomerPage.clearDataCityTextbox();
		editCustomerPage.inputToCityTextbox("city1234");
		Assert.assertTrue(editCustomerPage.ValidateCityCannotBeNumeric());

	}

	@Test
	public void TC_11_CityCannotHaveSpecialChars() {
		editCustomerPage.clearDataCityTextbox();
		editCustomerPage.inputToCityTextbox("@#");
		Assert.assertTrue(editCustomerPage.ValidateCityCannotHaveSpecicalChars());
		editCustomerPage.clearDataCityTextbox();
		editCustomerPage.inputToCityTextbox("abc#@");
		Assert.assertTrue(editCustomerPage.ValidateCityCannotHaveSpecicalChars());

	}

	@Test
	public void TC_12_StateCannotBeEmpty() {
		editCustomerPage.clearDataStateTextbox();
		editCustomerPage.sendKeyTabToState();
		Assert.assertTrue(editCustomerPage.ValidateStateCannotBeEmpty());
	}

	@Test
	public void TC_13_StateCannotBeNumeric() {
		editCustomerPage.inputToStateTextbox("1234");
		Assert.assertTrue(editCustomerPage.ValidateStateCannotBeNumeric());
		editCustomerPage.clearDataStateTextbox();
		editCustomerPage.inputToStateTextbox("state1234");
		Assert.assertTrue(editCustomerPage.ValidateStateCannotBeNumeric());
	}

	@Test
	public void TC_14_StateCannotHaveSpecialChars() {
		editCustomerPage.clearDataStateTextbox();
		editCustomerPage.inputToStateTextbox("@#");
		Assert.assertTrue(editCustomerPage.ValidateStateCannotHaveSpecicalChars());
		editCustomerPage.clearDataStateTextbox();
		editCustomerPage.inputToStateTextbox("abc#@");
		Assert.assertTrue(editCustomerPage.ValidateStateCannotHaveSpecicalChars());

	}

	@Test
	public void TC_15_PinCannotBeEmpty() {
		editCustomerPage.clearDataPinTextbox();
		// editCustomerPage.sendKeyTabToPin();
		Assert.assertTrue(editCustomerPage.ValidatePinCannotBeEmpty());
	}

	@Test
	public void TC_16_PinMustBeNumeric() {
		editCustomerPage.inputToPinTextbox("abc");
		Assert.assertTrue(editCustomerPage.ValidatePinMustBeNumberic());

	}

	@Test
	public void TC_17_PinMustHave6Digits() {
		editCustomerPage.clearDataPinTextbox();
		editCustomerPage.inputToPinTextbox("123");
		Assert.assertTrue(editCustomerPage.ValidatePinMustHave6Digits());

	}

	@Test
	public void TC_18_PinCannotHaveSpecialChars() {
		editCustomerPage.clearDataPinTextbox();
		editCustomerPage.inputToPinTextbox("12#3");
		Assert.assertTrue(editCustomerPage.ValidatePinCannotHaveSpecialChars());

	}

	@Test
	public void TC_19_TelephoneCannotBeEmpty() {
		editCustomerPage.clearDataTelephoneTextbox();
		editCustomerPage.sendKeyTabToTelephone();
		Assert.assertTrue(editCustomerPage.ValidateTelephoneCannotBeEmpty());
	}

	@Test
	public void TC_20_TelephoneCannotHaveSpecialCharacter() {
		editCustomerPage.clearDataTelephoneTextbox();
		editCustomerPage.inputToMobilePhoneTextbox("123&&123");
		Assert.assertTrue(editCustomerPage.ValidateTelephoneCannotHaveSpecialCharacter());
	}

	@Test
	public void TC_21_EmailCannotBeEmpty() {
		editCustomerPage.clearDataEmailTextbox();
		editCustomerPage.sendKeyTabToEmail();
		Assert.assertTrue(editCustomerPage.ValidateEmailCannotBeEmpty());
	}

	@Test
	public void TC_22_EmailMustBeInCorrectFormat() {
		editCustomerPage.inputToEmailCustomerTextbox("guru@gmal");
		Assert.assertTrue(editCustomerPage.ValidateEmailMustBeInCorrectFormat());
		editCustomerPage.clearDataEmailTextbox();
		editCustomerPage.inputToEmailCustomerTextbox("32132");
		Assert.assertTrue(editCustomerPage.ValidateEmailMustBeInCorrectFormat());
		editCustomerPage.clearDataEmailTextbox();
		editCustomerPage.inputToEmailCustomerTextbox("guru@gmail@gmail");
		Assert.assertTrue(editCustomerPage.ValidateEmailMustBeInCorrectFormat());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
