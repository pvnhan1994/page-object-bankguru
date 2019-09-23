package commons;

public class AbstractPageUI {
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	public static final String EDIT_ACCOUNT_LINK = "//a[text()='Edit Account']";
	public static final String MANAGER_LINK = "//a[text()='Manager']";
	public static final String DEPOSIT_LINK = "//a[text()='Deposit']";

	public static final String DYNAMIC_MENU_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BUTTON = "//input[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_TEXT_AREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_PAGE_HEADING = "//p[@class='heading3' and text()='%s']";
	public static final String DYNAMIC_TABLE_ROW_NAME = "//td[text()='%s']/following-sibling::td";
}
