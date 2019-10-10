package library.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
	
	public enum DriverType { CHROME, FIREFOX };
	
	public static WebDriver getDriver() {
		
		//read configuration
		DriverType driverType = DriverType.CHROME;  // initialized from config
		return getDriver(driverType);
	}
		
	public static WebDriver getDriver(DriverType driverType) {
		String osName = System.getProperty("os.name");
		String driverPath;
		
		if (osName.startsWith("Windows")) {
			if (driverType == DriverType.CHROME) {
				driverPath = System.getProperty("user.dir") + "//driver//chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				return new ChromeDriver();
			} else if (driverType == DriverType.FIREFOX) {
				driverPath = System.getProperty("user.dir") + "//driver//geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", driverPath);
				return new FirefoxDriver();
			} // else if IE
		} else if (osName.startsWith("Mac")) {
			if (driverType == DriverType.CHROME) {
				driverPath = System.getProperty("user.dir") + "/driver/chromedriver";
				System.setProperty("webdriver.chrome.driver", driverPath);
				return new ChromeDriver();
			} else if (driverType == DriverType.FIREFOX) {
				driverPath = System.getProperty("user.dir") + "/driver/geckodriver";
				System.setProperty("webdriver.gecko.driver", driverPath);
				return new FirefoxDriver();
			} // else if IE
		}
		return null;
	}

}
