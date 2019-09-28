package com.bankguru.payment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class Func_Payment extends AbstractTest {
	WebDriver driver;
	String username, password,customerID;
	String customerNameValue, dateOfBirthValue, addressValue, cityValue;
	String stateValue, pinValue, mobileNumberValue, emailValue, passWordValue, genderValue;
	
	String editAddressValue, editCityValue, editStateValue, editPinValue, editTeleValue, editEmailValue;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		//username = "mngr216462";
		//password = "bYjenug"; 
		customerID = "51037";
		// mngr224675  zAsUtyt
		customerNameValue = "Connie";
		dateOfBirthValue = "1990-01-01";
		addressValue = "692 Thackeray Hill";
		cityValue = "Huntsville";
		stateValue = "Alabama";
		genderValue = "male";
		pinValue = "358152";
		mobileNumberValue = "2569674369";
		emailValue = "cmcauley4o@indiatimes.com";
		passWordValue = "112233";
		
		editAddressValue = "6 Burrows Place";
		editCityValue = "Saint Paul";
		editStateValue = "Minnesota";
		editPinValue = "325312";
		editTeleValue = "6511716635";
		editEmailValue = "leshelby3k@phoca.cz";
		
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
	
		
		
		//mngr224341  AbYqema mngr224341
	}
	@Test
	public void TC_01_CreateNewCustomer() {
		log.info("NEW CUSTOMER - STEP 1: Open New Customer Page");
		newCustomerPage = homePage.clickNewCustomer();
		
		log.info("NEW CUSTOMER - STEP 2.1: Fill in Customer Name");
		newCustomerPage.inputToCustomerNameTextbox(customerNameValue);
		
		log.info("NEW CUSTOMER - STEP 2.2: Fill in DateOfBirth");
		newCustomerPage.inputDoBTextbox(dateOfBirthValue);
		
		log.info("NEW CUSTOMER - STEP 2.3: Fill in Address");
		newCustomerPage.inputToAddressTextarea(addressValue);
		
		log.info("NEW CUSTOMER - STEP 2.4: Fill in City");
		newCustomerPage.inputToCityTextbox(cityValue);
		
		log.info("NEW CUSTOMER - STEP 2.5: Fill in State");
		newCustomerPage.inputToStateTextbox(stateValue);
		
		log.info("NEW CUSTOMER - STEP 2.6: Fill in PIN");
		newCustomerPage.inputToPinTextbox(pinValue);
		
		log.info("NEW CUSTOMER - STEP 2.7: Fill in Mobile Number");
		newCustomerPage.inputToMobilePhoneTextbox(mobileNumberValue);
		
		log.info("NEW CUSTOMER - STEP 2.8: Fill in Email");
		newCustomerPage.inputToEmailCustomerTextbox(emailValue);
		
		log.info("NEW CUSTOMER - STEP 2.9: Fill in Password");
		newCustomerPage.inputToPasswordTextbox(passWordValue);
		
		log.info("NEW CUSTOMER - STEP 3: Click Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("NEW CUSTOMER - STEP 4: Verify Customer Name");
		
		
		log.info("NEW CUSTOMER - STEP 4.1: Verify DateOfBirth ");
		

		log.info("NEW CUSTOMER - STEP 4.2: Verify Address");
		

		log.info("NEW CUSTOMER - STEP 4.3: Verify City");
		

		log.info("NEW CUSTOMER - STEP 4.4: Verify State");
		

		log.info("NEW CUSTOMER - STEP 4.5: Verify Pin");
		

		log.info("NEW CUSTOMER - STEP 4.6: Verify Mobile");
		

		log.info("NEW CUSTOMER - STEP 4.7: Verify Email");
		

		log.info("NEW CUSTOMER - STEP 4.8: Verify ");
		

		log.info("NEW CUSTOMER - STEP 4.9: Verify ");
		

		log.info("NEW CUSTOMER - STEP 4.10: Verify ");
		
		
		
		
		
		
		
		
		Assert.assertTrue(newCustomerPage.isRegisterSuccessfullyTextDisplayed());
	}
	@Test
	public void TC_02_EditCustomer() throws Exception {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToCustomerIDTextbox(customerID);
		editCustomerPage.clickToSubmitButton();
		editCustomerPage.clearDataAddressTextbox();
		editCustomerPage.clearDataCityTextbox();
		editCustomerPage.clearDataEmailTextbox();
		editCustomerPage.clearDataStateTextbox();
		editCustomerPage.clearDataTelephoneTextbox();
		editCustomerPage.inputToCityTextbox(editCityValue);
		editCustomerPage.inputAddressTextbox(editAddressValue);
		editCustomerPage.inputToStateTextbox(editStateValue);
		editCustomerPage.inputToPinTextbox(editPinValue);
		editCustomerPage.inputToMobilePhoneTextbox(editTeleValue);
		editCustomerPage.inputToEmailCustomerTextbox(editEmailValue);
		editCustomerPage.clickToButtonSubmitEdit();
		Assert.assertTrue(editCustomerPage.isEditSuccessfullyTextDisplayed());
	}
	


	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}


