package playGround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class getProperties {

	public static void main(String[] args) {
		
		String[] osInfos = {"java.version ", "java.vendor", "java.vendor.url", 
				"user.name", "user.home", "user.dir",
				"java.home", "java.class.version", "os.arch",
				"os.name", "java.version", "os.version", 
				"file.separator", "path.separator", "line.separator",};
	
		for (String osInfo : osInfos) {
			String val = System.getProperty(osInfo);
			System.out.println(osInfo + " = " + val);
		}
		
		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
		}
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("default");
		System.out.println("myProfile = " + myProfile);
		
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		System.out.println("dc = " + dc);
		
/*		WebDriver driver = new FirefoxDriver();
		System.out.println(driver.getClass());
		driver.get("http://facebook.com");

		driver.quit();*/
	}

}
