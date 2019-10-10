package com.compname.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import library.Utils.BaseDriver;
import library.Utils.BaseTestDriver;
import library.Utils.PropertyReader;

public class LoginPage {
	
	protected WebDriver driver;
	protected PropertyReader propertyReader;
	
/*	@Override
	protected void setup() throws Exception {
		String URL = "http://www.gmail.com";
		System.out.println("Nav to:" + URL);	
		getDriver().get(URL);
	}*/
	
/*    public LoginPage() throws Exception {
    	// instantiate the page objects that this action layer class will need
    	super();
    	System.out.println("login to");
    }*/

	public LoginPage(WebDriver driver) {
		propertyReader = new PropertyReader();
		this.driver = driver;
	}

	public void loginAsUser(String userName, String password) {
    	// method to login in as UserName and PW
    	WebElement loginIDField = driver.findElement(By.id("email"));
    	WebElement loginPasswd = driver.findElement(By.id("pass"));
    	WebElement loginButton = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
    	loginIDField.sendKeys(userName);
    	loginPasswd.sendKeys(password);
    	loginButton.click();
    	System.out.println("User logged in passed.");
    }
    
    public void logOutUser() {
    	// method to login in as UserName and PW
    	WebElement logOutButton = driver.findElement(By.id("LogOutButton"));
    	logOutButton.click();
    	System.out.println("User Logged Out passed.");
    }
}
