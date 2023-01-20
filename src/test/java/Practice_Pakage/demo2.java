package Practice_Pakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class demo2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		 Actions action = new Actions(driver);
		    action.moveByOffset(0, 0).click().build().perform();
		    boolean value = driver.findElement(By.xpath("//span[text()='RETURN']")).isEnabled();
		    System.out.println(value);
		    if(value==false) {
		    	System.out.println("invalid");
		    }else {
		 driver.findElement(By.xpath("//span[@class='tabsCircle appendRight5']/../../../../descendant::span[2]")).click();
		    }
		   
               

	}

}
