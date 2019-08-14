package com.bankguru.validation;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.NewCustomerPageObject;

public class Validation_01_NewCustomer {
	WebDriver driver;
	String email;
	NewCustomerPageObject newCustomerPage;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		newCustomerPage = new NewCustomerPageObject(driver);
		email = "binvnese" + randomDataTest() + "@gmail.com";
		driver.get("http://demo.guru99.com/v4/manager/addcustomerpage.php");
	}

	@Test
	public void TC_01_NameCannotBeEmpty() {
		newCustomerPage.sendKeyTabToCustomerName();
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameMustNotBeBlank());
	}

	@Test
	public void TC_02_NameCannotBeNumeric() throws Exception {
		newCustomerPage.inputToCustomerNameTextbox("1234");
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameCannotBeNumeric());
		newCustomerPage.clearDataCustomerNameTextbox();
		newCustomerPage.inputToCustomerNameTextbox("1234");
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameCannotBeNumeric());
	}
	@Test
	public void TC_03_NameCannotHaveSpecialChars() {
		newCustomerPage.clearDataCustomerNameTextbox();
		newCustomerPage.inputToCustomerNameTextbox("@#");
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());
		newCustomerPage.clearDataCustomerNameTextbox();
		newCustomerPage.inputToCustomerNameTextbox("abc#@");
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());
	}
	@Test
	public void TC_04_NameCannotHaveFirstCharsAsBlankSpace() {
		newCustomerPage.clearDataCustomerNameTextbox();
		newCustomerPage.inputToCustomerNameTextbox(" ");
		Assert.assertTrue(newCustomerPage.ValidateCustomerNameCannotHaveFirstCharAsBlankSpace());
	}
	@Test
	public void TC_05_AddressCannotBeEmpty() {
		newCustomerPage.sendKeyTabToAddress();
		Assert.assertTrue(newCustomerPage.ValidateAddressCannotBeEmpty());
	}
	@Test
	public void TC_06_AddressCannotHaveFirstCharsAsBlankSpace() {
		newCustomerPage.inputToAddressTextarea(" ");
		Assert.assertTrue(newCustomerPage.ValidateAddressCannotHaveFirstCharAsBlankSpace());
	}
	@Test
	public void TC_08_CityCannotBeEmpty() {
		newCustomerPage.sendKeyTabToCity();
		Assert.assertTrue(newCustomerPage.ValidateCityCannotBeEmpty());
	}
	@Test
	public void TC_09_CityCannotBeNumeric() {
		newCustomerPage.inputToCityTextbox("1234");
		Assert.assertTrue(newCustomerPage.ValidateCityCannotBeNumeric());
		newCustomerPage.clearDataCityTextbox();
		newCustomerPage.inputToCityTextbox("city1234");
		Assert.assertTrue(newCustomerPage.ValidateCityCannotBeNumeric());
	}
	@Test
	public void TC_10_CityCannotHaveSpecialChars() {
		newCustomerPage.clearDataCityTextbox();
		newCustomerPage.inputToCityTextbox("@#");
		Assert.assertTrue(newCustomerPage.ValidateCityCannotHaveSpecicalChars());
		newCustomerPage.clearDataCustomerNameTextbox();
		newCustomerPage.inputToCityTextbox("abc#@");
		Assert.assertTrue(newCustomerPage.ValidateCityCannotHaveSpecicalChars());
	}
	@Test
	public void TC_11_CityCannotHaveFirstBlankSpace() {
		newCustomerPage.clearDataCityTextbox();
		newCustomerPage.inputToCityTextbox(" ");
		Assert.assertTrue(newCustomerPage.ValidateCityCannotHaveFirstCharAsBlankSpace());
	}
	@Test
	public void TC_12_StateCannotBeEmpty() {
		newCustomerPage.sendKeyTabToState();
		Assert.assertTrue(newCustomerPage.ValidateStateCannotBeEmpty());
	}
	@Test
	public void TC_13_StateCannotBeNumeric() {
		newCustomerPage.inputToStateTextbox("1234");
		Assert.assertTrue(newCustomerPage.ValidateStateCannotBeNumeric());
		newCustomerPage.clearDataStateTextbox();
		newCustomerPage.inputToStateTextbox("state1234");
		Assert.assertTrue(newCustomerPage.ValidateStateCannotBeNumeric());
	}
	@Test
	public void TC_14_StateCannotHaveSpecialChars() {
		newCustomerPage.clearDataStateTextbox();
		newCustomerPage.inputToStateTextbox("@#");
		Assert.assertTrue(newCustomerPage.ValidateStateCannotHaveSpecicalChars());
		newCustomerPage.clearDataStateTextbox();
		newCustomerPage.inputToStateTextbox("abc#@");
		Assert.assertTrue(newCustomerPage.ValidateStateCannotHaveSpecicalChars());
	}
	@Test
	public void TC_15_StateCannotHaveFirstBlankSpace() {
		newCustomerPage.clearDataStateTextbox();
		newCustomerPage.inputToStateTextbox(" ");
		Assert.assertTrue(newCustomerPage.ValidateStateCannotHaveFirstCharAsBlankSpace());
	}
	@Test
	public void TC_16_PinMustBeNumeric() {
		newCustomerPage.inputToPinTextbox("abc");
		Assert.assertTrue(newCustomerPage.ValidatePinMustBeNumberic());
		
	}
	@Test
	public void TC_17_PinCannotBeEmpty() {
		newCustomerPage.clearDataPinTextbox();
		newCustomerPage.sendKeyTabToPin();
		Assert.assertTrue(newCustomerPage.ValidatePinCannotBeEmpty());
	}
	@Test
	public void TC_18_PinMustHave6Digits() {
		newCustomerPage.inputToPinTextbox("123");
		Assert.assertTrue(newCustomerPage.ValidatePinMustHave6Digits());
	}
	@Test
	public void TC_19_PinCannotHaveSpecialChars() {
		newCustomerPage.clearDataPinTextbox();
		newCustomerPage.inputToPinTextbox("12#3");
		Assert.assertTrue(newCustomerPage.ValidatePinCannotHaveSpecialChars());
	}
	@Test
	public void TC_20_PinCannotHaveFirstBlankSpace() {
		newCustomerPage.clearDataPinTextbox();
		newCustomerPage.inputToPinTextbox(" 123");
		Assert.assertTrue(newCustomerPage.ValidatePinCannotHaveFirstBlankSpace());
	}
