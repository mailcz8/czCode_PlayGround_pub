package com.compname.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.compname.pages.AccountPage;
import com.compname.pages.LoginPage;

import library.Utils.BaseDriver;
import library.Utils.BaseTestDriver;

public class CreateAccountTest extends BaseTestDriver{

	LoginPage loginPage;
	AccountPage accountPage;
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void initSetup() throws Exception{
		// Get driver
		this.setup();
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);		
		
/*		try{
			this.accountPage.initSetup();
			System.out.println(this.accountPage.getDriver().toString());				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//setup user login info
		username = appValues.getValue("AdminUsername");
		password = appValues.getValue("Password");
		loginURI = appValues.getValue("URL");
*/		
//		driver = accountPage.getDriver();
	}
	
	@Test
	public void testOne() {
		loginPage.loginAsUser("name@gmail.com", "aaa");
//		driver.findElement(By.id("nameOdID"));
		accountPage.createAccount("CreateTestAccount1");
	}
}
