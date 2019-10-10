package playGround;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testRadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms10.htm");
		
//		driver.findElement(By.xpath("//input[@value='Milk']")).click();
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		
		for (int i=0; i<count; i++) {
			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			System.out.println("at indix " + i + ": text value = " + text);
			if (text.equals("Cheese")) {
				System.out.println("this is inside of if loop, and i =" + i);
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}
		}
		
		driver.quit();
	}

}
