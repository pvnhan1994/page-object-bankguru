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
		//newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
	}

	@Test
	public void TC_01_NameCannotBeEmpty(){
		
		log.info("NEW CUSTOMER - NAME - STEP 1: Press Tab and move to next Field");
		newCustomerPage.pressTABToDynamicTextbox(driver, "name");

		log.info("NEW CUSTOMER - NAME - STEP 2: Verify Customer name must not be blank is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), "Customer name must not be blank");
	}

	@Test
	public void TC_02_NameCannotBeNumeric() throws Exception {
		log.info("NEW CUSTOMER - NAME - STEP 1: Input numberic value in Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "1233");

		log.info("NEW CUSTOMER - NAME - STEP 2: Verify Numbers are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), "Numbers are not allowed");

		log.info("NEW CUSTOMER - NAME - STEP 3: Clear data in Name Field");
		newCustomerPage.clearDynamicTextbox(driver, "name");

		log.info("NEW CUSTOMER - NAME - STEP 4: Input numberic value in Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "12as33");

		log.info("NEW CUSTOMER - NAME - STEP 5: Verify Numbers are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), "Numbers are not allowed");
	}

	@Test
	public void TC_03_NameCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - NAME -  STEP 1: Clear data in Name Field");
		newCustomerPage.clearDynamicTextbox(driver, "name");

		log.info("NEW CUSTOMER - NAME -  STEP 2: Input special chars into Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "#@#@!");

		log.info("NEW CUSTOMER - NAME - STEP 3: Verify Special chars are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"),
				"Special characters are not allowed");

		log.info("NEW CUSTOMER - NAME - STEP 4: Clear data in Name Field");
		newCustomerPage.clearDynamicTextbox(driver, "name");

		log.info("NEW CUSTOMER - NAME - STEP 5: Input special chars into Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "dsa@#@");

		log.info("NEW CUSTOMER - NAME - STEP 6: Verify Special chars are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"),
				"Special characters are not allowed");
	}

	@Test
	public void TC_04_NameCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - NAME - STEP 1: Clear data in Name Field");
		newCustomerPage.clearDynamicTextbox(driver, "name");

		log.info("NEW CUSTOMER - NAME - STEP 2: Dont input into Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "   ");

		log.info("NEW CUSTOMER - NAME - STEP 3: Verify First chars cannot be space is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"),
				"First character can not have space");
	}

	@Test
	public void TC_05_AddressCannotBeEmpty() {
		log.info("NEW CUSTOMER - ADDRESS - STEP 1: Dont input data into Address");
		newCustomerPage.pressTABToDynamicTextArea(driver, "addr");

		log.info("NEW CUSTOMER - ADDRESS - STEP 2: Verify Address cannot be empty is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"),"Address Field must not be blank");
	}

	@Test
	public void TC_06_AddressCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - ADDRESS - STEP 1: Input Fisrt chars as blank space");
		newCustomerPage.inputToDynamicTextArea(driver, "addr", " ");

		log.info("NEW CUSTOMER - ADDRESS - STEP 2: Verify First chars cannot be space is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"),"First character can not have space");
	}

	@Test
	public void TC_08_CityCannotBeEmpty() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Dont input data into City Field");
		newCustomerPage.pressTABToDynamicTextbox(driver, "city");

		log.info("NEW CUSTOMER - CITY - STEP 2: Verify City Field must be not blank");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"City Field must not be blank");
	}

	@Test
	public void TC_09_CityCannotBeNumeric() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Input numberic into City Field");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "123");

		log.info("NEW CUSTOMER - CITY - STEP 2: Verify Numbers are not allowed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"Numbers are not allowed");

		log.info("NEW CUSTOMER - CITY - STEP 3: Clear data in Name Field");
		newCustomerPage.clearDynamicTextbox(driver, "city");

		log.info("NEW CUSTOMER - CITY - STEP 4: Input numberic into City Field");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "abc123");

		log.info("NEW CUSTOMER - CITY - STEP 5: Verify Numbers are not allowed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"Numbers are not allowed");
	}

	@Test
	public void TC_10_CityCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Clear data in Ctiy Field");
		newCustomerPage.clearDynamicTextbox(driver, "city");

		log.info("NEW CUSTOMER - CITY - STEP 2: Input special chars into City Field");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "#$@#");
		
		log.info("NEW CUSTOMER - CITY - STEP 3: Verify Special chars are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"Special characters are not allowed");

		log.info("NEW CUSTOMER - CITY - STEP 4: Clear data in City Field");
		newCustomerPage.clearDynamicTextbox(driver, "city");

		log.info("NEW CUSTOMER - CITY - STEP 5: Input special chars into City Field");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "city&*#");

		log.info("NEW CUSTOMER - CITY - STEP 6: Verify Special chars are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"Special characters are not allowed");
	}

	@Test
	public void TC_11_CityCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - CITY - STEP 1: Clear data in Ctiy Field");
		newCustomerPage.clearDynamicTextbox(driver, "city");
		
		log.info("NEW CUSTOMER - CITY - STEP 2: Input data hava first Blank Space");
		newCustomerPage.inputToDynamicTextbox(driver, "city", " ");

		log.info("NEW CUSTOMER - CITY - STEP 3: Verify First character cannot be space");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"),"First character can not have space");
	}

	@Test
	public void TC_12_StateCannotBeEmpty() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Dont input data into State Field");
		newCustomerPage.pressTABToDynamicTextbox(driver, "state");

		log.info("NEW CUSTOMER - STATE - STEP 2: Verify State must not be blank");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"State must not be blank");
	}

	@Test
	public void TC_13_StateCannotBeNumeric() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Input number into State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "123");

		log.info("NEW CUSTOMER - STATE - STEP 2: Verify Numbers are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"Numbers are not allowed");

		log.info("NEW CUSTOMER - STATE - STEP 3: Clear data in State Field");
		newCustomerPage.clearDynamicTextbox(driver, "state");

		log.info("NEW CUSTOMER - STATE - STEP 4: Input number into State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "state123");

		log.info("NEW CUSTOMER - STATE - STEP 5: Verify Numbers are not allowed is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"Numbers are not allowed");
	}

	@Test
	public void TC_14_StateCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDataStateTextbox();

		log.info("NEW CUSTOMER - STATE - STEP 2: Input Special Chras into State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "#@!#");

		log.info("NEW CUSTOMER - STATE - STEP 3: Verify State cannot have special chars is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"Special characters are not allowed");

		log.info("NEW CUSTOMER - STATE - STEP 4: Clear data in State Field");
		newCustomerPage.clearDynamicTextbox(driver, "state");

		log.info("NEW CUSTOMER - STATE - STEP 5: Input Special Chras into State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "sate@#!");

		log.info("NEW CUSTOMER - STATE - STEP 6:  Verify State cannot have special chars is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"Special characters are not allowed");
	}

	@Test
	public void TC_15_StateCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - STATE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDynamicTextbox(driver, "state");

		log.info("NEW CUSTOMER - STATE - STEP 2: Input First blank space into State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "state", " ");

		log.info("NEW CUSTOMER - STATE - STEP 3: Verify State cannot have first blank space");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"),"First character can not have space");
	}

	@Test
	public void TC_16_PinMustBeNumeric() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Input not number into Pin Field");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "abc");

		log.info("NEW CUSTOMER - PIN - STEP 2: Verify Pin must be numberic is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "PIN"),"Characters are not allowed");

	}

	@Test
	public void TC_17_PinCannotBeEmpty() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDynamicTextbox(driver, "pinno");

		log.info("NEW CUSTOMER - PIN - STEP 2: TAB out Pin Field");
		newCustomerPage.pressTABToDynamicTextbox(driver, "pinno");
		
		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannot be Empty is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "PIN"),"PIN Code must not be blank");
	}

	@Test
	public void TC_18_PinMustHave6Digits() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Input less than 6 digits into Pin Field");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "123");

		log.info("NEW CUSTOMER - PIN - STEP 2: Verify Pin must have 6 digits is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "PIN"),"PIN Code must have 6 Digits");
	}

	@Test
	public void TC_19_PinCannotHaveSpecialChars() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDynamicTextbox(driver, "pinno");

		log.info("NEW CUSTOMER - PIN - STEP 2: Input special chars into Pin Field");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "@#!");

		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannt have special chars");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "PIN"),"Special characters are not allowed");
	}

	@Test
	public void TC_20_PinCannotHaveFirstBlankSpace() {
		log.info("NEW CUSTOMER - PIN - STEP 1: Clear data in Pin Field");
		newCustomerPage.clearDynamicTextbox(driver, "pinno");

		log.info("NEW CUSTOMER - PIN - STEP 2: Input first blank space into Pin Field");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", " ");

		log.info("NEW CUSTOMER - PIN - STEP 3: Verify Pin cannot have first blank space");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "PIN"),"First character can not have space");
	}

	@Test
	public void TC_22_TelephoneCannotBeEmpty() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Dont input data into Telephone");
		newCustomerPage.pressTABToDynamicTextbox(driver, "telephoneno");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Verify Telephone cannot be empty");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile Number"),"Mobile no must not be blank");
	}

	@Test
	public void TC_23_TelephoneCannotHaveFirstCharsAsBlankSpace() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Input first blank space into Telephone Field");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", " ");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Verify Telephone cannot have first blank space");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile Number"),"First character can not have space");
	}

	@Test
	public void TC_24_TelephoneCannotHaveSpaces() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Clear data in Telephone Field");
		newCustomerPage.clearDynamicTextbox(driver, "telephoneno");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Input data have spaces into Telephone Field");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "123 123");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 3: Verify Telephone cannot have spaces");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile Number"),"Characters are not allowed");
	}

	@Test
	public void TC_25_TelephoneCannotHaveSpecialCharacter() {
		log.info("NEW CUSTOMER - TELEPHONE - STEP 1: Clear data in State Field");
		newCustomerPage.clearDynamicTextbox(driver, "telephoneno");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 2: Clear data in State Field");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "123&123");

		log.info("NEW CUSTOMER - TELEPHONE - STEP 3: Clear data in State Field");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile Number"),"Special characters are not allowed");

	}

	@Test
	public void TC_26_EmailCannotBeEmpty() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Dont input data into Email Field");
		newCustomerPage.pressTABToDynamicTextbox(driver, "emailid");
		
		log.info("NEW CUSTOMER - EMAIL - STEP 2: Verify email cannot be empty is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "E-mail"),"Email-ID must not be blank");
	}

	@Test
	public void TC_27_EmailMustBeInCorrectFormat() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Clear data in Email Field");
		newCustomerPage.clearDynamicTextbox(driver, "emailid");


		log.info("NEW CUSTOMER - EMAIL - STEP 2: Input invalid email into Email Field");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", "guru@gmal");
		
		log.info("NEW CUSTOMER - EMAIL - STEP 3: Verify Email must be in correct format is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "E-mail"),"Email-ID is not valid");
	}

	@Test
	public void TC_29_EmailCannotHaveSpace() {
		log.info("NEW CUSTOMER - EMAIL - STEP 1: Input data have space into Mail");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", "gu ru@ gmal  ");
		
		log.info("NEW CUSTOMER - EMAIL - STEP 2: Verify Email cannot have space is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "E-mail"),"Email-ID is not valid");
	}

	@AfterClass
	public void afterClass() {

		closeBrowserAndDriver(driver);
	}

}
