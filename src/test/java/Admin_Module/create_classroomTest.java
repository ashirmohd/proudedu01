
package Admin_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class create_classroomTest {

	public static void main(String[] args) throws Throwable {
		Random r=new Random();
		int random = r.nextInt(500);
		 
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("URL");
		String usn=p.getProperty("USERNAME");
		String pwd=p.getProperty("PASSWORD");
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testdata45.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("classroom");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("btnSubmit")).click();

	    driver.findElement(By.xpath("//span[text()='Classroom']")).click();
	    
	    ArrayList<String> data= new ArrayList<String>();
	    data.add("name");
	    data.add("student_count");
	    String actualdata=null;
	    for(int i=0;i<=sh.getLastRowNum();i++) {
	    	String data1 = sh.getRow(i).getCell(1).getStringCellValue()+random;
	    	driver.findElement(By.id(data.get(i))).sendKeys(data1);
	    	actualdata=data1;
	    }
	    
	    	driver.findElement(By.id("btnSubmit")).click();
	    	Thread.sleep(5000);
	//    	String expecteddata =null;
//	    try {
//	    	List<WebElement> vale = driver.findElements(By.xpath("//tbody/tr/td[2]"));
//	    	int count = vale.size();
//	    	System.out.println(count);
//	    	for(int i=0;i<=count;i++) {
//	    		 expecteddata = vale.get(i).getText();
//	    	}
	   // if(actualdata.equals(expecteddata)) {
	   	//	System.out.println("its is present");
	   // 	}else {
	   // 		System.out.println("its is not present");
	    //	}
	 //   }
	 //   	catch(Exception e) {
	//    		driver.findElement(By.linkText("Next")).click();
//	    	}
//	    finally {
//	    if(actualdata.contains(expecteddata)) {
//	   		System.out.println("its is present");
//	    	}else {
//	    		System.out.println("its is not present");
//	    	}
//	   // }
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
