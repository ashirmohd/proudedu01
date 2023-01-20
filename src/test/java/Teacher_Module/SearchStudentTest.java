
package Teacher_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchStudentTest {

	public static void main(String[] args) throws Throwable {
		Random r=new Random();
		int random = r.nextInt(500);
		 
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("URL");
		String usn=p.getProperty("USERNAME1");
		String pwd=p.getProperty("PASSWORD1");
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testdata45.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet shee = wb.getSheet("student");
		String data = shee.getRow(0).getCell(1).getStringCellValue();
		String data1 = shee.getRow(1).getCell(1).getStringCellValue();
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("btnSubmit")).click();
	    
	    driver.findElement(By.linkText("My Student")).click();
	    WebElement value = driver.findElement(By.id("grade"));
	    Select s=new Select(value);
	    s.selectByVisibleText(data);
	    driver.findElement(By.xpath("//button[@onclick='showStudentTable(this)']")).click();
	    
	    driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(data1);
	    String finalvalue = driver.findElement(By.xpath("//td/a[text()='"+data1+"']")).getText();
	    if(data1.equalsIgnoreCase(finalvalue)) {
	    	System.out.println("it is displayed");
	    }
	    else {
	    	System.out.println("it is not displayed");
	    }
	    driver.findElement(By.xpath("//span[text()='arun pratap']")).click();
	    driver.findElement(By.linkText("Sign out")).click();
	    
	    
	    
		
	}

}
