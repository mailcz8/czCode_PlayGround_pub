package com.compname.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Utils.BaseDriver;

public class SingleTestInTestNG1 {
	String URL = "https://www.facebook.com/";
	
	WebDriver driver = null;
	
	@BeforeTest
	public void initSetup() throws Exception {
		try {
			if (driver == null) {
				driver = BaseDriver.getDriver();
				System.out.println("Init webDriver...");
			}

			driver.get(URL);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	
	@Test
	public void maintest1() {
		System.out.println("Having fund with test in main body now.");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
