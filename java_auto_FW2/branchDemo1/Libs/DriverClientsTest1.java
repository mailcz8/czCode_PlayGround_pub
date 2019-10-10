package Libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClientsTest1 {
	protected WebDriver driver = null;
	private static WebDriver theWebDriver;
	
	public void setWebDriver(WebDriver webDriver) {
		this.driver = webDriver;
	}

	protected WebDriver getWebDriver() {
		if (driver == null) {
			driver = theWebDriver;
		}
		return driver;
	}
	
//	
//	public static WebDriver getTheWebdriver() {
//		return theWebDriver;
//	}
//	
//	public void setTheWebDrier(WebDriver driver) {
//		theWebDriver = driver;
//	}
//	
//	
//	private static WebDriver theWebDriver;
//	
//	public static WebDriver getTheWebdriver() {
//		if (theWebDriver == null) {
//			theWebDriver = new ChromeDriver();
//		}
//		return theWebDriver;
//	}
//	
//	public void closeTheWebDrier() {		
//		theWebDriver.quit();
//		theWebDriver = null;
//	}
}
