package Admin_Module;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.Homepage;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.classroompage;
import com.proudEdu.ObjectRepositories.gradepage;
import com.proudEdu.ObjectRepositories.subjectpage;
import com.proudEdu.ObjectRepositories.subjectroutingpage;

public class createSubjectRouting_generictest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=null;
		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		
		int n = jlib.javautil(200);
		String browser=flib.getDataFromProperties("Browser");
		String url = flib.getDataFromProperties("URL");
		String usn = flib.getDataFromProperties("USERNAME");
		String pwd = flib.getDataFromProperties("PASSWORD");
		
		
		
		String value = elib.readExceldata("Subject",0 ,1 )+n;

		
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
		
		

	    driver.findElement(By.xpath("//span[text()='Classroom']")).click();
		
	    String classroomname=null;
	    ArrayList<String> value1 = elib.getlistUsingArraylist("classroom", 0);
	    int data = elib.readLastrownumb("classroom");
	    String expecteddata = elib.readExceldata("classroom", 0, 1)+n;
	    for(int i=0;i<=data;i++) {
	    	String enddata = elib.readExceldata("classroom", i, 1);
	    	driver.findElement(By.name(value1.get(i))).sendKeys(enddata+n);
	    	classroomname=enddata+n;
//	    	
	    

	    
	}
		
    driver.findElement(By.id("btnSubmit")).click();
    	Thread.sleep(5000);
    	
    	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expecteddata);
    	String actualdata = driver.findElement(By.xpath("//td[text()='"+expecteddata+"']")).getText();
    	if(actualdata.contains(expecteddata)) {
    		System.out.println("classroom created");
    	}else {
    		System.out.println("classroom not created");
    	}
    	System.out.println(actualdata);
    	WebElement tblval = driver.findElement(By.name("example1_length"));
    	wblib.select(tblval, "100");
    	String finalclassvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
    	System.out.println(finalclassvalue);
    	
        
   driver.findElement(By.linkText("Grade")).click();
   
   
       ArrayList<String> value2 = elib.getlistUsingArraylist("Grade", 0);
       int data1=elib.readLastrownumb("Grade");
       String expecteddata1 = elib.readExceldata("Grade", 0, 1)+n;
       for(int i=0;i<=data1;i++) {
    	   String value3 = elib.readExceldata("Grade", i, 1);
    	   driver.findElement(By.name(value2.get(i))).sendKeys(value3+n);
       }
       driver.findElement(By.id("btnSubmit")).click();
       driver.findElement(By.id("mark_range_text_1")).sendKeys("78-90");
       driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
       driver.findElement(By.id("btnSubmit1")).click();
       
       Thread.sleep(5000);
       WebElement tblval1 = driver.findElement(By.name("example1_length"));
////   	Select s1=new Select(tblval1);
////   	s1.selectByValue("100");
       wblib.select(tblval1,"100");
   	String finalgradevalue = driver.findElement(By.xpath("(//tbody/descendant::tr[last()]/td[2])[2]")).getText();
	System.out.println(finalgradevalue);
       driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expecteddata1);
   	String actualdata1 = driver.findElement(By.xpath("//td[text()='"+expecteddata1+"']")).getText();
   	if(actualdata1.contains(expecteddata1)) {
   		System.out.println("grade created");
   	}else {
   		System.out.println("grade not created");
   	}
     
       
	
	driver.findElement(By.linkText("Subject")).click();
    driver.findElement(By.id("name")).sendKeys(value);
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
   
     
    
    Thread.sleep(5000);
    
    
    
    WebElement tblval2 = driver.findElement(By.name("example1_length"));
////    Select s2=new Select(tblval2);
////    s2.selectByValue("100");
    wblib.select(tblval2, "100");
    String finalsubjectvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
   	System.out.println(finalsubjectvalue);
    
    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(value);
   	String actualdata2 = driver.findElement(By.xpath("//td[text()='"+value+"']")).getText();
   	if(actualdata2.contains(value)) {
   		System.out.println("subject created");
   	}else {
   		System.out.println("subject not created");
   	}
   	System.out.println(actualdata2);
    
    
    driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();

    
    driver.findElement(By.xpath("//a[text()='Add ']")).click();
    
    WebElement grdedp = driver.findElement(By.id("grade"));
    wblib.select(actualdata, grdedp);
    WebElement subdp = driver.findElement(By.id("subject"));
    wblib.select(actualdata2, subdp);
    WebElement techdp=driver.findElement(By.id("teacher"));
    wblib.select("nawaz1", techdp);
    driver.findElement(By.id("fee")).sendKeys("5000");
    driver.findElement(By.id("btnSubmit")).click();
    
    Thread.sleep(5000);
//    wblib.elementtoVisible(driver, element);
  
    driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(actualdata2);
    String finalvalue = driver.findElement(By.xpath("//td[.='"+actualdata2+"']")).getText();
    if(finalvalue.equals(actualdata2)) {
  	  	System.out.println("subject is created");
    }else {
  	  System.out.println("subject is not created");
    }
    driver.findElement(By.xpath("//span[text()='Admin A']")).click();
	    driver.findElement(By.linkText("Sign out")).click();
     
    
	}
	
}