//	@Test
//	public void TC_21_PinCannotHaveBlankSpace() {
//
//	}
	@Test
	public void TC_22_TelephoneCannotBeEmpty() {
		newCustomerPage.sendKeyTabToTelephone();
		Assert.assertTrue(newCustomerPage.ValidateTelephoneCannotBeEmpty());
	}
	@Test
	public void TC_23_TelephoneCannotHaveFirstCharsAsBlankSpace() {
		newCustomerPage.inputToMobilePhoneTextbox(" 123");
		Assert.assertTrue(newCustomerPage.ValidateTelephoneCannotHaveFirstBlankSpace());
	}
	@Test
	public void TC_24_TelephoneCannotHaveSpaces() {
		newCustomerPage.clearDataTelephoneTextbox();
		newCustomerPage.inputToMobilePhoneTextbox("123 123");
		Assert.assertTrue(newCustomerPage.ValidateTelephoneCannotHaveSpace());
	}
	@Test
	public void TC_25_TelephoneCannotHaveSpecialCharacter() {
		newCustomerPage.clearDataTelephoneTextbox();
		newCustomerPage.inputToMobilePhoneTextbox("123&&123");
		Assert.assertTrue(newCustomerPage.ValidateTelephoneCannotHaveSpecialCharacter());
	}
	@Test
	public void TC_26_EmailCannotBeEmpty() {
		newCustomerPage.sendKeyTabToEmail();
		Assert.assertTrue(newCustomerPage.ValidateEmailCannotBeEmpty());
	}
	@Test
	public void TC_27_EmailMustBeInCorrectFormat() {
		newCustomerPage.clearDataEmailTextbox();
		newCustomerPage.inputToEmailCustomerTextbox("guru@gmal");
		Assert.assertTrue(newCustomerPage.ValidateEmailMustBeInCorrectFormat());
	}
	@Test
	public void TC_29_EmailCannotHaveSpace() {
		newCustomerPage.inputToEmailCustomerTextbox("gu ru@ gmal  ");
		Assert.assertTrue(newCustomerPage.ValidateEmailMustBeInCorrectFormat());
	}
	@Test
	public void TC_30_CheckAllFieldsName() {

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
