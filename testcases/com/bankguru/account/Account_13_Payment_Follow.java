package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Commons_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.WithdrawalPageObject;

public class Account_13_Payment_Follow extends AbstractTest {
	WebDriver driver;
	String username, password, customerID, savingsAccountType, currentAccoutType, firstAccountID, secondAccountID;
	String customerNameValue, dateOfBirthValue, addressValue, cityValue, stateValue, pinValue, mobileNumberValue,
			emailValue, passWordValue, genderValue;
	String today;
	String editAddressValue, editCityValue, editStateValue, editPinValue, editTeleValue, editEmailValue;

	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DeleteCustomerPageObject deleteCustomerPage;
	EditCustomerPageObject editCustomerPage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	DepositPageObject depositPage;
	WithdrawalPageObject withdrawalPage;
	FundTransferPageObject fundTransferPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	DeleteAccountPageObject deleteAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		savingsAccountType = "Savings";
		currentAccoutType = "Current";

		customerNameValue = "Cooinnie";
		dateOfBirthValue = "1993-02-01";
		addressValue = "391 Thakketay Hill";
		cityValue = "Hunutsvylke";
		stateValue = "Akabbaha";
		genderValue = "male";
		pinValue = "313412";
		mobileNumberValue = "2133674369";
		emailValue = "cmcbcblzy9o@indiatimes.com";
		passWordValue = "112233";

		editAddressValue = "6 Btrrows Place";
		editCityValue = "Sakt Piul";
		editStateValue = "Micneaota";
		editPinValue = "125192";
		editTeleValue = "6112216635";
		editEmailValue = "laes0elby3k@phoca.cz";

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

