package com.compname.test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.compname.pages.LoginPage;

import library.Utils.BaseDriver;
import library.Utils.BaseTestDriver;
import library.Utils.PropertyReader;

public class LoadHomPageTest extends BaseTestDriver{

	String loginURI, username, password;
	
	LoginPage loginPage;
	PropertyReader propertyReader;

	@BeforeTest(alwaysRun = true)
	public void initSetup() throws Exception{
		this.setup();
		// Instantiate classes needed
		loginPage = new LoginPage(driver);
		propertyReader = new PropertyReader();
		
/*		try{
			this.setup();
			ExecutionLog.Log(this.browser.driver.toString());				
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//setup user login info
		username = propertyReader.getValue("AdminUsername");
		password = propertyReader.getValue("Password");
		loginURI = propertyReader.getValue("URL");
		System.out.println("AdminUsername = " + username);
		System.out.println("password = " + password);
		System.out.println("loginURI = " + loginURI);
	}
	
	@Test
	public void loginUserTestOne() {
		System.out.println(
				this.getClass().getName() + " >> " + new Exception().getStackTrace()[0].getMethodName());
		
		loginPage.loginAsUser(username, password);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Exception {		
//		if(driver != null)
//			driver.quit();		
		this.destroyBrowser();
	}
}
