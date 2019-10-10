package com.testcompname.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Libs.DriverClientsTest1;

public class MoveMethods extends DriverClientsTest1{

	public void useAction(String itemID) {
		driver = new ChromeDriver();
		WebElement element = driver.findElement(By.xpath(itemID));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void useJSExecutor(String itemID) throws InterruptedException {
		driver = new ChromeDriver();
		WebElement element = driver.findElement(By.xpath(itemID));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
}
