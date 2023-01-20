package Practice_Pakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice_1 {
	
	public static void main(String[] arg) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.linkText("Best Sellers")).click();
//		WebElement link = driver.findElement(By.linkText("IMDb"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollto(0,500)");
//		js.executeScript("argument[0].scrollIntoView(true)",link);
		
		
		
		
	}
	
	

}
