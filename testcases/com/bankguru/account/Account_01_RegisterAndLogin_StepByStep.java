package com.bankguru.account;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_01_RegisterAndLogin_StepByStep {
  WebDriver driver;
  String email, username, password, loginPageUrl;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  loginPageUrl = driver.getCurrentUrl();
	  email = "binvnese" + randomDataTest() + "@gmail.com";
  }
  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("Registe - Step 1: Click to here link");
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  
	  System.out.println("Registe - Step 2: Input to mail");
	  driver.findElement(By.name("emailid")).sendKeys(email);
	  
	  System.out.println("Registe - Step 3: Click Submit button");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  System.out.println("Registe - Step 4: Get username/ password");
	  username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  
	  
  }
  @Test
  public void TC_02_LoginToSystem() {
	  
	 
	  System.out.println("Login - Step 1: Open Login Page");
	  driver.get(loginPageUrl);
	  
	  System.out.println("Login - Step 2: Input username/ password"); 
	  driver.findElement(By.name("uid")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  
	  System.out.println("Login - Step 3: Click Login button"); 
	  driver.findElement(By.name("btnLogin")).click();
	  
	  System.out.println("Login - Step 4: Verify text Welcome"); 
	  String welcome = driver.findElement(By.xpath("//marquee")).getText();
	  Assert.assertEquals(welcome, "Welcome To Manager's Page of Guru99 Bank");
	  
	  System.out.println("Login - Step 5: Verify text ID"); 
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+ username +"']")).isDisplayed());
	  
  }
  public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(99999);
	}
  @AfterClass
  public void afterClass() {
	  
  }

}
