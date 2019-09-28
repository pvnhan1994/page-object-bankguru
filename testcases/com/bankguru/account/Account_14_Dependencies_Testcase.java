package com.bankguru.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Account_14_Dependencies_Testcase {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().refresh();
	}
	@Test
	public void TC_01_DontInputDataAllTheFields(){
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(), "Vui lòng nhập số điện thoại.");
	}
	
	@Test
	public void TC_02_InputInvalidDataAllTheFields() throws Exception {
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("321321");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("32dsa1321");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("321");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("321321dsa");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("zxcxzdsa");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(), "Email nhập lại không đúng");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(), "Mật khẩu bạn nhập không khớp");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(), "Vui lòng nhập con số");
	}


	@AfterClass
	public void afterClass() {

		driver.close();
	}

}