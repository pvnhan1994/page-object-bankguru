package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Commons_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Validation_01_NewCustomer extends AbstractTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;

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
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		log.info("LOGIN - STEP 5: Verify USERID displayed");
		verifyTrue(homePage.isUserIDDisplayed(Commons_01_RegisterToSystem.USERNAME));

		log.info("LOGIN - STEP 6: Open New Customer");
		newCustomerPage = homePage.clickNewCustomer();

	}

	@Test
	public void TC_01_NameCannotBeEmpty() {

		log.info("NEW CUSTOMER - NAME - STEP 1: Press Tab and move to next Field");
		newCustomerPage.sendKeyTabToCustomerName();

		log.info("NEW CUSTOMER - NAME - STEP 2: Verify Customer name must not be blank is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameMustNotBeBlank());
	}

	@Test
	public void TC_02_NameCannotBeNumeric() throws Exception {
		log.info("NEW CUSTOMER - NAME - STEP 1: Input numberic value in Name Field");
		newCustomerPage.inputToCustomerNameTextbox("1234");

		log.info("NEW CUSTOMER - NAME - STEP 2: Verify Numbers are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameCannotBeNumeric());

		log.info("NEW CUSTOMER - NAME - STEP 3: Clear data in Name Field");
		newCustomerPage.clearDataCustomerNameTextbox();

		log.info("NEW CUSTOMER - NAME - STEP 4: Input numberic value in Name Field");
		newCustomerPage.inputToCustomerNameTextbox("1234");

		log.info("NEW CUSTOMER - NAME - STEP 5: Verify Numbers are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameCannotBeNumeric());
	}

	@Test
	public void TC_03_NameCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - NAME -  STEP 1: Clear data in Name Field");
		newCustomerPage.clearDataCustomerNameTextbox();

		log.info("NEW CUSTOMER - NAME -  STEP 2: Input special chars into Name Field");
		newCustomerPage.inputToCustomerNameTextbox("@#");

		log.info("NEW CUSTOMER - NAME - STEP 3: Verify Special chars are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());

		log.info("NEW CUSTOMER - NAME - STEP 4: Clear data in Name Field");
		newCustomerPage.clearDataCustomerNameTextbox();

		log.info("NEW CUSTOMER - NAME - STEP 5: Input special chars into Name Field");
		newCustomerPage.inputToCustomerNameTextbox("abc#@");

		log.info("NEW CUSTOMER - NAME - STEP 6: Verify Special chars are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameCannotHaveSpecicalChars());
	}

	@Test
	public void TC_04_NameCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - NAME - STEP 1: Clear data in Name Field");
		newCustomerPage.clearDataCustomerNameTextbox();

		log.info("NEW CUSTOMER - NAME - STEP 2: Dont input into Name Field");
		newCustomerPage.inputToCustomerNameTextbox(" ");

		log.info("NEW CUSTOMER - NAME - STEP 3: Verify First chars cannot be space is displayed");
		verifyTrue(newCustomerPage.ValidateCustomerNameCannotHaveFirstCharAsBlankSpace());
	}

	@Test
	public void TC_05_AddressCannotBeEmpty() {
		log.info("NEW CUSTOMER - ADDRESS - STEP 1: Dont input data into Address");
		newCustomerPage.sendKeyTabToAddress();

		log.info("NEW CUSTOMER - ADDRESS - STEP 2: Verify Address cannot be empty is displayed");
		verifyTrue(newCustomerPage.ValidateAddressCannotBeEmpty());
	}

	@Test
	public void TC_06_AddressCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - ADDRESS - STEP 1: Input Fisrt chars as blank space");
		newCustomerPage.inputToAddressTextarea(" ");

		log.info("NEW CUSTOMER - ADDRESS - STEP 2: Verify First chars cannot be space is displayed");
		verifyTrue(newCustomerPage.ValidateAddressCannotHaveFirstCharAsBlankSpace());
	}

	@Test
	public void TC_08_CityCannotBeEmpty() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Dont input data into City Field");
		newCustomerPage.sendKeyTabToCity();

		log.info("NEW CUSTOMER - CITY - STEP 2: Verify City Field must be not blank");
		verifyTrue(newCustomerPage.ValidateCityCannotBeEmpty());
	}

	@Test
	public void TC_09_CityCannotBeNumeric() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Input numberic into City Field");
		newCustomerPage.inputToCityTextbox("1234");

		log.info("NEW CUSTOMER - CITY - STEP 2: Verify Numbers are not allowed");
		verifyTrue(newCustomerPage.ValidateCityCannotBeNumeric());

		log.info("NEW CUSTOMER - CITY - STEP 3: Clear data in Name Field");
		newCustomerPage.clearDataCityTextbox();

		log.info("NEW CUSTOMER - CITY - STEP 4: Input numberic into City Field");
		newCustomerPage.inputToCityTextbox("city1234");

		log.info("NEW CUSTOMER - CITY - STEP 5: Verify Numbers are not allowed");
		verifyTrue(newCustomerPage.ValidateCityCannotBeNumeric());
	}

	@Test
	public void TC_10_CityCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Clear data in Ctiy Field");
		newCustomerPage.clearDataCityTextbox();

		log.info("NEW CUSTOMER - CITY - STEP 2: Input special chars into City Field");
		newCustomerPage.inputToCityTextbox("@#");

		log.info("NEW CUSTOMER - CITY - STEP 3: Verify Special chars are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCityCannotHaveSpecicalChars());

		log.info("NEW CUSTOMER - CITY - STEP 4: Clear data in City Field");
		newCustomerPage.clearDataCustomerNameTextbox();

		log.info("NEW CUSTOMER - CITY - STEP 5: Input special chars into City Field");
		newCustomerPage.inputToCityTextbox("abc#@");

		log.info("NEW CUSTOMER - CITY - STEP 6: Verify Special chars are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateCityCannotHaveSpecicalChars());
	}

	@Test
	public void TC_11_CityCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Clear data in Ctiy Field");
		newCustomerPage.clearDataCityTextbox();

		log.info("NEW CUSTOMER - CITY - STEP 2: Input data hava first Blank Space");
		newCustomerPage.inputToCityTextbox(" ");

		log.info("NEW CUSTOMER - CITY - STEP 3: Verify First character cannot be space");
		verifyTrue(newCustomerPage.ValidateCityCannotHaveFirstCharAsBlankSpace());
	}

	@Test
	public void TC_12_StateCannotBeEmpty() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Dont input data into State Field");
		newCustomerPage.sendKeyTabToState();

		log.info("NEW CUSTOMER - STATE - STEP 2: Verify State must not be blank");
		verifyTrue(newCustomerPage.ValidateStateCannotBeEmpty());
	}

	@Test
	public void TC_13_StateCannotBeNumeric() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Input number into State Field");
		newCustomerPage.inputToStateTextbox("1234");

		log.info("NEW CUSTOMER - STATE - STEP 2: Verify Numbers are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateStateCannotBeNumeric());

		log.info("NEW CUSTOMER - STATE - STEP 3: Clear data in State Field");
		newCustomerPage.clearDataStateTextbox();

		log.info("NEW CUSTOMER - STATE - STEP 4: Input number into State Field");
		newCustomerPage.inputToStateTextbox("state1234");

		log.info("NEW CUSTOMER - STATE - STEP 5: Verify Numbers are not allowed is displayed");
		verifyTrue(newCustomerPage.ValidateStateCannotBeNumeric());
	}

	@Test
	public void TC_14_StateCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDataStateTextbox();

		log.info("NEW CUSTOMER - STATE - STEP 2: Input Special Chras into State Field");
		newCustomerPage.inputToStateTextbox("@#");

		log.info("NEW CUSTOMER - STATE - STEP 3: Verify State cannot have special chars is displayed");
		verifyTrue(newCustomerPage.ValidateStateCannotHaveSpecicalChars());

		log.info("NEW CUSTOMER - STATE - STEP 4: Clear data in State Field");
		newCustomerPage.clearDataStateTextbox();

		log.info("NEW CUSTOMER - STATE - STEP 5: Input Special Chras into State Field");
		newCustomerPage.inputToStateTextbox("abc#@");

		log.info("NEW CUSTOMER - STATE - STEP 6:  Verify State cannot have special chars is displayed");
		verifyTrue(newCustomerPage.ValidateStateCannotHaveSpecicalChars());
	}

	@Test
	public void TC_15_StateCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDataStateTextbox();

		log.info("NEW CUSTOMER - STATE - STEP 2: Input First blank space into State Field");
		newCustomerPage.inputToStateTextbox(" ");

		log.info("NEW CUSTOMER - STATE - STEP 3: Verify State cannot have first blank space");
		verifyTrue(newCustomerPage.ValidateStateCannotHaveFirstCharAsBlankSpace());
	}

	@Test
	public void TC_16_PinMustBeNumeric() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Input not number into Pin Field");
		newCustomerPage.inputToPinTextbox("abc");

		log.info("NEW CUSTOMER - PIN - STEP 2: Verify Pin must be numberic is displayed");
		verifyTrue(newCustomerPage.ValidatePinMustBeNumberic());

	}

	@Test
	public void TC_17_PinCannotBeEmpty() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDataPinTextbox();

		log.info("NEW CUSTOMER - PIN - STEP 2: Dont input data into Pin Field");
		newCustomerPage.sendKeyTabToPin();

		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannot be Empty is displayed");
		verifyTrue(newCustomerPage.ValidatePinCannotBeEmpty());
	}

	@Test
	public void TC_18_PinMustHave6Digits() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Input less than 6 digits into Pin Field");
		newCustomerPage.inputToPinTextbox("123");

		log.info("NEW CUSTOMER - PIN - STEP 2: Verify Pin must have 6 digits is displayed");
		verifyTrue(newCustomerPage.ValidatePinMustHave6Digits());
	}

	@Test
	public void TC_19_PinCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDataPinTextbox();

		log.info("NEW CUSTOMER - PIN - STEP 2: Input special chars into Pin Field");
		newCustomerPage.inputToPinTextbox("12#3");

		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannt have special chars");
		verifyTrue(newCustomerPage.ValidatePinCannotHaveSpecialChars());
	}

	@Test
	public void TC_20_PinCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDataPinTextbox();

		log.info("NEW CUSTOMER - PIN - STEP 2: Input first blank space into Pin Field");
		newCustomerPage.inputToPinTextbox(" 123");

		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannot have first blank space");
		verifyTrue(newCustomerPage.ValidatePinCannotHaveFirstBlankSpace());
	}

	@Test
	public void TC_22_TelephoneCannotBeEmpty() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Dont input data into Telephone");
		newCustomerPage.sendKeyTabToTelephone();

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Verify Telephone cannot be empty");
		verifyTrue(newCustomerPage.ValidateTelephoneCannotBeEmpty());
	}

	@Test
	public void TC_23_TelephoneCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Input first blank space into Telephone Field");
		newCustomerPage.inputToMobilePhoneTextbox(" 123");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Verify Telephone cannot have first blank space");
		verifyTrue(newCustomerPage.ValidateTelephoneCannotHaveFirstBlankSpace());
	}

	@Test
	public void TC_24_TelephoneCannotHaveSpaces() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Clear data in Telephone Field");
		newCustomerPage.clearDataTelephoneTextbox();

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Input data have spaces into Telephone Field");
		newCustomerPage.inputToMobilePhoneTextbox("123 123");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 3: Verify Telephone cannot have spaces");
		verifyTrue(newCustomerPage.ValidateTelephoneCannotHaveSpace());
	}

	@Test
	public void TC_25_TelephoneCannotHaveSpecialCharacter() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDataTelephoneTextbox();

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Clear data in State Field");
		newCustomerPage.inputToMobilePhoneTextbox("123&&123");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 3: Clear data in State Field");
		verifyTrue(newCustomerPage.ValidateTelephoneCannotHaveSpecialCharacter());

	}

	@Test
	public void TC_26_EmailCannotBeEmpty() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Dont input data into Email Field");
		newCustomerPage.sendKeyTabToEmail();

		log.info("NEW CUSTOMER - EMAIL - STEP 2: Verify email cannot be empty is displayed");
		verifyTrue(newCustomerPage.ValidateEmailCannotBeEmpty());
	}

	@Test
	public void TC_27_EmailMustBeInCorrectFormat() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Clear data in Email Field");
		newCustomerPage.clearDataEmailTextbox();

		log.info("NEW CUSTOMER - EMAIL - STEP 2: Input invalid email into Email Field");
		newCustomerPage.inputToEmailCustomerTextbox("guru@gmal");

		log.info("NEW CUSTOMER - EMAIL - STEP 3: Verify Email must be in correct format is displayed");
		verifyTrue(newCustomerPage.ValidateEmailMustBeInCorrectFormat());
	}

	@Test
	public void TC_29_EmailCannotHaveSpace() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Input data have space into Mail");
		newCustomerPage.inputToEmailCustomerTextbox("gu ru@ gmal  ");

		log.info("NEW CUSTOMER - EMAIL - STEP 2: Verify Email cannot have space is displayed");
		verifyTrue(newCustomerPage.ValidateEmailMustBeInCorrectFormat());
	}

	@AfterClass
	public void afterClass() {

		closeBrowserAndDriver(driver);
	}

}
