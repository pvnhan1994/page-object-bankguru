package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Commons_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Account_12_RegisterAndLogin_DynamicElement extends AbstractTest {
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


		log.info("LOGIN - STEP 0: Open New Customer");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
		//homePage.openMultiPages(driver, "New Customer");
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

	@AfterClass
	public void afterClass() {

		closeBrowserAndDriver(driver);
	}

}