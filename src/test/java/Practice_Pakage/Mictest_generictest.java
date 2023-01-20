package Practice_Pakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.GenericUtilities.WebdriverUtility;

public class Mictest_generictest {

	public static void main(String[] args) throws Throwable {
		WebdriverUtility wblib = new WebdriverUtility();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("use-fake-ui-for-media-stream");
		WebDriver driver=new ChromeDriver(option);
		wblib.maximizeWindow(driver);
		wblib.waitForLoadingPage(driver);
		driver.get("https://mictests.com/");
		driver.findElement(By.id("mic-launcher")).click();
		
		String actualvalue = driver.findElement(By.id("mic-visualizer")).getText();
		Thread.sleep(2000);
		String expectedvalue = driver.findElement(By.id("mic-visualizer")).getText();
		if(actualvalue.equals(expectedvalue)) {
			System.out.println("pass");
			
		}else {
			System.out.println("fail");
		}
		driver.close();
		
		

	}

}
