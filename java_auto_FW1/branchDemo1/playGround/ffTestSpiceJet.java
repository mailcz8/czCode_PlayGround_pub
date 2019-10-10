package playGround;

import org.testng.Assert;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ffTestSpiceJet {

	public static void main(String[] args) {
		String os = System.getProperty("os.name").toLowerCase();
		String testURL = "http://book.spicejet.com/";
		System.out.println(System.getProperty("user.dir") + "/geckodriver");
		
		if (os.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
		}
		
		WebDriver driver = new FirefoxDriver();
		
		try {
			driver.get(testURL);
			System.out.println(driver.getTitle());
			Assert.assertEquals("Book Low Cost Air Tickets Online on Domestic & International Flights – SpiceJet", driver.getTitle());
		}catch (Throwable e) {
			System.out.println(e);
		}finally {
			driver.quit();
		} 
 
	}

}