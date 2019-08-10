package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Account_02_RegisterAndLogin_AbstractPage_02 extends AbstractPage {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		openUrl(driver, "http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		loginPageUrl = getCurrentPageUrl(driver);
		email = "binvnese" + randomDataTest() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		clickToElement(driver, "//a[text()='here']");
		sendkeyElement(driver, "//input[@name='emailid']", email);
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void TC_02_LoginToSystem() {
		openUrl(driver, loginPageUrl);
		sendkeyElement(driver, "//input[@name='uid']", username);
		sendkeyElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		String welcome = getTextElement(driver, "//marquee");
		Assert.assertEquals(welcome, "Welcome To Manager's Page of Guru99 Bank");
		Assert.assertTrue(isControlDisplayed(driver, "//td[text()='Manger Id : " + username + "']"));
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
