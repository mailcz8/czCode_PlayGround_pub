package playGround;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class chromTest {

	public static void main(String[] args) {
		String os = System.getProperty("os.name").toLowerCase();
		String testURL = "http://book.spicejet.com/";
		System.out.println(System.getProperty("user.dir") + "/Chromedriver");
				
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		}
		
		WebDriver driver=new ChromeDriver();
		
		try {
			driver.get(testURL);
			System.out.println(driver.getTitle());
			Assert.assertEquals("Book Low Cost Air Tickets Online on Domestic & International Flights – SpiceJet", driver.getTitle());
			System.out.println("Test passed!");
		}catch (Throwable e) {
			System.out.println(e);
		}finally {
			driver.quit();
		} 
 
	}

}
