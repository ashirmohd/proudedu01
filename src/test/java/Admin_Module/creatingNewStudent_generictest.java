package Admin_Module;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.GenericUtilities.fileUtility;
import com.proudEdu.ObjectRepositories.Homepage;
import com.proudEdu.ObjectRepositories.LoginPage;
import com.proudEdu.ObjectRepositories.addstudentpage;
import com.proudEdu.ObjectRepositories.allstudentpage;
import com.proudEdu.ObjectRepositories.classroompage;
import com.proudEdu.ObjectRepositories.gradepage;
import com.proudEdu.ObjectRepositories.subjectpage;
import com.proudEdu.ObjectRepositories.subjectroutingpage;
import com.proudEdu.ObjectRepositories.timeTablepage;

public class creatingNewStudent_generictest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wblib=new WebdriverUtility();
		
		int n = jlib.javautil(200);
		String browser=flib.getDataFromProperties("Browser");
		String url=flib.getDataFromProperties("URL");
		String usn=flib.getDataFromProperties("USERNAME");
		String pwd=flib.getDataFromProperties("PASSWORD");
		String usn1=flib.getDataFromProperties("USERNAME1");
		String pwd1=flib.getDataFromProperties("PASSWORD");

		
		String subdata = elib.readExceldata("Subject", 0, 1)+n;
		String starttime = elib.readExceldata("timetable", 0, 1);
		String endtime = elib.readExceldata("timetable", 1, 1);
		WebDriver driver=null;
		if(browser.equals("chrome")) {
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

		
		ArrayList<String> classdata = elib.getlistUsingArraylist("classroom", 0);
		int lastvalue = elib.readLastrownumb("classroom");
	    String expecteddata = elib.readExceldata("classroom", 0, 1)+n;
	    String classlastname=null;
		for(int i=0;i<=lastvalue;i++) {
			String classlastvalue = elib.readExceldata("classroom", i, 1);
			driver.findElement(By.name(classdata.get(i))).sendKeys(classlastvalue+n);
			classlastname=classlastvalue+n;
		}
		driver.findElement(By.id("btnSubmit")).click();

		
		WebElement tblval = driver.findElement(By.name("example1_length"));
		
		wblib.select(tblval, "100");
		String finalclassvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
		System.out.println(finalclassvalue);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expecteddata);
    	String actualdata = driver.findElement(By.xpath("//td[text()='"+expecteddata+"']")).getText();
    	if(actualdata.contains(expecteddata)) {
    		System.out.println("classroom created");
    	}else {
    		System.out.println("classroom not created");
    	}
    	System.out.println(actualdata);

		
		driver.findElement(By.linkText("Grade")).click();

		
		
		ArrayList<String> gradedata = elib.getlistUsingArraylist("Grade", 0);
		int lastgradenum = elib.readLastrownumb("Grade");
	    String expecteddata1 = elib.readExceldata("Grade", 0, 1)+n;
		for(int i=0;i<=lastgradenum;i++) {
			String gradelastvalue = elib.readExceldata("Grade", i, 1);
			driver.findElement(By.name(gradedata.get(i))).sendKeys(gradelastvalue+n);

		}
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.id("mark_range_text_1")).sendKeys("78-90");
		driver.findElement(By.id("mark_grade_text_1")).sendKeys("B+");
		driver.findElement(By.id("btnSubmit1")).click();


		Thread.sleep(5000);
		
		WebElement tblval1 = driver.findElement(By.name("example1_length"));
        wblib.select(tblval1, "100");
        String finalgradevalue = driver.findElement(By.xpath("(//tbody/descendant::tr[last()]/td[2])[2]")).getText();
		System.out.println(finalgradevalue);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expecteddata1);
	   	String actualdata1 = driver.findElement(By.xpath("//td[text()='"+expecteddata1+"']")).getText();
	   	if(actualdata1.contains(expecteddata1)) {
	   		System.out.println("grade created");
	   	}else {
	   		System.out.println("grade not created");
	   	}
	   	System.out.println(actualdata1);

		
		
		driver.findElement(By.linkText("Subject")).click();
		driver.findElement(By.id("name")).sendKeys(subdata);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	     

     	Thread.sleep(5000);
		WebElement tblval2 = driver.findElement(By.name("example1_length"));
		wblib.select(tblval2, "100");
		String finalsubjectvalue = driver.findElement(By.xpath("//tbody/descendant::tr[last()]/td[2]")).getText();
		System.out.println(finalsubjectvalue);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(subdata);
	   	String actualdata2 = driver.findElement(By.xpath("//td[text()='"+subdata+"']")).getText();
	   	if(actualdata2.contains(subdata)) {
	   		System.out.println("subject created");
	   	}else {
	   		System.out.println("subject not created");
	   	}
	   	System.out.println(actualdata2);

	     
		driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
		driver.findElement(By.xpath("//a[text()='Add ']")).click();
		
		 WebElement grdedp = driver.findElement(By.id("grade"));
		    wblib.select(actualdata1, grdedp);
		    WebElement subdp = driver.findElement(By.id("subject"));
		    wblib.select(actualdata2, subdp);
		    WebElement techdp=driver.findElement(By.id("teacher"));
		    wblib.select("nawaz1", techdp);
		    driver.findElement(By.id("fee")).sendKeys("5000");
		    driver.findElement(By.id("btnSubmit")).click();

		    
		    Thread.sleep(5000);
		    
		    driver.findElement(By.linkText("Timetable")).click();
			WebElement valuetime = driver.findElement(By.id("grade"));
			wblib.select(actualdata1, valuetime);
			driver.findElement(By.xpath("//button[.='Submit']")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm pull-right' and text()='Add ']")).click();

			WebElement dayval = driver.findElement(By.id("day"));
			wblib.select("Wednesday", dayval);
			WebElement subval = driver.findElement(By.id("subject"));
            wblib.select(actualdata2, subval);
    		WebElement tecval = driver.findElement(By.id("teacher"));
            wblib.select("nawaz1", tecval);
    		WebElement classval = driver.findElement(By.name("classroom_id"));
            wblib.select(actualdata, classval);
            driver.findElement(By.id("start_time")).sendKeys(starttime);
    		driver.findElement(By.id("end_time")).sendKeys(endtime);
    		driver.findElement(By.id("btnSubmit")).click();
    		Thread.sleep(5000);
    		String actualtable="Timetable - "+actualdata1+"";
    		String exe = driver.findElement(By.xpath("//h3[.='Timetable - "+actualdata1+"']")).getText();
    		if(actualtable.contains(exe)) {
    			System.out.println("timetable is created");
    		}else {

    			System.out.println("timetable is not  created");
    		}
    		System.out.println(actualdata);

		    
		    
    		driver.findElement(By.xpath("//span[.='Student']")).click();
    		driver.findElement(By.xpath("//a[.=' Add Student']")).click();
		    Thread.sleep(5000);
		  

		    
            ArrayList<String> al = elib.getlistUsingArraylist("student", 0);
            int readlastdata = elib.readLastrownumb("student");
            for(int i=0;i<=readlastdata;i++) {
            	String data = elib.readExceldata("student",i, 1);
            	driver.findElement(By.name(al.get(i))).sendKeys(n+data);
            }
            WebElement sel = driver.findElement(By.id("gender"));
    		wblib.select("Male", sel);
            WebElement sel1 = driver.findElement(By.id("g_gender"));
            wblib.select("Male", sel1);
            driver.findElement(By.id("fileToUpload")).sendKeys("C:\\Users\\ashir\\Desktop\\image1.png");
            driver.findElement(By.id("g_fileToUpload")).sendKeys("C:\\Users\\ashir\\Desktop\\image1.png");
            driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		    

		    
		    
            WebElement grade = driver.findElement(By.id("grade"));
                wblib.select(actualdata1, grade);
                Thread.sleep(2000);
                driver.findElement(By.id("checkbox")).click();
        		driver.findElement(By.xpath("//button[@id='btnSubmit1']/child::span")).click();
        		driver.findElement(By.xpath("//div[@class='panel panel-info']/descendant::span[@class='glyphicon glyphicon-remove']")).click();
       		 driver.findElement(By.xpath("//span[text()='Student']")).click();
        	    driver.findElement(By.xpath("//a[text()=' All Student']")).click();
        	   WebElement sel3 = driver.findElement(By.id("grade"));
        	   wblib.select(actualdata1, sel3);
		   
//        	 //logout as Admin
       		driver.findElement(By.xpath("//span[.='Admin A']")).click();
       		driver.findElement(By.xpath("//a[.='Sign out']")).click();
       		
//       	//login as Teacher
    		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(usn1);
    		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pwd1);
    		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
    		
    		driver.findElement(By.xpath("//span[.='My Student']")).click();
    		WebElement g1 = driver.findElement(By.id("grade"));
    		wblib.select(actualdata1, g1);
    		




        		

	}
}