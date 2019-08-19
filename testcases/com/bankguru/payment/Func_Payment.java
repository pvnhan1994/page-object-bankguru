package com.bankguru.payment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Func_Payment extends AbstractPage {
	WebDriver driver;
	String username, password,customerID;
	String customerNameValue, dateOfBirthValue, addressValue, cityValue;
	String stateValue, pinValue, mobileNumberValue, emailValue, passWordValue, genderValue;
	
	String editAddressValue, editCityValue, editStateValue, editPinValue, editTeleValue, editEmailValue;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	@BeforeClass
	public void beforeClass() {
		username = "mngr216462";
		password = "bYjenug"; 
		customerID = "51037";
		
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
		
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	@Test
	public void TC_01_CreateNewCustomer() {
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToCustomerNameTextbox(customerNameValue);
		newCustomerPage.selectGender();
		newCustomerPage.inputToAddressTextarea(addressValue);
		newCustomerPage.inputToCityTextbox(cityValue);
		newCustomerPage.inputToStateTextbox(stateValue);
		newCustomerPage.inputDoBTextbox(dateOfBirthValue);
		newCustomerPage.inputToPinTextbox(pinValue);
		newCustomerPage.inputToMobilePhoneTextbox(mobileNumberValue);
		newCustomerPage.inputToEmailCustomerTextbox(emailValue);
		newCustomerPage.inputToPasswordTextbox(passWordValue);
		newCustomerPage.clickToSubmitButton();
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


