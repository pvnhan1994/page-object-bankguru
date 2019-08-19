package pageUIs;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String GENDER_RADIO = "//input[@value='m']";
	public static final String DOB_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_NUMBER_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String SUBMIT_BUTTON = "//input[@name='sub']";
	public static final String GET_TEXT_CUSTOMER_ID = "//td[text()='Customer ID']//following-sibling::td";
	public static final String GET_TEXT_NEW_CUSTOMER = "//p[@class='heading3' and text()='Add New Customer']";
	
	
	public static final String VERIFY_CUSTOMER_NAME_TEXT = "//td[text()='Customer Name']//following-sibling::td";
	public static final String VERIFY_GENDER_TEXT = "//td[text()='Gender']//following-sibling::td";
	public static final String VERIFY_DOB_TEXT = "//td[text()='Birthdate']//following-sibling::td";
	public static final String VERIFY_ADDRESS_TEXT = "//td[text()='Address']//following-sibling::td";
	public static final String VERIFY_CITY_TEXT = "//td[text()='City']//following-sibling::td";
	public static final String VERIFY_STATE_TEXT = "//td[text()='State']//following-sibling::td";
	public static final String VERIFY_PIN_TEXT = "//td[text()='Pin']//following-sibling::td";
	public static final String VERIFY_MOBILE_TEXT = "//td[text()='Mobile No.']//following-sibling::td";
	public static final String VERIFY_EMAIL_TEXT = "//td[text()='Email']//following-sibling::td";
	
	public static final String VALIDATE_CUSTOMER_NAME_CANNOT_BE_EMPTY = "//label[text()='Customer name must not be blank']";
	public static final String VALIDATE_CUSTOMER_NAME_CANNOT_BE_NUMBER = "//label[text()='Numbers are not allowed']";
	public static final String VALIDATE_CUSTOMER_NAME_CANNOT_SPECIAL_CHARS = "//label[text()='Special characters are not allowed']";
	public static final String VALIDATE_CUSTOMER_NAME_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE = "//label[text()='First character can not have space']";
	
	public static final String VALIDATE_ADDRESS_CANNOT_BE_EMPTY = "//label[@id='message3' and text()='Address Field must not be blank']";
	public static final String VALIDATE_ADDRESS_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE = "//label[@id='message3' and text()='First character can not have space']";
	
	public static final String VALIDATE_CITY_CANNOT_BE_EMPTY = "//label[@id='message4' and text()='City Field must not be blank']";
	public static final String VALIDATE_CITY_CANNOT_BE_NUMBER = "//label[@id='message4' and text()='Numbers are not allowed']";
	public static final String VALIDATE_CITY_CANNOT_SPECIAL_CHARS = "//label[@id='message4' and text()='Special characters are not allowed']";
	public static final String VALIDATE_CITY_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE = "//label[@id='message4' and text()='First character can not have space']";
	
	public static final String VALIDATE_STATE_CANNOT_BE_EMPTY = "//label[@id='message5' and text()='State must not be blank']";
	public static final String VALIDATE_STATE_CANNOT_BE_NUMBER = "//label[@id='message5' and text()='Numbers are not allowed']";
	public static final String VALIDATE_STATE_CANNOT_SPECIAL_CHARS = "//label[@id='message5' and text()='Special characters are not allowed']";
	public static final String VALIDATE_STATE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE = "//label[@id='message5' and text()='First character can not have space']";

	public static final String VALIDATE_PIN_MUST_BE_NUMBERIC = "//label[@id='message6' and text()='Characters are not allowed']";
	public static final String VALIDATE_PIN_CANNOT_BE_EMPTY = "//label[@id='message6' and text()='PIN Code must not be blank']";
	public static final String VALIDATE_PIN_MUST_HAVE_6_DIGITS = "//label[@id='message6' and text()='PIN Code must have 6 Digits']";
	public static final String VALIDATE_PIN_CANNOT_SPECIAL_CHARS = "//label[@id='message6' and text()='Special characters are not allowed']";
	public static final String VALIDATE_PIN_CANNOT_HAVE_FIRST_BLANK_SPACE = "//label[@id='message6' and text()='First character can not have space']";
	
	public static final String VALIDATE_TELEPHONE_CANNOT_BE_EMPTY = "//label[@id='message7' and text()='Mobile no must not be blank']";
	public static final String VALIDATE_TELEPHONE_CANNOT_HAVE_FIRST_CHAR_AS_BLANK_SPACE = "//label[@id='message7' and text()='First character can not have space']";
	public static final String VALIDATE_TELEPHONE_CANNOT_HAVE_SPACES = "//label[@id='message7' and text()='Characters are not allowed']";
	public static final String VALIDATE_TELEPHONE_CANNOT_HAVE_SPECIAL_CHARACTER = "//label[@id='message7' and text()='Special characters are not allowed']";
	
	public static final String VALIDATE_EMAIL_CANNOT_BE_EMPTY = "//label[@id='message9' and text()='Email-ID must not be blank']";
	public static final String VALIDATE_EMAIL_INCORRECT = "//label[@id='message9' and text()='Email-ID is not valid']";
	
	public static final String REGISTER_SUCCESS_TEXT = "//p[@class='heading3' and text()='Customer Registered Successfully!!!']";
}
