package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.EditCustomerPageUI;


public class EditCustomerPageObject extends AbstractPage {
WebDriver driver;
	public EditCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		
	}
	public void clickToSubmitButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		
	}
	
	public void sendKeyTabToCustomerID() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
	}

	public void clearDataCustomerIDTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public void inputToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}

	public boolean ValidateCustomerIDCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_ID_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_ID_CANNOT_BE_EMPTY);
	
	}

	public boolean ValidateCustomerIDMustBeNumeric() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_ID_MUST_BE_NUMERIC);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_ID_MUST_BE_NUMERIC);
	
	}

	public boolean ValidateCustomerIDCannotHaveSpecialCharacter() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_ID_CANNOT_HAVE_SPECIAL_CHARS);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_ID_CANNOT_HAVE_SPECIAL_CHARS);
	
	}

	public void sendKeyTabToAddress() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyboardToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);
		
	}

	public void clearDataAddressTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		clearDataElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public boolean ValidateAddressCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_ADDRESS_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_ADDRESS_CANNOT_BE_EMPTY);
	
	}
	public void inputAddressTextbox(String address) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA,address);
		
	}

	public void clearDataCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.CITY_TEXTBOX);
		
	}

	public void sendKeyTabToCity() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
		
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.CITY_TEXTBOX, city);
		
	}

	public boolean ValidateCityCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_BE_EMPTY);
	
	}

	public boolean ValidateCityCannotBeNumeric() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_BE_NUMBER);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_BE_NUMBER);
	
	}

	public boolean ValidateCityCannotHaveSpecicalChars() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
	
	}

	public void sendKeyTabToState() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
		
	}

	public void clearDataStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.STATE_TEXTBOX);
		
	}

	public void inputToStateTextbox(String state) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.STATE_TEXTBOX, state);
		
	}

	public boolean ValidateStateCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_STATE_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_STATE_CANNOT_BE_EMPTY);
	
	}

	public boolean ValidateStateCannotBeNumeric() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_STATE_CANNOT_BE_NUMBER);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_STATE_CANNOT_BE_NUMBER);
	
	}

	public boolean ValidateStateCannotHaveSpecicalChars() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
	
	}

	public void clearDataPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.PIN_TEXTBOX);
		
	}

	public void sendKeyTabToPin() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
		
	}

	public void inputToPinTextbox(String pin) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.PIN_TEXTBOX, pin);
		
	}

	public boolean ValidatePinMustBeNumberic() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_PIN_MUST_BE_NUMBERIC);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_PIN_MUST_BE_NUMBERIC);
	
	}

	public boolean ValidatePinCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_PIN_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_PIN_CANNOT_BE_EMPTY);
	
	}

	public boolean ValidatePinMustHave6Digits() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_PIN_MUST_HAVE_6_DIGITS);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_PIN_MUST_HAVE_6_DIGITS);
	
	}

	public boolean ValidatePinCannotHaveSpecialChars() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_PIN_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_PIN_CANNOT_SPECIAL_CHARS);
	
	}

	public void clearDataTelephoneTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		
	}

	public void sendKeyTabToTelephone() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
		
	}

	public void inputToMobilePhoneTextbox(String telephone) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, telephone);
		
	}

	public boolean ValidateTelephoneCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_BE_EMPTY);
	
	}

	public boolean ValidateTelephoneCannotHaveSpecialCharacter() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER);
	
	}
	// Validate Email 
	public void clearDataEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clearDataElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public void sendKeyTabToEmail() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
		
	}

	public boolean ValidateEmailCannotBeEmpty() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_EMAIL_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_EMAIL_CANNOT_BE_EMPTY);
	
	}

	public void inputToEmailCustomerTextbox(String email) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, email);
		
	}

	public boolean ValidateEmailMustBeInCorrectFormat() {
		waitForElementVisible(driver, EditCustomerPageUI.VALIDATE_EMAIL_INCORRECT);
		return isControlDisplayed(driver, EditCustomerPageUI.VALIDATE_EMAIL_INCORRECT);
	
	}
	public boolean isTextEditCustomerDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.TEXT_EDIT_CUSTOMER_FORM);
		return isControlDisplayed(driver, EditCustomerPageUI.TEXT_EDIT_CUSTOMER_FORM);
	}
	public void clickToButtonSubmitEdit() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
	}
	public boolean isEditSuccessfullyTextDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_SUCCESS_TEXT);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_SUCCESS_TEXT);
	}
	
	



}
