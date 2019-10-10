package library.Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class BaseTestDriver {

	protected WebDriver driver;
	private PropertyReader propertyReader;
	
	private static final String DEFAULT_URL_KEY = "URL";
//	private static final String URL = "http://www.facebook.com";
	private static final String LoginID = "toxdoo@gmail.com";
	private static final String LoginPW = "adaptive";	
	
	 /* 
	 * Starts up the configured BROWSER and navigates to the URL
	 * 
	 * @throws Exception
	 */
	protected void setup() throws IOException {
		propertyReader = new PropertyReader();
		String URL = propertyReader.getValue(DEFAULT_URL_KEY);
		System.out.println("Nav to:" + URL);
		getDriver().get(URL);
	}
	
	public WebDriver getDriver() {
		if(driver == null) {
			driver = BaseDriver.getDriver();
		}	
		return driver;
	}
	
	public boolean destroyBrowser() throws Exception {
		boolean bClosed=false;
		String sPlatform = System.getProperty("os.name");
		System.out.println("Closing driver on platform: " + sPlatform);
		
		try {
			if(driver != null)
				driver.quit();
			
			bClosed=true;
			driver=null;
		}
		catch (Exception e) {
			System.out.println("Exception in BasePage::closeBrowser() and "
					+ "browser not closed and associated processes potentially not killed.");
		}
		return(bClosed);
	}
}
