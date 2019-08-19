package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {

	WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void inputToCustomerNameTextbox(String username) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, username);
	}

	public void selectGender() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_RADIO);
		clickToElement(driver, NewCustomerPageUI.GENDER_RADIO);
	}

	public void inputToAddressTextarea(String address) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void inputToStateTextbox(String state) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void inputToPinTextbox(String pin) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void inputToMobilePhoneTextbox(String mobilenumber) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobilenumber);
	}

	public void inputToEmailCustomerTextbox(String email) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
	}

	public boolean isNewCustomerPageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.GET_TEXT_NEW_CUSTOMER);
		return isControlDisplayed(driver, NewCustomerPageUI.GET_TEXT_NEW_CUSTOMER);
	}

	public void inputDoBTextbox(String dob) {
		waitForElementVisible(driver, NewCustomerPageUI.DOB_TEXTBOX);
		sendkeyElement(driver, NewCustomerPageUI.DOB_TEXTBOX, dob);
	}

	public String getCustomerNameTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_CUSTOMER_NAME_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_CUSTOMER_NAME_TEXT);
	}

	public String getGenderTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_GENDER_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_GENDER_TEXT);
	}

	public String getMobileNumberTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_MOBILE_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_MOBILE_TEXT);
	}

	public String getPinTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_PIN_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_PIN_TEXT);
	}

	public String getStateTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_STATE_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_STATE_TEXT);
	}

	public String getCityTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_CITY_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_CITY_TEXT);
	}

	public String getAddressTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_ADDRESS_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_ADDRESS_TEXT);
	}

	public String getDoBTable() {
		waitForElementVisible(driver, NewCustomerPageUI.VERIFY_DOB_TEXT);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_DOB_TEXT);
	}

	// Validate Customer Name
	public void sendKeyTabToCustomerName() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
	}

	public boolean ValidateCustomerNameMustNotBeBlank() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_BE_EMPTY);
	}

	public boolean ValidateCustomerNameCannotBeNumeric() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_BE_NUMBER);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_BE_NUMBER);
	}

	public void clearDataCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);

	}

	public boolean ValidateCustomerNameCannotHaveSpecicalChars() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_SPECIAL_CHARS);
	}

	public boolean ValidateCustomerNameCannotHaveFirstCharAsBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
		return isControlDisplayed(driver,
				NewCustomerPageUI.VALIDATE_CUSTOMER_NAME_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
	}

	// Validate Address
	public void sendKeyTabToAddress() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyboardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);
	}

	public boolean ValidateAddressCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_ADDRESS_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_ADDRESS_CANNOT_BE_EMPTY);
	}

	public boolean ValidateAddressCannotHaveFirstCharAsBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_ADDRESS_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_ADDRESS_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
	}

	// Validate City
	public void sendKeyTabToCity() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
	}

	public void clearDataCityTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.CITY_TEXTBOX);

	}

	public boolean ValidateCityCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_BE_EMPTY);
	}

	public boolean ValidateCityCannotBeNumeric() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_BE_NUMBER);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_BE_NUMBER);
	}

	public boolean ValidateCityCannotHaveSpecicalChars() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_SPECIAL_CHARS);
	}

	public boolean ValidateCityCannotHaveFirstCharAsBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_CITY_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
	}

	// Validate State
	public void sendKeyTabToState() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
	}

	public void clearDataStateTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.STATE_TEXTBOX);

	}

	public boolean ValidateStateCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_BE_EMPTY);
	}

	public boolean ValidateStateCannotBeNumeric() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_BE_NUMBER);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_BE_NUMBER);
	}

	public boolean ValidateStateCannotHaveSpecicalChars() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_SPECIAL_CHARS);
	}

	public boolean ValidateStateCannotHaveFirstCharAsBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_STATE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
	}

	// Validate PIN
	public void clearDataPinTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
	}

	public void sendKeyTabToPin() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
	}

	public boolean ValidatePinMustBeNumberic() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_PIN_MUST_BE_NUMBERIC);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_PIN_MUST_BE_NUMBERIC);
	}

	public boolean ValidatePinCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_BE_EMPTY);
	}

	public boolean ValidatePinMustHave6Digits() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_PIN_MUST_HAVE_6_DIGITS);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_PIN_MUST_HAVE_6_DIGITS);
	}

	public boolean ValidatePinCannotHaveSpecialChars() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_SPECIAL_CHARS);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_SPECIAL_CHARS);
	}

	public boolean ValidatePinCannotHaveFirstBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_HAVE_FIRST_BLANK_SPACE);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_PIN_CANNOT_HAVE_FIRST_BLANK_SPACE);
	}

	// Validate Telephone
	public void clearDataTelephoneTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
	}

	public void sendKeyTabToTelephone() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
	}

	public boolean ValidateTelephoneCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_BE_EMPTY);
	}

	public boolean ValidateTelephoneCannotHaveFirstBlankSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE);
	}

	public boolean ValidateTelephoneCannotHaveSpace() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPACES);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPACES);
	}

	public boolean ValidateTelephoneCannotHaveSpecialCharacter() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER);
	}

	// Validate Email
	public void sendKeyTabToEmail() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
	}

	public boolean ValidateEmailCannotBeEmpty() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_EMAIL_CANNOT_BE_EMPTY);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_EMAIL_CANNOT_BE_EMPTY);
	}

	public void clearDataEmailTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clearDataElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
	}

	public boolean ValidateEmailMustBeInCorrectFormat() {
		waitForElementVisible(driver, NewCustomerPageUI.VALIDATE_EMAIL_INCORRECT);
		return isControlDisplayed(driver, NewCustomerPageUI.VALIDATE_EMAIL_INCORRECT);
	}

	public String getTextCustomerID() {
		waitForElementVisible(driver, NewCustomerPageUI.GET_TEXT_CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.GET_TEXT_CUSTOMER_ID);
	}

	public boolean isRegisterSuccessfullyTextDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.REGISTER_SUCCESS_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.REGISTER_SUCCESS_TEXT);
	}

}
