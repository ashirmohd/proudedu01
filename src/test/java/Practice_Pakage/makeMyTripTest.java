package Practice_Pakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.WebdriverUtility;

public class makeMyTripTest {

	public static void main(String[] args) throws Throwable {
    WebdriverUtility wblib = new WebdriverUtility();
    ExcelUtility elib = new ExcelUtility();
    WebDriver driver=new ChromeDriver();
    wblib.maximizeWindow(driver);
    wblib.waitForLoadingPage(driver);
    driver.get("https://www.makemytrip.com/");
    Actions action = new Actions(driver);
    action.moveByOffset(0, 0).click().build().perform();
    driver.findElement(By.xpath("//span[@class='chNavText darkGreyText' and text()='Buses']")).click();
    Thread.sleep(2000);
    String data1 = elib.readExceldata("MakeMyTrip", 0, 1);
    String data2 = elib.readExceldata("MakeMyTrip", 1, 1);
    driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/child::div/input")).sendKeys("bangalore");
//    driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']")).click();
//    driver.findElement(By.id("toCity")).sendKeys(data2);
    
	}

}
