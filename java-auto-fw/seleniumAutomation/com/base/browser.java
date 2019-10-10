package com.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {

	public WebDriver getChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase();
		File f = new File("driver");
		System.out.println("f.getAbsolutePath returns: " + f.getAbsolutePath());
		File fs = null;
		System.out.println(System.getProperty("user.dir")+"driver");				

		if (os.contains("mac")) {
			fs = new File(f, "chromedriver");
			String driverPath = fs.getAbsolutePath();
			System.out.println("fs.getAbsolutePath returns: " + driverPath);
			System.setProperty("webdriver.chrome.driver", System.getProperty(driverPath));
		} else {
			fs = new File(f, "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		}

		WebDriver driver = (WebDriver) new ChromeDriver();

		return driver;
	}
}
