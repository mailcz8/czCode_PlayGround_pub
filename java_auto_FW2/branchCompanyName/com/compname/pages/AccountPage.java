package com.compname.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import library.Utils.BaseTestDriver;
import library.Utils.PropertyReader;

public class AccountPage {
	
	protected WebDriver driver;
	protected PropertyReader propertyReader;
	
	private String accountCreate;

	public AccountPage(WebDriver driver) {
		propertyReader = new PropertyReader();
		this.driver = driver;
	}

	public void createAccount(String accountNameToCreate) {
		WebElement xpa = driver.findElement(By.id("SundayID"));
		// if account created, then set accountCreate
		accountCreate = accountNameToCreate;
	}
	
	public String getAccountCreatedName() {
		// getter
		return accountCreate;
	}
}
