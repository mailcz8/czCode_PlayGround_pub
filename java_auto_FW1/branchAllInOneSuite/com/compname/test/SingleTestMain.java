package com.compname.test;

import org.openqa.selenium.WebDriver;

import library.Utils.BaseDriver;

public class SingleTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = BaseDriver.getDriver();
	    driver.get("http://www.dokkio.com");
		
//	    driver.get("http://www.facebook.com");
	    
	    driver.quit();
	    System.out.println("All In One Test passed!!!");
	}

}
