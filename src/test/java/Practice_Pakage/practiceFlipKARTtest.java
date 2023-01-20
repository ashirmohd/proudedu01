package Practice_Pakage;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenericUtilities.WebdriverUtility;

public class practiceFlipKARTtest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		Actions action = new Actions(driver);
	    action.moveByOffset(0, 0).click().build().perform();
	    WebElement data = driver.findElement(By.xpath("//div[text()='Home']"));
	    action.moveToElement(data).perform();
	   WebElement data2 = driver.findElement(By.xpath("//a[text()='Living Room Furniture']"));
	   action.moveToElement(data2).perform();
	  WebElement data3 = driver.findElement(By.xpath("//a[text()='Dining Sets']"));
		action.moveToElement(data3).perform();
		 driver.findElement(By.xpath("//a[text()='Dining Sets']")).click();

     	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollby(600,600)");
	}
	

}
