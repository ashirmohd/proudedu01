package Practice_Pakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.WebdriverUtility;

public class worldPopulationtest {

	public static void main(String[] args) {
     WebdriverUtility wblib = new WebdriverUtility();
     WebDriver driver=new ChromeDriver();
     wblib.maximizeWindow(driver);
     wblib.waitForLoadingPage(driver);
     driver.get("https://www.worldometers.info/world-population/");
     String population=driver.findElement(By.xpath("//div[@class='col-md-6']/descendant::span[@rel='current_population']")).getText();
     System.out.println(population);
	}

}
