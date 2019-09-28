package com.bankguru.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Account_15_Sort_Asc_Desc {
	WebDriver driver;
	WebDriverWait wait;
	Select select;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,30);
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void Sort(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='product_sort_container']")));
		select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		select.selectByValue("az");
		Assert.assertTrue(isDataSortedAsceding("//div[@class='inventory_item_name']"));
		select.selectByValue("za");
		Assert.assertTrue(isDataSortedDesceding("//div[@class='inventory_item_name']"));
		
		
	}
	
	public boolean isDataSortedAsceding(String locator) {
		//Khai báo 1 Array List
		ArrayList<String>arrayList = new ArrayList<>();
		
		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		//Lấy text của từng element add vào Array List 
		for(WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-------- Dữ liệu trên UI:-------");
		ArrayList<String> sortedList = new ArrayList<>();
		for(String child:arrayList) {
			sortedList.add(child);
		}
		
		//Thực hiện SORT ASC
		Collections.sort(arrayList);
		
		System.out.println("------------ Dữ liệu đã SORT ASC trong code:----------");
		for(String name:arrayList) {
			System.out.println(name);
		}
		
		//Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả trả về sai 
		return sortedList.equals(arrayList);
	}
	public boolean isDataSortedDesceding(String locator) {
		//Khai báo 1 Array List
		ArrayList<String>arrayList = new ArrayList<>();
		
		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		//Lấy text của từng element add vào Array List 
		for(WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-------- Dữ liệu trên UI:-------");
		ArrayList<String> sortedList = new ArrayList<>();
		for(String child:arrayList) {
			sortedList.add(child);
		}
		
		//Thực hiện SORT ASC
		Collections.sort(arrayList);
		Collections.reverse(arrayList);
		System.out.println("------------ Dữ liệu đã SORT ASC trong code:----------");
		for(String name:arrayList) {
			System.out.println(name);
		}
		
		//Verify 2 array bằng nhau - nếu dữ liệu sort trên UI ko chính xác thì kết quả trả về sai 
		return sortedList.equals(arrayList);
	}


	@AfterClass(alwaysRun=true)
	public void afterClass() {

		driver.close();
	}

}