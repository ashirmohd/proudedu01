package Admin_Module;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.Homepage;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.classroompage;

public class create_Classroom_genericTest {

	
	
	public static void main(String[] args) throws Throwable {

		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		
		String browser=flib.getDataFromProperties("Browser");
		String url=flib.getDataFromProperties("URL");
		String usn=flib.getDataFromProperties("USERNAME");
		String pwd=flib.getDataFromProperties("PASSWORD");

		
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wblib.maximizeWindow(driver);
		wblib.waitForLoadingPage(driver);
		
		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("btnSubmit")).click();
		


	    driver.findElement(By.xpath("//span[text()='Classroom']")).click();

	    	String actualdata=null;
	 ArrayList<String> value = elib.getlistUsingArraylist("classroom",0);
	 int lastrownum=elib.readLastrownumb("classroom");
	 System.out.println(lastrownum);
	 for(int i=0;i<=lastrownum;i++) {
		String value1=elib.readExceldata("classroom", i, 1);
	    	driver.findElement(By.name(value.get(i))).sendKeys(value1);
      actualdata=value1;
		 }

	 
	    
   	driver.findElement(By.id("btnSubmit")).click();
    
     String actualvalue = elib.readExceldata("classroom", 0, 1)+jlib.javautil(200);
       
 
    
	    	driver.findElement(By.xpath("//input[@class='form-control input-sm' and @type='search']")).sendKeys(actualdata);
		    String expecteddata = driver.findElement(By.xpath("//td[.='"+actualdata+"']")).getText();
		    if(actualdata.equals(expecteddata)) {
		    	System.out.println("result is present");
		    }else {
		    	System.out.println("result is not present");
		    }

     
    
       
       
       
		    driver.findElement(By.xpath("//span[text()='Admin A']")).click();
		    driver.findElement(By.linkText("Sign out")).click();
		}
	
	    
	   
}

