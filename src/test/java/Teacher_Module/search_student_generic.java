package Teacher_Module;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.searchStudentPage;
import com.proudEdu.ObjectRepositories.teacherhomepage;

public class search_student_generic {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		
		int n = jlib.javautil(200);
		String browser=flib.getDataFromProperties("Browser");
		String url = flib.getDataFromProperties("URL");
		String usn = flib.getDataFromProperties("USERNAME1");
		String pwd = flib.getDataFromProperties("PASSWORD");
		
		
		String value = elib.readExceldata("student",0 ,1 );
		String value1 = elib.readExceldata("student", 1, 1);
		
		String name="chrome";
		if(browser.equals(name)) {
			 driver=new ChromeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		//WebDriver driver=new ChromeDriver();
		driver.get(url);
		wblib.maximizeWindow(driver);
		wblib.waitForLoadingPage(driver);
		
		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("btnSubmit")).click();
		

	    driver.findElement(By.linkText("My Student")).click();
	    WebElement value2 = driver.findElement(By.id("grade"));
		
		
		
		
	    wblib.select(value,value2);
	    driver.findElement(By.xpath("//button[@onclick='showStudentTable(this)']")).click();
	    driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(value1);
	    String finalvalue = driver.findElement(By.xpath("//td/a[text()='"+value1+"']")).getText();
	    if(value1.equalsIgnoreCase(finalvalue)) {
	    	System.out.println("it is displayed");
	    }
	    else {
	    	System.out.println("it is not displayed");
	    }
	    driver.findElement(By.xpath("//span[text()='arun pratap']")).click();
	    driver.findElement(By.linkText("Sign out")).click();

	    
	}
}
