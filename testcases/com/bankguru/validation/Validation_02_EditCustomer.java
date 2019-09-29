package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Commons_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Validation_02_EditCustomer extends AbstractTest {
	WebDriver driver;
	String customerID;

	EditCustomerPageObject editCustomerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		// mngr225949 ytUrEge
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
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
	
		log.info("CREATE NEW CUSTOMER - STEP 7: Fill valid data in the fields");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "nhanpv");
		newCustomerPage.inputToDynamicTextArea(driver, "addr", "29 ho xuan huong");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", "1994-01-01");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "da nang");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "my an");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "324567");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "0935602450");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", "b123iznvneadsdsaa321@gmal.com");
		newCustomerPage.inputToDynamicTextbox(driver, "password", "123123");


		log.info("CREATE NEW CUSTOMER - STEP 8: Click Submit button");
		newCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("CREATE NEW CUSTOMER - STEP 9: Verify valid data in the fields is displayed");
		verifyTrue(newCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("CREATE NEW CUSTOMER - STEP 10: Verify valid data in the fields is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), "nhanpv");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Birthdate"), "1994-01-01");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"), "29 ho xuan huong");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"), "da nang");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"), "my an");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Pin"), "324567");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile No."), "0935602450");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Email"), "b123iznvneadsdsaa321@gmal.com");

		log.info("CREATE NEW CUSTOMER - STEP 11: Get CUSTOMERID");
		customerID = newCustomerPage.getDynamicTextInTable(driver, "Customer ID");
		// 13401
		log.info("EDIT CUSTOMER - STEP 12: Open Edit Customer page");
		editCustomerPage = (EditCustomerPageObject) newCustomerPage.openMultiPage(driver, "Edit Customer");

		log.info("EDIT CUSTOMER - STEP 13: Verify Edit Customer page is displayed");
		verifyTrue(editCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Edit Customer Form"));

		log.info("EDIT CUSTOMER - STEP 14: Fill CustomerID");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("EDIT CUSTOMER - STEP 15: Click Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");

	}

	@Test
	public void TC_08_AddressCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill Addr");
		editCustomerPage.inputToDynamicTextArea(driver, "addr", "");
		
		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextArea(driver, "addr");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify Address cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "Address"), " Address Field must not be blank");
	}

	@Test
	public void TC_09_CityCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill City");
		editCustomerPage.inputToDynamicTextbox(driver, "city", "");
		
		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextbox(driver, "city");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify City cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "City"), "City Field must not be blank");
		
	}

	@Test
	public void TC_10_CityCannotBeNumeric() {
		log.info("EDIT CUSTOMER - STEP 1: Fill numberic in City");
		editCustomerPage.inputToDynamicTextbox(driver, "city", "123");

		log.info("EDIT CUSTOMER - STEP 2: Verify City cannot contain number is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "City"), "Numbers are not allowed");
		
	}

	@Test
	public void TC_11_CityCannotHaveSpecialChars() {
		log.info("EDIT CUSTOMER - STEP 1: Fill special chars in City");
		editCustomerPage.inputToDynamicTextbox(driver, "city", "^**");

		log.info("EDIT CUSTOMER - STEP 2: Verify City cannot contain special chars is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "City"), "Special characters are not allowed");
		
	}

	@Test
	public void TC_12_StateCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill State");
		editCustomerPage.inputToDynamicTextbox(driver, "state", "");
		
		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextbox(driver, "state");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify State cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "State"), "State must not be blank");
		
	}

	@Test
	public void TC_13_StateCannotBeNumeric() {
		log.info("EDIT CUSTOMER - STEP 1: Fill numberic in State");
		editCustomerPage.inputToDynamicTextbox(driver, "state", "123");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify State cannot contain number is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "State"), "Numbers are not allowed");
		
	}

	@Test
	public void TC_14_StateCannotHaveSpecialChars() {
		log.info("EDIT CUSTOMER - STEP 1: Fill special chars in State");
		editCustomerPage.inputToDynamicTextbox(driver, "state", "^**");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify State cannot contain special chars is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "State"), "Special characters are not allowed");
		
	}

	@Test
	public void TC_15_PinCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill Pin");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "");
		
		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextbox(driver, "pinno");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify Pin cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "PIN"), "PIN Code must not be blank");
		
	}

	@Test
	public void TC_16_PinMustBeNumeric() {
		log.info("EDIT CUSTOMER - STEP 1: Fill chars in Pin");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "dsa");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify Pin cannot contain chars is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "PIN"), "Characters are not allowed");
		
	}

	@Test
	public void TC_17_PinMustHave6Digits() {
		log.info("EDIT CUSTOMER - STEP 1: Fill less than 6digits in Pin");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "123");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify Pin cannot less than 6digits is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "PIN"), "PIN Code must have 6 Digits");
		
	}

	@Test
	public void TC_18_PinCannotHaveSpecialChars() {
		log.info("EDIT CUSTOMER - STEP 1: Fill special chars in Pin");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "^**");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify Pin cannot contains special chars is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "PIN"), "Special characters are not allowed");
		
	}

	@Test
	public void TC_19_TelephoneCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill Telephone");
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "");
		
		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextbox(driver, "telephoneno");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify Telephone cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "Mobile Number"), "Mobile no must not be blank");
		
		
	}

	@Test
	public void TC_20_TelephoneCannotHaveSpecialCharacter() {
		log.info("EDIT CUSTOMER - STEP 1: Fill special chars in Telephone");
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "^**");
		
		log.info("EDIT CUSTOMER - STEP 2: Verify Telephone cannot contains special chars is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "Mobile Number"), "Special characters are not allowed");
		
	}

	@Test
	public void TC_21_EmailCannotBeEmpty() {
		log.info("EDIT CUSTOMER - STEP 1: Dont fill Email");
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", "");

		log.info("EDIT CUSTOMER - STEP 2: Press Tab");
		editCustomerPage.pressTABToDynamicTextbox(driver, "emailid");
		
		log.info("EDIT CUSTOMER - STEP 3: Verify Email cannot be empty is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "E-mail"), "Email-ID must not be blank");
		
	}

	@Test
	public void TC_22_EmailMustBeInCorrectFormat() {
		log.info("EDIT CUSTOMER - STEP 1: Fill incorrect format in Email");
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", "abcde");

		log.info("EDIT CUSTOMER - STEP 2: Verify Email cannot incorrect format is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTableValidate(driver, "E-mail"), "Email-ID is not valid");
		}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);	
	}

}