		// mngr224341 AbYqema mngr224341
	}

	@Test
	public void TC_01_CreateNewCustomerAccountAndGetCustomerID() {
		log.info("NEW CUSTOMER - STEP 1: Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Add New Customer"));

		log.info("NEW CUSTOMER - STEP 2: Fill in All the fields");
		newCustomerPage.inputToDynamicTextbox(driver, "name", customerNameValue);
		newCustomerPage.clickToDynamicRadioButton(driver, "m");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", dateOfBirthValue);
		newCustomerPage.inputToDynamicTextArea(driver, "addr", addressValue);
		newCustomerPage.inputToDynamicTextbox(driver, "city", cityValue);
		newCustomerPage.inputToDynamicTextbox(driver, "state", stateValue);
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", pinValue);
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", mobileNumberValue);
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", emailValue);
		newCustomerPage.inputToDynamicTextbox(driver, "password", passWordValue);

		log.info("NEW CUSTOMER - STEP 3: Click Submit button");
		newCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("NEW CUSTOMER - STEP 4: Verify message displays with content Customer Registered Successfully");
		verifyTrue(newCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("NEW CUSTOMER - STEP 5: Verify all information is displayed");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), customerNameValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Birthdate"), dateOfBirthValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"), addressValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"), cityValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"), stateValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Pin"), pinValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile No."), mobileNumberValue);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Email"), emailValue);

		log.info("NEW CUSTOMER - STEP 6: Get Customer ID");
		customerID = newCustomerPage.getDynamicTextInTable(driver, "Customer ID");

	}

	@Test
	public void TC_02_EditCustomerAndCheckEditSuccessfully() {
		log.info("EDIT CUSTOMER - STEP 1: Open Edit Customer Page");
		editCustomerPage = (EditCustomerPageObject) newCustomerPage.openMultiPage(driver, "Edit Customer");
		verifyTrue(editCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Edit Customer Form"));

		log.info("EDIT CUSTOMER - STEP 2: Fill CustomerID");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("EDIT CUSTOMER - STEP 3: Click Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("EDIT CUSTOMER - STEP 4: Fill in Address, City, State, PIN, Mobile Number, Email fields");
		editCustomerPage.inputToDynamicTextArea(driver, "addr", editAddressValue);
		editCustomerPage.inputToDynamicTextbox(driver, "city", editCityValue);
		editCustomerPage.inputToDynamicTextbox(driver, "state", editStateValue);
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", editPinValue);
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", editTeleValue);
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", editEmailValue);

		log.info("EDIT CUSTOMER - STEP 5: Click Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");
		// 21895
		log.info("EDIT CUSTOMER - STEP 6: Verify message displays with content Edit Customer Successfully");
		verifyTrue(
				editCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Customer details updated Successfully!!!"));

		log.info("EDIT CUSTOMER - STEP 7: Verify all information updated is displayed");
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Address"), editAddressValue);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "City"), editCityValue);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "State"), editStateValue);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Pin"), editPinValue);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Mobile No."), editTeleValue);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Email"), editEmailValue);
	}

	@Test
	public void TC_03_AddNewAccountAndGetAccountID() {
		log.info("=============== CREATE FIRST ACCOUNT ==============");
//69700
		log.info("NEW ACCOUNT - STEP 1: Open New Account page");
		newAccountPage = (NewAccountPageObject) editCustomerPage.openMultiPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplayed(driver, "Add new account form"));

		log.info("NEW ACCOUNT - STEP 2: Fill in CustomerID");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("NEW ACCOUNT - STEP 3: Select type Savings");
		newAccountPage.selectToDynamicDropdownList(driver, "selaccount", savingsAccountType);

		log.info("NEW ACCOUNT - STEP 4: Fill in Deposit");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "50000");

		log.info("NEW ACCOUNT - STEP 5: Click Submit button");
		newAccountPage.clickToDynamicButton(driver, "submit");

		log.info("NEW ACCOUNT - STEP 6: Verify Account Generated Successfully is displayed");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("NEW ACCOUNT - STEP 7: Verify all information First New Account is displayed");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerNameValue);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Email"), editEmailValue);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account Type"), savingsAccountType);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Current Amount"), "50000");
		firstAccountID = newAccountPage.getDynamicTextInTable(driver, "Account ID");

		
		log.info("=============== CREATE SECOND ACCOUNT ==============");

		log.info("NEW ACCOUNT - STEP 1: Open New Account page");
		newAccountPage = (NewAccountPageObject) newAccountPage.openMultiPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplayed(driver, "Add new account form"));

		log.info("NEW ACCOUNT - STEP 2: Fill in CustomerID");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("NEW ACCOUNT - STEP 3: Select type Savings");
		newAccountPage.selectToDynamicDropdownList(driver, "selaccount", currentAccoutType);

		log.info("NEW ACCOUNT - STEP 4: Fill in Deposit");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "10000");

		log.info("NEW ACCOUNT - STEP 5: Click Submit button");
		newAccountPage.clickToDynamicButton(driver, "submit");

		log.info("NEW ACCOUNT - STEP 6: Verify Account Generated Successfully is displayed");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("NEW ACCOUNT - STEP 7: Verify all information Second New Account is displayed");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerNameValue);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Email"), editEmailValue);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account Type"), currentAccoutType);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Current Amount"), "10000");
		secondAccountID = newAccountPage.getDynamicTextInTable(driver, "Account ID");
	}

	@Test
	public void TC_04_EditAccount() {
		log.info("EDIT ACCOUNT - STEP 1: Open Edit Account page");
		editAccountPage = (EditAccountPageObject) newAccountPage.openMultiPage(driver, "Edit Account");

		log.info("EDIT ACCOUNT - STEP 2: Fill in AccountNo");
		editAccountPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("EDIT ACCOUNT - STEP 3: Click Submit button");
		editAccountPage.clickToDynamicButton(driver, "Submit");

		log.info("EDIT ACCOUNT - STEP 4: Change became Current value");
		editAccountPage.selectToDynamicDropdownList(driver, "a_type", currentAccoutType);

		log.info("EDIT ACCOUNT - STEP 5: Click Submit button");
		editAccountPage.clickToDynamicButton(driver, "Submit");

		log.info("EDIT ACCOUNT - STEP 6: Verify Account details updated Successfully is displayed");
		verifyTrue(editAccountPage.isDynamicPageOrMessageDisplayed(driver, "Account details updated Successfully!!!"));

		log.info("EDIT ACCOUNT - STEP 7: Verify all information First Edit Account is displayed");
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Account ID"), firstAccountID);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerNameValue);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Email"), editEmailValue);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Account Type"), currentAccoutType);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Current Amount"), "50000");
	}

	@Test
	public void TC_05_TransferMoneyIntoCurrentAccountAndCheckAccountBalanceEqual50000() {
		log.info("DEPOSIT - STEP 1: Open Deposit page");
		depositPage = (DepositPageObject) editAccountPage.openMultiPage(driver, "Deposit");
		verifyTrue(depositPage.isDynamicPageOrMessageDisplayed(driver, "Amount Deposit Form"));

		log.info("DEPOSIT - STEP 2: Fill in Account No");
		depositPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("DEPOSIT - STEP 3: Fill in Amount");
		depositPage.inputToDynamicTextbox(driver, "ammount", "5000");

		log.info("DEPOSIT - STEP 4: Fill in Description");
		depositPage.inputToDynamicTextbox(driver, "desc", "nop tien");

		log.info("DEPOSIT - STEP 5: Click Submit button");
		depositPage.clickToDynamicButton(driver, "Submit");

		log.info("DEPOSIT - STEP 6: Verify Transaction details of Deposit for Account is displayed");
		verifyTrue(depositPage.isDynamicPageOrMessageDisplayed(driver,
				"Transaction details of Deposit for Account " + firstAccountID));

		log.info("DEPOSIT - STEP 7: Verify all information Transaction detail");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Account No"), firstAccountID);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Amount Credited"), "5000");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Description"), "nop tien");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Current Balance"), "55000");

	}

	@Test
	public void TC_06_WithdrawMoneyFromCurrentAccountAndCheckAccountBalanceEqual40000() {
		log.info("WITHDRAWAL - STEP 1: Open Withdrawal page");
		withdrawalPage = (WithdrawalPageObject) depositPage.openMultiPage(driver, "Withdrawal");
		verifyTrue(withdrawalPage.isDynamicPageOrMessageDisplayed(driver, "Amount Withdrawal Form"));

		log.info("WITHDRAWAL - STEP 2: Fill in Account No");
		withdrawalPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("WITHDRAWAL - STEP 3: Fill in Amount");
		withdrawalPage.inputToDynamicTextbox(driver, "ammount", "15000");

		log.info("WITHDRAWAL - STEP 4: Fill in Description");
		withdrawalPage.inputToDynamicTextbox(driver, "desc", "rut tien");

		log.info("WITHDRAWAL - STEP 5: Click Submit button");
		withdrawalPage.clickToDynamicButton(driver, "Submit");

		log.info("DEPOSIT - STEP 6: Verify Transaction details of Withdrawal for Account is displayed");
		verifyTrue(withdrawalPage.isDynamicPageOrMessageDisplayed(driver,
				"Transaction details of Withdrawal for Account " + firstAccountID));

		log.info("DEPOSIT - STEP 7: Verify all information Transaction detail");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Account No"), firstAccountID);
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Amount Debited"), "15000");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Description"), "rut tien");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Current Balance"), "40000");
	}

	@Test
	public void TC_07_TransferTheMoneyIntoOtherAccountAndCheckAmoutEqual10000() {
		log.info("FUND_TRANSFER - STEP 1: Open Fund Transfer page");
		fundTransferPage = (FundTransferPageObject) withdrawalPage.openMultiPage(driver, "Fund Transfer");
		verifyTrue(fundTransferPage.isDynamicPageOrMessageDisplayed(driver, "Fund transfer"));

		log.info("FUND_TRANSFER - STEP 2: Fill in Payers account no");
		fundTransferPage.inputToDynamicTextbox(driver, "payersaccount", firstAccountID);

		log.info("FUND_TRANSFER - STEP 3: Fill in Payees account no");
		fundTransferPage.inputToDynamicTextbox(driver, "payeeaccount", secondAccountID);

		log.info("FUND_TRANSFER - STEP 4: Fill in Amount");
		fundTransferPage.inputToDynamicTextbox(driver, "ammount", "10000");

		log.info("FUND_TRANSFER - STEP 5: Fill in Description");
		fundTransferPage.inputToDynamicTextbox(driver, "desc", "chuyen tien");

		log.info("FUND_TRANSFER - STEP 6: Click Submit button");
		fundTransferPage.clickToDynamicButton(driver, "Submit");

		log.info("FUND_TRANSFER - STEP 7: Verify Fund Transfer Details is displayed");
		verifyTrue(fundTransferPage.isDynamicPageOrMessageDisplayed(driver, "Fund Transfer Details"));

		log.info("FUND_TRANSFER - STEP 8: Verify all information Fund Transfer Details");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "From Account Number"), firstAccountID);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "To Account Number"), secondAccountID);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Amount"), "10000");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Description"), "chuyen tien");
	}

	@Test
	public void TC_08_CheckCurrentAccountBalanceEqual30000() {
		log.info("BALANCE_ENQUIRY - STEP 1: Open Fund Transfer page");
		balanceEnquiryPage = (BalanceEnquiryPageObject) fundTransferPage.openMultiPage(driver, "Balance Enquiry");
		verifyTrue(balanceEnquiryPage.isDynamicPageOrMessageDisplayed(driver, "Balance Enquiry Form"));

		log.info("BALANCE_ENQUIRY - STEP 2: Fill in Account No");
		balanceEnquiryPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("BALANCE_ENQUIRY - STEP 3: Click Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "Submit");

		log.info("BALANCE_ENQUIRY - STEP 4: Verify Balance Details for Account is displayed");
		verifyTrue(balanceEnquiryPage.isDynamicPageOrMessageDisplayed(driver,
				"Balance Details for Account " + firstAccountID));

		log.info("BALANCE_ENQUIRY - STEP 5: Verify all information Fund Transfer Details");
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Account No"), firstAccountID);
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Type of Account"), currentAccoutType);
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Balance"), "30000");
	}

	@Test
	public void TC_09_DeleteAllAccountAndCheckDeleteSuccess() {
		log.info("DELETE ACCOUNT - STEP 1: Open Delete Account page");
		deleteAccountPage = (DeleteAccountPageObject) balanceEnquiryPage.openMultiPage(driver, "Delete Account");
		verifyTrue(deleteAccountPage.isDynamicPageOrMessageDisplayed(driver, "Delete Account Form"));

		log.info("DELETE ACCOUNT - STEP 2: Fill in Account No");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("DELETE ACCOUNT - STEP 3: Click Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "Submit");

		log.info("DELETE ACCOUNT - STEP 4: Verify Alert: Do you really want to delete this Account? is displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver,
				"Do you really want to delete this Account?"));

		log.info("DELETE ACCOUNT - STEP 5: Verify Alert: Account Deleted Successfully is displayed");
		verifyTrue(
				deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));

		log.info("DELETE ACCOUNT - STEP 6: Open Delete Account page again");
		deleteAccountPage = (DeleteAccountPageObject) deleteAccountPage.openMultiPage(driver, "Delete Account");
		verifyTrue(deleteAccountPage.isDynamicPageOrMessageDisplayed(driver, "Delete Account Form"));

		log.info("DELETE ACCOUNT - STEP 7: Fill in Account No");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", secondAccountID);

		log.info("DELETE ACCOUNT - STEP 8: Click Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "Submit");

		log.info("DELETE ACCOUNT - STEP 9: Verify Alert: Do you really want to delete this Account? is displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver,
				"Do you really want to delete this Account?"));

		log.info("DELETE ACCOUNT - STEP 10: Verify Alert: Account Deleted Successfully is displayed");
		verifyTrue(
				deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));

	}

	@Test
	public void TC_10_DeleteCustomerAndCheckDeleteSuccess() {
		log.info("DELETE CUSTOMER - STEP 1: Open Delete Customer page");
		deleteCustomerPage = (DeleteCustomerPageObject) deleteAccountPage.openMultiPage(driver, "Delete Customer");
		verifyTrue(deleteCustomerPage.isDynamicPageOrMessageDisplayed(driver, "Delete Customer Form"));

		log.info("DELETE CUSTOMER - STEP 2: Fill in CustomerID");
		deleteCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("DELETE CUSTOMER - STEP 3: Click Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("DELETE ACCOUNT - STEP 9: Verify Alert: Do you really want to delete this Customer? is displayed");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver,
				"Do you really want to delete this Customer?"));

		log.info("DELETE ACCOUNT - STEP 10: Verify Alert: Customer Deleted Successfully is displayed");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver,
				"Customer deleted Successfully"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
