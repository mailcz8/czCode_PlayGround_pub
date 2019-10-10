package com.testcompname.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.testcompname.page.MoveMethods;

import Libs.DriverClientsTest1;

public class testAlert extends DriverClientsTest1{

	public static void main(String[] args) {
		String testUrl = "http://www.tizag.com/javascriptT/javascriptalert.php";
		String confirmationBtnXpath = "//input[@value='Confirmation Alert']";
		WebDriver driver = new ChromeDriver();
		MoveMethods moveTo = new MoveMethods();
		try {
			driver.get(testUrl);
			
			WebElement element = driver.findElement(By.xpath(confirmationBtnXpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();

			driver.findElement(By.xpath(confirmationBtnXpath)).click();
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
//			alert.dismiss();
			// driver = driver.switchTo().defaultContent();
			System.out.println("Test passed!!!");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			driver.quit();
		}
	}
}
