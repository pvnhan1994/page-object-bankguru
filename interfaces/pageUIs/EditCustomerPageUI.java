package pageUIs;

public class EditCustomerPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_NUMBER_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	
	public static final String TEXT_EDIT_CUSTOMER_FORM = "//p[@class='heading3' and text()='Edit Customer Form']";
	public static final String VALIDATE_ID_CANNOT_BE_EMPTY = "//label[@id='message14' and text()='Customer ID is required']";
	public static final String VALIDATE_ID_MUST_BE_NUMERIC = "//label[@id='message14' and text()='Characters are not allowed']";
	public static final String VALIDATE_ID_CANNOT_HAVE_SPECIAL_CHARS = "//label[@id='message14' and text()='Special characters are not allowed']";
	
	
	public static final String VALIDATE_ADDRESS_CANNOT_BE_EMPTY = "//label[@id='message3' and text()='Address Field must not be blank']";
	
	public static final String VALIDATE_CITY_CANNOT_BE_EMPTY = "//label[@id='message4' and text()='City Field must not be blank']";
	public static final String VALIDATE_CITY_CANNOT_BE_NUMBER = "//label[@id='message4' and text()='Numbers are not allowed']";
	public static final String VALIDATE_CITY_CANNOT_SPECIAL_CHARS = "//label[@id='message4' and text()='Special characters are not allowed']";
	
	public static final String VALIDATE_STATE_CANNOT_BE_EMPTY = "//label[@id='message5' and text()='State must not be blank']";
	public static final String VALIDATE_STATE_CANNOT_BE_NUMBER = "//label[@id='message5' and text()='Numbers are not allowed']";
	public static final String VALIDATE_STATE_CANNOT_SPECIAL_CHARS = "//label[@id='message5' and text()='Special characters are not allowed']";
	
	public static final String VALIDATE_PIN_MUST_BE_NUMBERIC = "//label[@id='message6' and text()='Characters are not allowed']";
	public static final String VALIDATE_PIN_CANNOT_BE_EMPTY = "//label[@id='message6' and text()='PIN Code must not be blank']";
	public static final String VALIDATE_PIN_MUST_HAVE_6_DIGITS = "//label[@id='message6' and text()='PIN Code must have 6 Digits']";
	public static final String VALIDATE_PIN_CANNOT_SPECIAL_CHARS = "//label[@id='message6' and text()='Special characters are not allowed']";
	
	public static final String VALIDATE_TELEPHONE_CANNOT_BE_EMPTY = "//label[@id='message7' and text()='Mobile no must not be blank']";
	public static final String VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER = "//label[@id='message7' and text()='Special characters are not allowed']";
	
	public static final String VALIDATE_EMAIL_CANNOT_BE_EMPTY = "//label[@id='message9' and text()='Email-ID must not be blank']";
	public static final String VALIDATE_EMAIL_INCORRECT = "//label[@id='message9' and text()='Email-ID is not valid']";
	
	public static final String SUBMIT_EDIT_BUTTON = "//input[@name='sub']";
	
	public static final String EDIT_SUCCESS_TEXT = "//p[@class='heading3' and text()='Customer details updated Successfully!!!']";
	
}
