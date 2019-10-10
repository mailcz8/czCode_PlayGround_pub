package com.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDokkio {

	public class TestQAButtonAtHomePage {

		@Test(priority = 1, groups = { "acceptance" })
		public void testDokkio() throws Exception {
			try {
				ChromeDriver chromeDriver = new ChromeDriver();
				WebDriver driver = chromeDriver.getChromeDriver();

				// WebDriver driver = ChromeDriver.getChromeDriver();
				// Note: normally the driver will be inherited from a base class
				// in the framework
				// which is the one I used right here. In case, there is not
				// framework driver, automator
				// can instantiate the driver as followed and pass the test URL

				String URL = "http://dokkio.com/";
				driver.get(URL);

				System.out.println("Nav to website");
				WebElement QAButton = driver
						.findElement(By.xpath("//span[@class='iw-so-tab-text' and text()='QA Engineer']"));
				WebElement QAJobTitle = driver
						.findElement(By.xpath("//div[@class='job-header']//*[text()='QA Engineer']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QAButton);
				if (!QAButton.isEnabled()) {
					QAButton.click();
					// Assert QA button state = enable
					assertTrue(QAButton.isEnabled(), "Expect button to be enable, but found not!");
					// Assert QA Job title is displayed
					assertTrue(QAJobTitle.isDisplayed(), "Expected QA job title is not found!");
				}

				System.out.println("Test passed.");

				// close test browser (Normally in will be handle by TestNG
				// annotation "@AfterTest"
				driver.quit();
			} catch (Error e) {

			}
		}

		class ChromeDriver {
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

	}

}
