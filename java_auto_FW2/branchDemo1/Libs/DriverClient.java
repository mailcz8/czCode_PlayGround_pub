package Libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClient {

	private static WebDriver theWebDriver;
	
	public static WebDriver getTheWebdriver() {
		if (theWebDriver == null) {
			theWebDriver = new ChromeDriver();
		}
		return theWebDriver;
	}
	
	public void closeTheWebDrier() {		
		theWebDriver.quit();
		theWebDriver = null;
	}
}
